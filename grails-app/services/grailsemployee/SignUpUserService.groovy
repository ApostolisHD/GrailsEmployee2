package grailsemployee

import groovy.sql.Sql

import javax.transaction.Transactional

@Transactional
class SignUpUserService {
    def dataSource

    def createUser(def user_name, def user_password) {
        def sql = new Sql(dataSource)
        sql.executeInsert(  """INSERT INTO users (user_name,user_password,user_active) 
                                    VALUES (${user_name},${user_password},${false})""")
    }
}
