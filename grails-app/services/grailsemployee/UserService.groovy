package grailsemployee

import groovy.sql.Sql

import javax.transaction.Transactional

@Transactional
class UserService {
    def dataSource

    def createUser(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        try {
            return sql.executeInsert("""INSERT INTO users (user_name,user_password,user_active) 
                                    VALUES (${user_name},${user_password},true)""")
        }
        catch (Exception e){
            e.printStackTrace();
            return []
        }
    }
}
