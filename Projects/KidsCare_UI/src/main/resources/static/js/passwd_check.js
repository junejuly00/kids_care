function check(){
    let passwd = $("#passwd").val();
    let checkPw = $("#check_pw").val();

    if(passwd !== checkPw){
        $("#check").show();
    } else {
        $("#check").hide();
    }
}

$(document).ready(function(){
    $("#check").hide();
});