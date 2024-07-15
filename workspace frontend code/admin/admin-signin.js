let email=document.getElementById("email")
let pwd=document.getElementById("pwd")
let span=document.getElementsByTagName("span")
let submit=document.getElementById("submit")

console.log(email);
console.log(pwd);
console.log(submit);
console.log(span);
submit.addEventListener("click", async (e)=>{
    e.preventDefault()
    if(email.value ===""){
        span[0].innerHTML="This field should not be empty"
        span[0].style.color="#eb7c0c"
        email.style.borderColor="#eb7c0c"

    }
    if(pwd.value ===""){
        span[1].innerHTML="This field should not be empty"
        span[1].style.color="#eb7c0c"
        email.style.borderColor="#eb7c0c"

    }
    if(email.value !=""&&pwd.value !=""){
       
        try{
          const response = await fetch(`http://localhost:8080/loginAdmin?email=${email.value}&Password=${pwd.value}`);
          console.log(response);
          let x = await response.json();
          console.log(x);
          console.log(response.status);
          console.log("hello");
          let obj = JSON.stringify(x);
          if(response.status==302){
            window.localStorage.setItem('Admin_id', x.data.id);
            window.localStorage.setItem('Admin_name', x.data.name);
            window.localStorage.setItem('Admin_email', x.data.email);
            window.localStorage.setItem('Admin_phone', x.data.phone);
            window.localStorage.setItem('Admin_pwd', x.data.pwd);
            window.localStorage.setItem('Admin_addressid', x.data.address.id);
            window.localStorage.setItem('Admin_doorNo', x.data.address.doorNo);
            window.localStorage.setItem('Admin_street', x.data.address.street);
            window.localStorage.setItem('Admin_district', x.data.address.district);
            window.localStorage.setItem('Admin_landmark', x.data.address.landmark);
            window.localStorage.setItem('Admin_state', x.data.address.state);
            window.localStorage.setItem('Admin_city',x.data.address.city);
            window.localStorage.setItem('Admin_pincode', x.data.address.pincode);
            window.alert("login done")
            function o() {
              window.open(URL="http://127.0.0.1:5500/FRONT-END/FRONT-END/admin/admin-crud.html","_blank");
            }
        
            o();

          }
         
          
        } catch (error) {

          window.alert("error",error)
          
        }

      }
      else{
        window.alert("Please enter valid details");


    }

},false)