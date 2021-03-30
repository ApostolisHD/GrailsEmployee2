package grailsemployee
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT


class SecurityApiInterceptor {

    SecurityApiInterceptor() {
        matchAll().excludes(controller: "authenticationApi")
    }

    boolean before() {
        Algorithm algorithm = Algorithm.HMAC256("0b475a9e-a293-4554-b277-ddee82e2d392");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build()
        DecodedJWT jwt = verifier.verify(request.getCookie("userName"));
        if (!jwt)
            return false
        else
            return true
    }
}
