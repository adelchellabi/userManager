
$('document').ready(function () {
    let password = document.getElementById("password");
    let confirmPassword = document.getElementById("confirmPassword");
    
    function validatePassword() {
        if(password.value != confirmPassword.value){
            confirmPassword.setCustomValidity("Password Don't Match");

        }else{
            confirmPassword.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirmPassword.onkeyup=validatePassword;

});