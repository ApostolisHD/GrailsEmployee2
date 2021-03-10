package grailsemployee


class AuthenticationController {

    AuthenticationService authenticationService

    def Login() {
    }

    def doLogin() {
        if (authenticationService.login(params.user_name, params.user_password)) {
            def user = authenticationService.getUserid(params.user_name, params.user_password)
            session["user_id"] = user.user_id
            redirect(controller: "user", action: "index")
        } else {
            redirect(controller: "authentication", action: "Login")
        }
    }

    def logout() {
        authenticationService.setLoggedIn(false)
        authenticationService.logOut(session["user_id"])
        session.invalidate()
        redirect(action: "Login")
    }

}
