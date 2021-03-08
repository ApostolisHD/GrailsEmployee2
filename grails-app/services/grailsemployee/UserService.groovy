package grailsemployee
import groovy.sql.Sql

import javax.transaction.Transactional


@Transactional
class UserService {
    def dataSource

    def getAllEmployees() {
        def sql = new Sql(dataSource)
        return sql.rows("SELECT * from employee")
    }

    def deleteEmployee(def id){
        def sql = new Sql(dataSource)
        sql.executeUpdate("DELETE from employee where employee_id=${id}")
    }

    def createEmployee(def first_name,last_name,afm,date_of_birth){
        def sql = new Sql(dataSource)
        sql.executeInsert("INSERT INTO employee(first_name,last_name,afm,date_of_birth) VALUES (${first_name},${last_name},${afm},${date_of_birth})")
    }
}
