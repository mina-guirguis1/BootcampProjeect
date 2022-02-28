
function createUser() {
    const email = document.getElementById("emailTxtBox").value;
    const password = document.getElementById("passwordTxtBox").value;

        $.ajax({
            type:"POST",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8080/api/v1/login",
            data: JSON.stringify({"email" : email.toString(), "password" : password.toString()}),
            cache: false
        })
}

function loginUser() {
    const email = document.getElementById("emailTxtBox").value;
    const password = document.getElementById("passwordTxtBox").value;

    

}