package grailsemployee

class SecurityInterceptor {
    SecurityInterceptor() {
        matchAll().excludes(controller: "user").excludes(contoller:"employeeApi").excludes(contoller:"departmentApi").excludes(controller:"authenticationApi").excludes(controller: "authentication")
    }

    boolean before() {
        if (!session["user"]) {
            redirect(controller: "authentication", action: "Login")
            return false
        }
        return true
    }
}
