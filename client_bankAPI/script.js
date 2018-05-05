//helper function
let cl = x=>console.log(x)
//uri to resource
let uri = "http://localhost:49000/banking/customers"
//ele is used in ajax call to build html elements
let ele
//standarized settings for ajax call
let settings = {
  "async": true,
  "crossDomain": true,
  "url": uri,
  "method": "GET",
  "headers": {
    "Cache-Control": "no-cache",
  }
}


//standarized api call, takes path to resource and function to execute on api response
function apiCall(uri, method){
    $.ajax(settings)
        .done(response=>{method(response)})
}

// -----------------------------   LOGIN
//listener
$('#login').click( login )

function login(uri){
    let status = false;
    //get login and password from the form
    userName = $('#loginName').val()
    password = $('#password').val()
    //call api that returns Customer json object
    apiCall(uri, mapThrough)
}
// function that return map that traverses json and compares input to values
function mapThrough(response){
    cl('from map throu function ' + response)
    cl(response.loginName)
     response.map( obj=>{
                    if(obj.loginName == userName && obj.password == password){
                        enter(obj)
                    }
                }) 
}
//make login forms visible upon logging in
function enter(obj){
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
/*

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
function display(){

}