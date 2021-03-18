package grailsemployee

class UserController {
    def userService
    def createUser() {}

    def signUp() {
        userService.createUser(params.user_name, params.user_password)
        redirect(controller: "authentication", action: "Login")
    }
}
