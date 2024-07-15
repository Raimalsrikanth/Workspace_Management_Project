let deleteBtn=document.getElementById("delete-btn")
let aname=window.localStorage.getItem("Admin_name")
let aemail=window.localStorage.getItem("Admin_email")
let id=window.localStorage.getItem("Admin_id")

console.log(aname);
console.log(aemail);
console.log(id);


let name=document.getElementById("name")
let email=document.getElementById("email")

name.value=aname;
email.value=aemail;





deleteBtn.addEventListener('click', async (e)=>{
      e.preventDefault();
      let x=confirm("Are you Sure Want to Delete ? ");
      if(x){
  try{
    const response= await fetch(`http://localhost:8080/deleteadminbyid?Adminid=${id}`,{
      method:"DELETE",
      headers:{
      "content-Type" : "application/json"
      },

    });

    const jsonResponse= await response.json();
    console.log(jsonResponse);

    if(response.status==302){
      window.localStorage.clear();
      window.alert("Admin deleted Successfully....!")
      function open(){
        window.open("http://127.0.0.1:5500/FRONT-END/FRONT-END/admin/admin-sign-in.html","_blank")
      }
      open()  
    }

    if(response.status==404){
      window.alert("There was an error. Please check")
    }

    
  }
  catch(error){

    window.alert("error", error)
  }
}
else{
  window.open("http://127.0.0.1:5500/FRONT-END/FRONT-END/admin/admin-delete.html","_self")
}

},false)
