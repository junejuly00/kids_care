function check() {
    let passwd = document.getElementById("passwd").value;
    let checkPw = document.getElementById("check_pw").value;
    let checkElement = document.getElementById("check");

    if (passwd !== checkPw) {
        checkElement.style.display = "block";
    } else {
        checkElement.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    let checkElement = document.getElementById("check");
    checkElement.style.display = "none";
});