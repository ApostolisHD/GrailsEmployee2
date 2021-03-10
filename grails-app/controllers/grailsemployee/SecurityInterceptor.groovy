package grailsemployee


class SecurityInterceptor {
    AuthenticationService authenticationService

    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication").excludes(controller: "signupUser")
    }

    boolean before() {
        if (!authenticationService.isAuthenticated()) {
            redirect(controller: "authentication", action: "Login")
            return false
        }
        return true
    }

}
