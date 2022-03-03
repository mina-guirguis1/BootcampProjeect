

function loginUser() {
    const email = document.getElementById("emailTxtBox").value;
    const password = document.getElementById("passwordTxtBox").value;

    $.ajax({
        type:"GET",
        headers: {
            contentType: "application/json; charset=utf-8",

        },
        url: "http://localhost:8080/api/v1/login/email/" + email,
        success: function (response) {
            console.log("It worked");
            const getPassFromDB = response["password"];
            const getUserID = response["id"];
            if(password == getPassFromDB) {
                //redirect
                localStorage.setItem("userID", getUserID);
                window.location.replace("appointments.html");
            } else {
               alert("The password you entered was wrong");
            }
        },
        error: function (error) {
            console.log("It failed");
        }
    });

}