package grailsemployee
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.*
import javax.servlet.http.Cookie;

class AuthenticationApiController {
    static responseFormats = ['json']
    def authenticationService
    static String token

    def login() {
        if (authenticationService.login(request.JSON.user_name, request.JSON.user_password)) {
            def userName = request.JSON.user_name
            Algorithm algorithm = Algorithm.HMAC256("0b475a9e-a293-4554-b277-ddee82e2d392");
            token = JWT.create().withIssuer("auth0").withClaim("userName",userName).sign(algorithm)
            Cookie homeCookie = new Cookie('userName',token)
            homeCookie.maxAge = 3600
            homeCookie.setPath("/")
            homeCookie.httpOnly = true
            response.setCookie(homeCookie)
            respond(status: 200)
        } else {
            respond(status: 500)
        }
    }

    def logout() {
        Cookie homeCookie = new Cookie('userName',token)
        homeCookie.maxAge = 3600
        homeCookie.setPath("/")
        homeCookie.httpOnly = true
        response.setCookie(homeCookie)
        respond(status: 200)
    }
}
