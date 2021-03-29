package grailsemployee

import javax.transaction.Transactional
import groovy.sql.Sql


@Transactional
class AuthenticationService {
    def dataSource

    def login(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        try {
            def doLogin = sql.firstRow("""SELECT * 
                                            FROM users 
                                            WHERE user_name=${user_name} AND user_password=${user_password} AND user_active= true""")
            if (doLogin)
                return doLogin
            else
                return false
        }
        catch (Exception e) {
            e.printStackTrace();
            return []
        }
    }

    def getUserid(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        try {
            return sql.firstRow("""SELECT *
                                      FROM users 
                                      WHERE user_name=${user_name} AND user_password=${user_password} AND user_active= true""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return null
        }
    }

}
