package grailsemployee


class AuthenticationController {

        AuthenticationService authenticationService

        def Login(){
        }

        def doLogin() {
                if (authenticationService.login(params.user_name, params.user_password)) {
                        redirect(controller: "user", action:"index")
                } else {
                        redirect(controller: "authentication", action: "Login")
                }
        }

        def logout(){
                authenticationService.setLoggedIn(false)
                session.invalidate()
                redirect(action: "Login")
        }
}
