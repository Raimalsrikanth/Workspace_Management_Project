let id = window.sessionStorage.getItem("id")
console.log(id)
let name = window.sessionStorage.getItem("name")
console.log(name)
let email = window.sessionStorage.getItem("email")
console.log(email)
let phone = window.sessionStorage.getItem("phone")
console.log(phone)

let userId = document.getElementById("userId")
userId.innerHTML=id
let userName = document.getElementById("userName")
userName.innerHTML = name
let userPhone = document.getElementById("userPhone")
userPhone.innerHTML = phone
let userEmail = document.getElementById("userEmail")
userEmail.innerHTML = email