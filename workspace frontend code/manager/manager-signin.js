let name=document.getElementById("name")
let phone=document.getElementById("phone")
let email=document.getElementById("email")
let password=document.getElementById("password")
let experiance=document.getElementById("experiance")
let houseno=document.getElementById("houseno")
let landmark=document.getElementById("landmark")
let streetname=document.getElementById("streetname")
let city=document.getElementById("city")
let pincode=document.getElementById("pincode")

let spl=/^(?=.*\W)^/
let number=/^(?=.*\d)^/
let upper=/^(?=.*[A-Z])^/
let lower=/^(?=.*[a-z])^/
let size=/(?=.*[a-z])(?=.*[A-Z]).{8,}/


// ******************name validation*************************
name.addEventListener("keyup",()=>{
    let res=/^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$/
    if(res.test(name.value)){
        p[0].innerText=""
    }
    else{
        p[0].innerText="Invaid name"
    }
})

// ******* password ******
let p=document.getElementsByTagName("p");
password.addEventListener("keyup",()=>{
    let spl=/^(?=.*\W)^/
    let number=/^(?=.*\d)^/
    let upper=/^(?=.*[A-Z])^/
    let lower=/^(?=.*[a-z])^/
    let pwd= password.value
    let size=/(?=.*[a-z])(?=.*[A-Z]).{8,}/
    // const pattern = /^(?=.\d)(?=.[~`!@#$%^&()--+={}\[\]|\\:;"'<>,.?/_₹])(?=.[a-z])(?=.*[A-Z]).{8,}$/;
    if(!upper.test(pwd)){
        p[2].innerText="should contain at least one upper case"
    }
    else if(!spl.test(pwd) ) {
        p[2].innerText="should contain at least one special characters"
    }
    else if(!number.test(pwd)){
        p[2].innerText="should contain at least one digit"
    }
    else if(!lower.test(pwd)){
        p[2].innerText="should contain at least one lower case"
    }
    else if(!size.test(pwd)){
        p[2].innerText="should contain at least 8 from the mentioned characters"
    }
    else{
        p[2].innerText="" 
    }
})
/*********  phone no  ********/
phone.addEventListener("keyup",()=>{
    let ph=/^[1-9]{1}[0-9]{9}$/
    let phno=phone.value
    console.log(ph.test(phno))
    if(!ph.test(phno)){
        p[3].innerText="should contain only 10 digit"
    }
    else{
        p[3].innerText=""
    }
})
/********  email  *****/ 
email.addEventListener("keyup",()=>{
    let res=/^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$/
    if(res.test(email.value)){
        p[1].innerText=""
    }
    else{
        p[1].innerText="Invaid email"
    }
})

/********** experiance ********/
experiance.addEventListener("keyup",()=>{
    if(experiance.value<=40 & experiance.value>-1){
        p[4].innerText=""
    }
    else{
        p[4].innerText="experiance should be 0 to 40"
    }
})
/********* house no *******/
houseno.addEventListener("keyup",()=>{
    let res=/^[1-9]\d*(?:[ -]?(?:[a-zA-Z]+|[1-9]\d*))?$/
    if(res.test(houseno.value)){
        p[5].innerText=""
    }
    else{
        p[5].innerText="Invaid House Number"
    }
})
/*********landmark *******/
landmark.addEventListener("keyup",()=>{
    let res=/^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$/
    if(res.test(landmark.value)){
        p[6].innerText=""
    }
    else{
        p[6].innerText="Invaid name"
    }
})
/********* street *******/
streetname.addEventListener("keyup",()=>{
    let res=/^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$/
    if(res.test(streetname.value)){
        p[7].innerText=""
    }
    else{
        p[7].innerText="Invaid name"
    }
})
/*********city ********/
city.addEventListener("keyup",()=>{
    let res=/^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$/
    if(res.test(city.value)){
        p[8].innerText=""
    }
    else{
        p[8].innerText="Invaid name"
    }
})
/*********pincode ********/
pincode.addEventListener("keyup",()=>{
    if(pincode.value<=1000000 & pincode.value>99999){
        p[9].innerText=""
    }
    else{
        p[9].innerText="Invaild pincode"
    }
})
submit.addEventListener("click",async (e)=>{
    e.preventDefault();
    let check_gender=document.getElementsByName("gender")
    for(let i=0;i<check_gender.length;i++){
        if(check_gender[i].checked){   
            gender=check_gender[i].value
        }
    }
    if(name.value!="" & email.value!="" & password.value!="" & phone.value!="" & experiance.value!="" & houseno.value!="" & landmark.value!="" & streetname.value!="" & state.value!="State"  & district.value!="district" & city.value!="" & pincode.value!="" ){
        let manager={
        "name":name.value,
        "email":email.value,
        "phone":phone.value,
        "pwd":password.value,
        "gender":gender,
        "experiance":experiance.value,
        "address":{
            "door_No":houseno.value,
            "landmark":landmark.value,
            "street":streetname.value,
            "city":city.value,
            "state":state.value,
            "district":district.value,
            "pincode":pincode.value        
        }
        }
        console.log(manager)
        try{
            const response = await fetch('http://localhost:2001/saveManager',
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(manager),
        });

        if(response.ok){
          const data = await response.json();
          window.alert("Congratulations you have successfully created ");
          
          function save() {
            window.open(URL="http://127.0.0.1:5500/manager/manger-signup.html","_self");
          }
      
          save();
        }
        if (response.status >= 400) {
          window.alert("Youre Already Registered");
        }
    }
    catch(error){
      window.alert( error);
    }
}
    else{
        window.alert("plz enter all details")
    }
})



