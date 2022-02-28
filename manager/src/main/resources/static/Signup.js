
function createUser() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const gender = document.getElementById("gender").value;
    const age = document.getElementById("age").value;
    const phoneNumber= document.getElementById("phoneNumber").value;

        $.ajax({
            type:"POST",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8080/api/v1/login",
            data: JSON.stringify({"email" : email.toString(), "password" : password.toString()}),
            cache: false
        })

        $.ajax({
            type:"POST",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8081/api/v1/user",
            data: JSON.stringify({"email" : email.toString(), "firstName" : firstName.toString(),
            "lastName" : lastName.toString(), "gender" : gender.toString(), "age" : age,
            "phoneNumber" : phoneNumber.toString()
            }),
            cache: false
                })
}