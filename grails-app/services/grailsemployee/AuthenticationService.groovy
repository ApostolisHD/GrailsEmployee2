package grailsemployee

import javax.transaction.Transactional
import groovy.sql.Sql


@Transactional
class AuthenticationService {
    def dataSource
    def loggedIn = false

    def setLoggedIn(def isLoggedIn) {
        loggedIn = isLoggedIn
    }

    def login(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        def doLogin = sql.firstRow( """SELECT * 
                                            FROM users 
                                            WHERE user_name=${user_name} AND user_password=${user_password}""")
        if (doLogin)
            loggedIn = true
        else
            loggedIn = false
        sql.executeUpdate(  """UPDATE users 
                                    SET user_active=${loggedIn} 
                                    WHERE user_name=${user_name} AND user_password=${user_password}""")
        return loggedIn
    }

    def getUserid(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        return sql.firstRow(    """SELECT user_id 
                                      FROM users 
                                      WHERE user_name=${user_name} AND user_password=${user_password}""")
    }

    def logOut(def user_id) {
        def sql = new Sql(dataSource)
        sql.executeUpdate(  """UPDATE users 
                                    SET user_active=${loggedIn} 
                                    WHERE user_id=${user_id}""")
    }

    def isAuthenticated() {
        return loggedIn
    }
}
