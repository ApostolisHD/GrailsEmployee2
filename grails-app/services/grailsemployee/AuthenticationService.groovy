package grailsemployee

import javax.transaction.Transactional
import groovy.sql.Sql


@Transactional
class AuthenticationService {
    def dataSource

    def login(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        def doLogin = sql.firstRow("""SELECT * 
                                            FROM users 
                                            WHERE user_name=${user_name} AND user_password=${user_password}""")
        if (doLogin)
            return sql.executeUpdate("""UPDATE users 
                                    SET user_active=${true} 
                                   WHERE user_name=${user_name} AND user_password=${user_password}""")
            else
                return false
        sql.close()
    }
    def getUserid(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        return sql.firstRow("""SELECT *
                                      FROM users 
                                      WHERE user_name=${user_name} AND user_password=${user_password} AND user_active = ${true}""")
        sql.close()
    }

    def logOut(def user_id) {
        def sql = new Sql(dataSource)
        sql.executeUpdate("""UPDATE users 
                                    SET user_active=${false} 
                                    WHERE user_id=${user_id}""")
        sql.close()
    }
}
