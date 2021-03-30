package grailsemployee

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class SecurityApiInterceptorSpec extends Specification implements InterceptorUnitTest<SecurityApiInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test securityApi interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"securityApi")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
