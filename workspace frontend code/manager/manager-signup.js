managersignup .addEventListener("click" ,() => {
    window.open("http://127.0.0.1:5500/manager/manager-signin.html")
})

submit.addEventListener("click", async (e) =>{
    console.log("hi");
    e.preventDefault();
    try{
        const response= await fetch(`http://localhost:2001/managerLogin?email=${user.value}&password=${password.value}`)
        let x = await response.json();
        // console.log(x.data.address);
        // console.log(response.status);
        window.sessionStorage.setItem("id",x.data.id)
        window.sessionStorage.setItem("name",x.data.name)
        window.sessionStorage.setItem("email",x.data.email)
        window.sessionStorage.setItem("phone",x.data.phone)
        window.open(URL="http://127.0.0.1:5500/manager/manager-home.html","_self")
    }
    catch(error){
        console.log(error)
    }
},false)




