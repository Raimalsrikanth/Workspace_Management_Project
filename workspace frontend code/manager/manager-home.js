update.addEventListener("click",()=>{
    window.open("http://127.0.0.1:5500/manager/update.html","_self")
})

Delete.addEventListener("click",async(e) =>{
    e.preventDefault()
    let id = window.sessionStorage.getItem("id")
    try {
        const x = await fetch(`http://localhost:2001/deleteMangerById?id=${id}`,{
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
        
        })
        console.log(x.status);
        if(x.status==302){
            window.alert("manager account deleted successfully")
            window.open("http://127.0.0.1:5500/manager/manger-signup.html")
        }else{
            window.alert("account not deleted")
        }
    } 
    catch (error) {
        window.alert(error)
    }
})


//fetch
profile.addEventListener("click",async(e)=> {
    e.preventDefault()
    let id = window.sessionStorage.getItem("id")
    window.open("http://127.0.0.1:5500/manager/profile.html")
    try {
        const x = await fetch(`http://localhost:2001/fetchManagerById?id=${id}`,{
            method: "GET",
            headers: {
                "Content-Type": "application/json",
              },   
        })
        
        if(x.status==302){
            // window.open("http://127.0.0.1:5500/Manager/Html/fetch.html")
            console.log("hi")
            let name = window.sessionStorage.getItem("name")
        }else{
        window.alert("account not fetched")
        }
    } catch (error) {
        window.alert(error)
    }
})