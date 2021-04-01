package grailsemployee

class AuthenticationController {
    def authenticationService
    def Login() {}

    def doLogin() {
        if (authenticationService.login(params.user_name, params.user_password)) {
            authenticationService.getUserid(params.user_name, params.user_password)
            def user = [user_name: params.user_name]
            session["user"] = user
            redirect(controller: "employees", action: "index")
        } else {
            flash.message = 'Λαθος στοιχεια παρακαλω προσπαθηστε ξανα!'
            redirect(controller: "authentication", action: "Login")
        }
    }

    def Logout() {
        session.invalidate()
        redirect(action: "Login")
    }
}
