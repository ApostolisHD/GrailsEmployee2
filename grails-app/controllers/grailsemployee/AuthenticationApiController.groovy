package grailsemployee
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.*
import javax.servlet.http.Cookie;

class AuthenticationApiController {
    static responseFormats = ['json']
    def authenticationService


    def login() {
        if (authenticationService.login(request.JSON.user_name, request.JSON.user_password)) {
            def userName = request.JSON.user_name
            Algorithm algorithm = Algorithm.HMAC256("0b475a9e-a293-4554-b277-ddee82e2d392");
            String token = JWT.create().withIssuer("auth0").withClaim("userName", userName).sign(algorithm)
            Cookie homeCookie = new Cookie('userName', token)
            homeCookie.maxAge = 3600
            homeCookie.setPath("/")
            homeCookie.httpOnly = true
            response.addCookie(homeCookie)
            respond(status: 200, name: userName)
        } else {
            respond(status: 500)
        }
    }

    def logout() {
        Cookie homeCookie = new Cookie('userName',null)
        homeCookie.maxAge = 0
        homeCookie.setPath("/")
        homeCookie.httpOnly = true
        response.addCookie(homeCookie)
        respond(status: 200)
    }
}
