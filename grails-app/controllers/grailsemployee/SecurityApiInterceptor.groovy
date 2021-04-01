package grailsemployee
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.interfaces.DecodedJWT


class SecurityApiInterceptor {

    SecurityApiInterceptor() {
        matchAll().excludes(controller: "authenticationApi").excludes(controller: "userApi").excludes(controller: "user").excludes(controller:"authentication").excludes(contoller:"employee").excludes(contoller:"department")
    }

    boolean before() {
        def token = request.getCookies().find{ 'authentication' == it.name }?.value
        if (token != null) {
            try {
                Algorithm algorithm = Algorithm.HMAC256("0b475a9e-a293-4554-b277-ddee82e2d392");
                JWTVerifier verifier = JWT.require(algorithm)
                        .withIssuer("auth0")
                        .build()
                DecodedJWT jwt = verifier.verify(token)
                return true
            }
            catch (JWTVerificationException exception) {
                return false
            }
        }else {
            return false
        }
    }
}
