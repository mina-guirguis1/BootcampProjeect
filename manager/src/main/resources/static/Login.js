

function loginUser() {
    const email = document.getElementById("emailTxtBox").value;
    const password = document.getElementById("passwordTxtBox").value;


    $.ajax({
        type:"GET",
        headers: {
            contentType: "application/json; charset=utf-8",

        },
        url: "http://localhost:8080/api/v1/login",
        data: JSON.stringify(email),
        credentials: true,
        success: function (response) {
            console.log("It worked")
        },
        error: function (error) {
            console.log("It failed")
            console.log(error)
        }
    });

}