package grailsemployee

class AuthenticationApiController {
    static responseFormats = ['json']
    def authenticationService

    def login() {
        println("params${params}")
        if (authenticationService.login(params.user_name, params.user_password)) {
            authenticationService.getUserid(params.user_name, params.user_password)
            def user = [user_name: params.user_name]
            session["user"] = user
            respond(status: 200, sessionVarible: session["user"])
        } else {
            respond(status: 500)
        }
    }

    def logout() {
        session.invalidate()
        redirect(action: "Login")
    }
}
