function checkPasswords(){
    if (document.getElementById("password").value !== document.getElementById("confirm-password").value) {
        alert("As senhas não coincidem!")
        return false
    } else {
        return true
    }
}