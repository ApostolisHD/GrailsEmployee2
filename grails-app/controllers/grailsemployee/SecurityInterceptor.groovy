package grailsemployee

class SecurityInterceptor {
    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication").excludes(controller: "signupUser")
    }

    boolean before() {
        if (!session["user"]) {
            redirect(controller: "authentication", action: "Login")
            return false
        }
        return true
    }
}
