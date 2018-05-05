//helper function
let cl = x=>console.log(x)
//
let uri="http://localhost:49000/banking/customers"
//currently logged in user
let currentUser
//standarized settings for ajax call
let settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:49000/banking/customers",
  "method": "GET",
  "headers": {
    "Cache-Control": "no-cache",
  }
}

//helper function
function resetSettings(){
    settings ={}
    settings = {
      "async": true,
      "crossDomain": true,
      "url": uri,
      "method": "GET",
      "headers": {
        "Cache-Control": "no-cache",
      }
    }
}

//standarized api call, takes path to resource and function to execute on api response
function apiCall(uri, method){
    //update uri
    settings.url = uri
    //make a call
    $.ajax(settings)
        .done(response=>{cl(response); method(response)})
}

// -----------------------------   LOGIN
//listener
$('#login').click( login )

function login(){
    uri = "http://localhost:49000/banking/customers"
    //get login and password from the form
    userName = $('#loginName').val()
    password = $('#password').val()
    //call api that returns Customer json object
    apiCall(uri, mapThrough)
}
// function that return map that traverses json and compares input to values
function mapThrough(response){
     response.map( obj=>{
                    if(obj.loginName == userName && obj.password == password){
                        enter(obj)
                    }
                }) 
}
//make login forms visible upon logging in
function enter(obj){
    currentUser = obj;
    $('#inputsForm').css("visibility", "visible")
    $('#greeting').html('welcome ' + obj.name)
}

// ----------------   CREATE NEW USER
//listener
$('#createUser').click(newUserMakeFormsVisible)
$('#submitNewUser').click(createNewUser)

function newUserMakeFormsVisible(){
    $('#newUserinputsForm').css("visibility", "visible")    
}
//create new user
function createNewUser(){
    //define uri
    uri="http://localhost:49000/banking/customers"
    //get data from input forms
    let name = $('#newUserName').val()
    let address = $('#newUserAddress').val()
    let loginName = $('#newUserLogin').val()
    let password = $('#newUserPassword').val()
    let customer = '{\t\n\t\"name\":\"' + name + '\",\n\t\"address\":\"' + address + '\",\n\t\"loginName\":\"' + loginName + '\",\n\t\"password\":\"' + password + '\"\n\t\n}'
    //adjust ajax options 
    settings.method = "POST"
    settings.headers["Content-Type"]="application/json"
    settings.processData = false
    settings.data = customer
    //api call
    apiCall(uri, cl)
    //clear fields
    $('#newUserName').val('')
    $('#newUserAddress').val('')
    $('#newUserLogin').val('')
    $('#newUserPassword').val('')
    //login
    $('#loginName').val(loginName)
    $('#password').val(password)
    
    //reset settings
    resetSettings()

}

// ----------------- GET ALL ACCOUNTS for user
//listener
$('#listAccounts').click( listAccounts )
//list accounts in display area
function listAccounts(){
    let url = uri + "/" + currentUser.id + "/accounts"
    apiCall(url, displayElements )
}
//append elements to display area
function displayElements(response){
    let ele
    //empty element
    $('#display').empty()
    //map throu all elements and create html string
    response.map( obj=>{
                    cl(obj)
                    ele += "<div id='response' style='border:blue 1px solid'>"
                    for(x in obj){
                        if(x == "type"){
                            ele +="<div> Account name:    " + obj[x] + "</div>"
                        }
                        if(x == "number"){
                            ele +="<div> Account number:    " + obj[x] + "</div>"
                        }
                        if(x == "sortCode"){
                            ele +="<div> Account sort code:   " + obj[x] + "</div>"
                        }
                        
                    }
                    ele +="<hr/></div>"
                })
    //append
    document.getElementById("display").innerHTML = ele;
}

// ------------------------ CREATE ACCOUNT
//listener
$('#createAccount').click( createAccount )

function createAccount(){
    //define uri
    uri="http://localhost:49000/banking/customers"
    //construct url to be passed in
    let url = uri + "/" + currentUser.id + "/accounts"
    //get name value
    let accountName = $('#accountName').val()
    //if name empty
    if(accountName==""){alert('enter name'); return}
    //data to be sent
    let type = '{\"type\": \"' + accountName + '\"\n    }'
    //adjust ajax options 
    settings.method = "POST"
    settings.headers["Content-Type"]="application/json"
    settings.processData = false
    settings.data = type
    //api call
    apiCall(url, function(x){alert('Account has been created')})
    //reset settings
    resetSettings()
}

// -------------- GET ACCOUNT BALANCE
$('#balance').click( getBalance )
//get account
function getBalance(){
    //define uri
    uri="http://localhost:49000/banking/customers"
    //get account number
    let accountNumber = $('#accountNumber').val()
    
    //check if empty
    if(accountNumber == ""){alert('enter ac number'); return}
    //construct url to be passed in
    //let url = uri + "/" + currentUser.id + "/accounts/"+ accountNumber +"/balance"
    let url = uri + "/" + currentUser.id + "/accounts"
    //api call
    apiCall(url, displayBalance )
    //reset settings
    resetSettings()
}
//extract balance from account and display it
function displayBalance(response){
    let bal
    response.map( obj=>{
                        for(x in obj){
                            let accountNumber = $('#accountNumber').val()
                            if(x == "number" && obj["number"] == accountNumber){
                                bal = obj["currentBalance"]
                            }
                    }
                })
    //append
  
    $('#balanceDisplay').html(bal)
}

// 


/*

// SEND API CALL
function send(uri){
    $.ajax(settings)
        .done( response=> {
            response.map( obj=>{
                cl(obj)
                ele += "<div id='response'>"
                for(x in obj){
                    ele +="<div>" + obj[x] + "</div>"
                }
                ele +="<hr/></div>"
            })
            document.getElementById("display").innerHTML = ele;
        })
}

function send(uri){
    $.ajax(settings)
        .done( response => {
            response.map( y=>{
                ele += "<div id='wrapper'>"
                for(x in obj){
                    ele +="<div>" + obj[x].name + "</div>"
                }
                ele +="</div>"
                document.getElementById("display").innerHTML = ele;
            })  
            
        })
}
*/
