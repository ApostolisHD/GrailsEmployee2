package grailsemployee


class SecurityInterceptor {


    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication").excludes(controller: "signupUser")
    }

    boolean before() {
        if (!request.session) {
            redirect(controller: "authentication", action: "Login")
            return false
        }
        return true
    }

}
