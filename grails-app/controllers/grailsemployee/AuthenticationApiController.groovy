package grailsemployee
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.*
import javax.servlet.http.Cookie;

class AuthenticationApiController {
    static responseFormats = ['json']
    def authenticationService

    def login() {
        if (authenticationService.login(request.JSON.user_name, request.JSON.user_password)) {
            def user = request.getJSON().user_name
            response.setCookie('user', user)
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().withClaim("user",request.getCookie('user')).sign(algorithm)
//            Cookie homeCookie = new Cookie('user_name','token')
//            homeCookie.path = '/'
//            homeCookie.maxAge = 3600
//            response.addCookie homeCookie
//            println("params=${request.getCookie('user')}")
            respond(status: 200, cookie:token)
        } else {
            respond(status: 500)
        }
    }

    def logout() {
        session.invalidate()
        redirect(action: "Login")
    }
}
