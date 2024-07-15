
let id = window.localStorage.getItem("Admin_id");

let dbname=window.localStorage.getItem("Admin_name")
let dbemail=window.localStorage.getItem("Admin_email")
let dbpwd=window.localStorage.getItem("Admin_pwd")
let dbphone=window.localStorage.getItem("Admin_phone")

let dbadress_id = window.localStorage.getItem("Admin_addressid");
let dbdo_number=window.localStorage.getItem("Admin_doorNo")
let dblandmark =window.localStorage.getItem("Admin_landmark")
let dbstreet=window.localStorage.getItem("Admin_street")
let dbcity=window.localStorage.getItem("Admin_city")
let dbdistrict=window.localStorage.getItem("Admin_district")
let dbstate=window.localStorage.getItem("Admin_state")
let dbpincode=window.localStorage.getItem("Admin_pincode")

// console.log(dbname);
// console.log(dbemail);
// console.log(dbpwd);
// console.log(dbphone);
// console.log(dbadress_id);
// console.log(dbdo_number);
// console.log(dblandmark);
// console.log(dbstreet);
// console.log(dbcity);
// console.log(dbdistrict);
// console.log(dbstate);
// console.log(dbpincode);

let name = document.getElementById("name");
let email = document.getElementById("email");
let pwd = document.getElementById("pwd");
let phn = document.getElementById("phn");
let state = document.getElementById("state");
let dist = document.getElementById("dist");
let city = document.getElementById("city");
let landmark = document.getElementById("landmark");
let street = document.getElementById("street");
let doornum = document.getElementById("do_no");
let pincode = document.getElementById("pincode");

let display = document.getElementById("fetch");

display.addEventListener('click', async (e) => {
    e.preventDefault();
    if (id !== "") {
        try {
            const response = await fetch(`http://localhost:8080/findadminbyid?id=${id}`, {
                method: "GET",
                headers: {
                    "Content-Type": "application/json"
                },
            });
            console.log(response);
            console.log(response.status);
            if (response.status==302) {
                const data = await response.json();
                name.innerHTML+=dbname
                email.innerHTML+=dbemail
                pwd.innerHTML+=dbpwd
                phn.innerHTML+=dbphone
                state.innerHTML+=dbstate
                dist.innerHTML+=dbdistrict
                city.innerHTML+=dbcity
                landmark.innerHTML+=dblandmark
                street.innerHTML+=dbstreet
                doornum.innerHTML+=dbdo_number
                pincode.innerHTML+=dbpincode

                function hiddenbutton(){
                    display.style.display="none"
                    // display.style.visibility="hidden"
                }
                hiddenbutton()
            } 
            if(response.status>=400) {
                console.error('Failed to fetch admin data');
            }
        } catch (error) {
            console.error('Error:', error);
            window.alert("Error occurred while fetching admin data");
        }
    }
}, false);
