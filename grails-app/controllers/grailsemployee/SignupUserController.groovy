package grailsemployee

class SignupUserController {
    SignUpUserService signUpUserService

    def createUser() {
    }

    def signUp() {
        signUpUserService.createUser(params.user_name, params.user_password)
        redirect(controller: "authentication", action: "Login")
    }
}