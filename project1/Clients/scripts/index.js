let welcomeH1 = document.getElementById('welcome');

// Different welcome message based on logged in user retrieved from session storage
if(principal){
    welcomeH1.innerHTML = `Welcome back ${principal.userName}!`
} else{
    welcomeH1.innerHTML = `Welcome to Employee Reimbursment System!`
}

