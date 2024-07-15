let aid = window.localStorage.getItem("Admin_id");
let adress_id = window.localStorage.getItem("Admin_addressid");
let admin_name=document.getElementById("name")
let email=document.getElementById("email")
let pwd=document.getElementById("password")
let phone=document.getElementById("phone")
let do_number=document.getElementById("dno")
let landmark = document.getElementById("landmark")
let street=document.getElementById("street")
let city=document.getElementById("city")
let district=document.getElementById("district")
let state=document.getElementById("state")
let pincode=document.getElementById("pincode")





//
let ele=document.getElementsByName("gender")
let pwdvaild= document.getElementById("pass")
let phonevalid=document.getElementById("phonevailid")
//

let Submit=document.getElementById("Submit")


let id = window.localStorage.getItem("Admin_id");

phone.addEventListener("keyup",(e)=>{

  let ph=/^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/

  if(ph.test(phone.value)===false){

      phonevalid.innerHTML="enter valid phone number"
      phonevalid.style.color='red'
      phone.style.borderColor='red'

  }
  else{
      phonevalid.innerHTML=" Mobile Number Format is valid"
      phonevalid.style.color='green'
      phone.style.borderColor='green'
      phone.style.borderWidth="2px"
  
  }


})
//password validation checking

pwd.addEventListener("keyup", (e)=>{

  let upper = /[A-Z]/ ;
  let lower = /[a-z]/  ;
  let num = /[0-9]/ ;
  let spc = /[(?=.*-\/:-@\[-\`{-~]/ ; 
  let len=8

  if(upper.test(pwd.value) === false){
     pwdvaild.innerHTML='this field should contain Upper case  characters'
     pwdvaild.style.color='red'
     pwd.style.borderColor = 'red';
   }
   else if(lower.test(pwd.value) === false){
     pwdvaild.innerHTML='this field should contain lower case  characters'
     pwdvaild.style.color='red'
     pwd.style.borderColor = 'red';
    
   }
     
   else if(num.test(pwd.value) === false){
     pwdvaild.innerHTML='this field should contain number  '
     pwdvaild.style.color='red'
     pwd.style.borderColor = 'red';
   }
   else if(spc.test(pwd.value) === false){
     pwdvaild.innerHTML='this field should contain special  characters'
     pwdvaild.style.color='red'
     pwd.style.borderColor = 'red';
   }
   else{
     pwdvaild.innerHTML = ' strong password  created';
     pwdvaild.style.color="green"
     pwd.style.borderColor = 'green';
   }

})


/*
      // frontend and  backend integration  in this below  function

1)with this method iam checking from validation 
2) iam again iam  doing  null checking 
3)if it pass null check then
4)try/catch blocks
      i)if its enter into try block operation is ok  it will  go to login page 
      ii)else alert message something went wrong

5)else block something went wrong same page 

*/

Submit.addEventListener("click" , async (e)=>{

    e.preventDefault();

    let span=document.getElementsByTagName("span")
    console.log(span);

    //!name filed should not be empty
    if(admin_name.value===''){
        span[0].innerHTML='This field should not empty'
        span[0].style.color="red"
        admin_name.style.borderColor="red"

    }
    else{
        admin_name.style.borderWidth="2px"
        admin_name.style.borderColor="green"
        span[0].style.visibility="hidden"
        }


    //!email filed should not be empty

    if(email.value===''){
      span[1].innerHTML='This field should not empty'
      span[1].style.color="red"
      email.style.borderColor="red"
    
      }
    else{
        email.style.borderWidth="2px"
        email.style.borderColor="green"
        span[1].style.visibility="hidden"
        }

     //!password filed should not be empty & strong password
     

     if(pwd.value===''){
        span[2].innerHTML='This field should not empty'
        span[2].style.color="red"
        pwd.style.borderColor="red"
        
        }
      else{
        pwd.style.borderWidth="2px"
        pwd.style.borderColor="green"
        span[2].style.visibility="hidden"

          }
     //!phone should not be empty
     if(phone.value===''){
        span[3].innerHTML='This field should not empty'
        span[3].style.color="red"
        phone.style.borderColor="red"
        
        }
      else{
        phone.style.borderWidth="2px"
        phone.style.borderColor="green"
        span[3].style.visibility="hidden"

          }
     
   //!do_number sholud not be empty 
    if(do_number.value===''){

      span[4].innerHTML='This field should not empty'
      span[4].style.color="red"
      do_number.style.borderColor="red"
          
     }
    else{

      do_number.style.borderWidth="2px"
      do_number.style.borderColor="green"
       span[4].style.visibility="hidden"

      }
    //!landmark sholud not be empty 
    if(landmark.value===''){
      span[5].innerHTML='This field should not empty'
      span[5].style.color="red"
      landmark.style.borderColor="red"
      
      }
    else{
      landmark.style.borderWidth="2px"
      landmark.style.borderColor="green"
      span[5].style.visibility="hidden"
      }
      //! street should not be empty
      if(street.value===''){
        span[6].innerHTML='This field should not empty'
        span[6].style.color="red"
        street.style.borderColor="red"
        
        }
      else{
        street.style.borderWidth="2px"
        street.style.borderColor="green"
        span[6].style.visibility="hidden"
        }
        //!city should not be empty
              
    if(city.value===''){
        span[7].innerHTML='This field should not empty'
        span[7].style.color="red"
        city.style.borderColor="red"
        
        }
      else{
        city.style.borderWidth="2px"
        city.style.borderColor="green"
        span[7].style.visibility="hidden"
        }
          //!district should not be empty
    if(district.value===''){

        span[8].innerHTML='This field should not empty'
        span[8].style.color="red"
        district.style.borderColor="red"
        
        }
    else{
        district.style.borderWidth="2px"
        district.style.borderColor="green"
        span[8].style.visibility="hidden"
     }

    //!state should not be empty
    if(state.value===''){
       span[9].innerHTML='This field should not empty'
       span[9].style.color="red"
       state.style.borderColor="red"
          
       }
    else{
      state.style.borderWidth="2px"
      state.style.borderColor="green"
      span[9].style.visibility="hidden"
      }

    //! pincode  should not be empty
    if(pincode.value===''){

       span[10].innerHTML='This field should not empty'
       span[10].style.color="red"
       pincode.style.borderColor="red"
            
        }
     else{

     pincode.style.borderWidth="2px"
     pincode.style.borderColor="green"
     span[10].style.visibility="hidden"

      } 
      //@ Integration started 


      if(aid.value !=""&&  admin_name.value !="" && email.value!="" && pwd.value !="" && phone.value !=""  && do_number.value !="" && landmark !=""&&street.value !="" &&city.value && district.value !="" && state.value !=""&& pincode.value !=""){


        const admin={
          "id":aid,
          "name":admin_name.value,
          "email":email.value,
          "phone":phone.value,
          "pwd":pwd.value,

          "address":{
            "id":adress_id,
            "door_No":do_number.value,
            "landmark":landmark.value,
            "street":street.value,
            "city":city.value,
            "district":district.value,
            "state":state.value,
            "pincode":pincode.value
          }

        }
        console.log("Hii json crossed");

        try {

       const response=await fetch("http://localhost:8080/updateAdminAlongWithAdress",
            {
              method:"PUT",

              headers:{
                "Content-Type": "application/json",

              },
              
              body: JSON.stringify(admin),

            });
            
            if(response.status==302){
              console.log("updted");
              const data = await response.json();
              console.log(data);
              window.alert("Congratulations you have updated successfully Admin Account 🥳🥳🥳");
              
              function o() {
                window.open(URL="http://127.0.0.1:5500/FRONT-END/admin/admindashboard.html","_self");
              }
          
              o();
            }
            
            if (response.status >= 400) {
              console.log(" not updted");
              window.alert("something went wrong  Try To Login 😕😕😕");

              for(var i = 0; i< input.length; i++){
                
                input[i].style.borderColor = 'red';
              }

            }
          
        } catch (error) {

          window.alert("error",error)
          
        }

      }
      else{
        window.alert("Please enter valid details");
      }

},false)