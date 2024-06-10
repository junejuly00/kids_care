document.getElementById("birth").addEventListener("change", function() {
    var birthDate = document.getElementById("birth").value;
    var today = new Date();
    var age = today.getFullYear() - new Date(birthDate).getFullYear() + 1;
    document.getElementById("age").value = age;
});