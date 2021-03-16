package grailsemployee


class AuthenticationController {

    AuthenticationService authenticationService

    def Login() {
    }

    def doLogin() {
        if (authenticationService.login(params.user_name, params.user_password)) {
                def userParams = authenticationService.getUserid(params.user_name,params.user_password)
                def user = [user_id:userParams.user_id, user_name: params.user_name]
                session["user"]= user
            redirect(controller: "employees", action: "index")
        } else {
            flash.message = 'Λαθος στοιχεια παρακαλω προσπαθηστε ξανα!'
            redirect(controller: "authentication", action: "Login")
        }
    }

    def logout() {
        authenticationService.logOut(session.user.user_id)
        session.invalidate()
        redirect(action: "Login")
    }

}
