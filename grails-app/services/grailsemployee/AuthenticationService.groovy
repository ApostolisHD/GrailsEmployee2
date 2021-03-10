package grailsemployee
import javax.transaction.Transactional
import groovy.sql.Sql


@Transactional
class AuthenticationService {
    def dataSource
    def loggedIn = false

    def setLoggedIn(def isLoggedIn){
        loggedIn = isLoggedIn
    }

    def login(def user_name,def user_password){
        def sql = new Sql(dataSource)
        def doLogin = sql.firstRow("SELECT * FROM users where user_name=${user_name} AND user_password=${user_password}")
        if (doLogin)
            loggedIn = true
        else
            loggedIn = false
        sql.executeUpdate("UPDATE users SET user_active=${loggedIn} where user_name=${user_name} AND user_password=${user_password}")
        return loggedIn
    }


    def isAuthenticated(){
        return loggedIn
    }
}
