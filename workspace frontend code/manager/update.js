
let id=document.getElementById("id");
let name = document.getElementById('name');
let email = document.getElementById('email');
let phone = document.getElementById('phone');
       


     

    //password validation..................
    let p= document.getElementsByTagName("p")
    password.addEventListener("keyup",()=>{
      let spl=/^(?=.*\W)^/
      let number=/^(?=.*\d)^/
      let upper=/^(?=.*[A-Z])^/
      let lower=/^(?=.*[a-z])^/
      let pwd= password.value
      let size=/(?=.*[a-z])(?=.*[A-Z]).{8,}/
      // const pattern = /^(?=.\d)(?=.[~`!@#$%^&()--+={}\[\]|\\:;"'<>,.?/_₹])(?=.[a-z])(?=.*[A-Z]).{8,}$/;
      if(!upper.test(pwd)){
          p[0].innerText="should contain at least one upper case"
      }
      else if(!spl.test(pwd) ) {
          p[0].innerText="should contain at least one special characters"
      }
      else if(!number.test(pwd)){
          p[0].innerText="should contain at least one digit"
      }
      else if(!lower.test(pwd)){
          p[0].innerText="should contain at least one lower case"
      }
      else if(!size.test(pwd)){
          p[0].innerText="should contain at least 8 from the mentioned characters"
      }
      else{
          p[0].innerText="" 
      }
  })
let submit=document.getElementById("submit")
submit.addEventListener("click",async(e) =>{
  e.preventDefault()
    let manager={
      "name":name.value,
      "email":email.value,
      "phone":phone.value,
      "pwd":password.value,
      // "gender":"",
      // "experiance":"",
      // "address":{
      //     "door_No":"",
      //     "landmark":"",
      //     "street":"",
      //     "city":"",
      //     "state":"",
      //     "district":"",
      //     "pincode":""        
      // }
      }
    try{
      console.log(id.value)
      const response = await fetch(`http://localhost:2001/updateManager?id=${id.value}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(manager),
      });
      
    let data = await response.json();
    // console.log(data.status)
    if(data.status == 201){
      alert("Work updated successfully");

      console.log(data);
      
      function o() {
        open(URL="http://127.0.0.1:5500/manager/manager-home.html","_self");
      }
  
      o();

    }
    else{
      alert("Work not updated successfully");
    }
}
catch(error){
  window.alert( error,"hi");
}
})

  