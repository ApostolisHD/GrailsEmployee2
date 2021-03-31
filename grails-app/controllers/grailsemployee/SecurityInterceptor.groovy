package grailsemployee

class SecurityInterceptor {
    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication").excludes(controller: "user").excludes(contoller:"employeeApi").excludes(contoller:"departmentApi")
    }

    boolean before() {
//        if (!session["user"]) {
//            redirect(controller: "authentication", action: "Login")
//            return false
//        }
        return true
    }
}
