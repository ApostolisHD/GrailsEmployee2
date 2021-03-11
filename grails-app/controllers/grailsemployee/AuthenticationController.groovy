package grailsemployee


class AuthenticationController {

    AuthenticationService authenticationService


    def Login() {
    }

    def doLogin() {
        if (authenticationService.login(params.user_name, params.user_password)) {
            def user = authenticationService.getUserid(params.user_name, params.user_password)
            session.setAttribute("user_id",user.user_id)
            session.setAttribute("user_name",user.user_name)
            redirect(controller: "employees", action: "index")
        } else {
            redirect(controller: "authentication", action: "Login")
        }
    }

    def logout() {
        authenticationService.logOut(session["user_id"])
        session.invalidate()
        redirect(action: "Login")
    }

}
