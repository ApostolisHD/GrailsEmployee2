package grailsemployee

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

import javax.servlet.http.Cookie

class UserApiController {
    static responseFormats = ['json']
    def userService

    def signUp() {
        def registerUser = userService.createUser(request.JSON.user_name, request.JSON.user_password)
        if (registerUser) {
            def userName = request.JSON.user_name
            Algorithm algorithm = Algorithm.HMAC256("0b475a9e-a293-4554-b277-ddee82e2d392");
            String token = JWT.create().withIssuer("auth0").withClaim("userName", userName).sign(algorithm)
            Cookie homeCookie = new Cookie('authentication', token)
            homeCookie.maxAge = 3600
            homeCookie.setPath("/")
            homeCookie.httpOnly = true
            response.addCookie(homeCookie)
            respond(status: 201)
        } else {
            respond(status: 400)
        }
    }
}
