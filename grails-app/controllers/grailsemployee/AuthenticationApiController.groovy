package grailsemployee
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.*
import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.interfaces.DecodedJWT

import javax.servlet.http.Cookie;

class AuthenticationApiController {
    static responseFormats = ['json']
    def authenticationService


    def Login() {
        if (authenticationService.login(request.JSON.user_name, request.JSON.user_password)) {
            def userName = request.JSON.user_name
            Algorithm algorithm = Algorithm.HMAC256("0b475a9e-a293-4554-b277-ddee82e2d392");
            String token = JWT.create().withIssuer("auth0").withClaim('userName', userName).sign(algorithm)
            Cookie homeCookie = new Cookie('authentication', token)
            homeCookie.maxAge = 3600
            homeCookie.setPath("/")
            homeCookie.httpOnly = true
            response.addCookie(homeCookie)
            respond(status: 200)
        } else {
            respond(status: 401)
        }
    }

    def findUser(){
        def token = request.getCookies().find{ 'authentication' == it.name }?.value
        try {
            DecodedJWT jwt = JWT.decode(token)
            respond(status: 200, userName:jwt.claims.userName.toString())
        } catch (JWTDecodeException exception){
            exception.printStackTrace()
            respond(status: 401)
        }
    }

    def logout() {
        Cookie homeCookie = new Cookie('authentication',null)
        homeCookie.maxAge = 0
        homeCookie.setPath("/")
        homeCookie.httpOnly = true
        response.addCookie(homeCookie)
        respond(status: 200)
    }
}
