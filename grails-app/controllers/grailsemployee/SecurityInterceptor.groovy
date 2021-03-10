package grailsemployee


class SecurityInterceptor {
    AuthenticationService authenticationService

    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication")
    }

    boolean before() {
        if (!authenticationService.isAuthenticated()) {
            redirect(controller: "authentication", action: "Login")
            return false
        }
        return true
    }

}
