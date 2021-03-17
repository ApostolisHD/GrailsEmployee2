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
                                            WHERE user_name=${user_name} AND user_password=${user_password}""")
            if (doLogin)
                return sql.executeUpdate("""UPDATE users 
                                    SET user_active=${true} 
                                   WHERE user_name=${user_name} AND user_password=${user_password}""")
            else
                return false
        }
        catch (Exception e) {
            println(e.getMessage())
        }
    }

    def getUserid(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        try {
            return sql.firstRow("""SELECT *
                                      FROM users 
                                      WHERE user_name=${user_name} AND user_password=${user_password} AND user_active = ${true}""")
        }
        catch (Exception e) {
            println(e.getMessage())
            return false
        }
    }

//    def logOut(def user_id) {
//        def sql = new Sql(dataSource)
//        try {
//            sql.executeUpdate("""UPDATE users
//                                    SET user_active=${false}
//                                    WHERE user_id=${user_id}""")
//            sql.close()
//        }
//        catch (Exception e){
//            println(e.getMessage())
//        }
//    }
}
