// *********Displaying The customer Details ********************************

let cname = document.querySelector('#name');
let email = document.querySelector('#email');
let pass =document.querySelector('#pass')
let phone = document.querySelector('#phno');
let gender = document.querySelector('#gender');
let age = document.querySelector('#age');
let id_proof=document.getElementById("id_proof")
let profile = document.querySelector('.profile');
profile.innerHTML = "Hello";
let dno = document.querySelector('#dno');
let lmark = document.querySelector('#lmark');
let street = document.querySelector('#street');
let district = document.querySelector('#district');
let state = document.querySelector('#state');
let pincode = document.querySelector('#pincode');

async function customerById(){
  try{
    const client = await fetch(`http://localhost:8080/fetchClientById?client_id=${localStorage.getItem('client_id')}`,{
      method: 'GET',
      headers: {
        "Content-Type": "application/json",
      },
    });
    let clientdata =await client.json();
    console.log(clientdata);

    cname.innerHTML = clientdata.data.name;
    email.innerHTML = clientdata.data.email;
    pass.innerHTML =  clientdata.data.pwd;
    phone.innerHTML = clientdata.data.phone;
    gender.innerHTML = clientdata.data.gender;
    age.innerHTML= clientdata.data.age;
    id_proof.innerHTML=clientdata.data.id_proof
    profile.innerHTML = '<i class="fa-solid user2 fa-user-tie"></i>';

    dno.innerHTML = clientdata.data.address.door_no;
    lmark.innerHTML = clientdata.data.address.landmark;
    street.innerHTML = clientdata.data.address.street;
    district.innerHTML = clientdata.data.address.district;
    state.innerHTML = clientdata.data.address.state;
    pincode.innerHTML = clientdata.data.address.pincode;  
  }
  catch(error) {
    alert("error occured while fetching customer by id")
  }
}
customerById();





// *************Delete Customer ********************************

// let id = window.localStorage.getItem("client_id");

let del = document.querySelector('#del');

del.addEventListener('click',async (e)=>{
  e.preventDefault();

  try {
    const response = await fetch(`http://localhost:8080/deleteClient?client_id=${localStorage.getItem('client_id')}`,
    {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    });

  
  if(response.ok){
    window.localStorage.clear();
    window.alert("Customer deleted successfully...! ");
    
    function o() {
      open(URL="./client-signup.html","_self");
    }

    o();
   }
  }
  catch(error){
    window.alert('Error Occured In Deletion Of Customer');
  }

});


// **************** Client Logout ****************

let lbtn = document.querySelector('.lbtn');

lbtn.addEventListener('click',()=>{
  localStorage.clear();
  function o() {
    open(URL="./client-signin.html","_self");
  }
  alert("Logout completed Successfully");
  o();
});


// ***************** TO Update Client ****************
let updatecustomer = document.querySelector('.updatecustomer');

updatecustomer.addEventListener('click', ()=>{
  function a() {
    open(URL="http://127.0.0.1:5500/Client/client-update.html","_self");
  }
  a();
});