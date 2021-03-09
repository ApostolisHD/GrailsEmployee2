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

    def getEmployee(Integer id){
        def sql = new Sql(dataSource)
        sql.rows("SELECT * from employee where employee_id=${id}")
    }

    def deleteEmployee(Integer id){
        def sql = new Sql(dataSource)
        sql.executeUpdate("DELETE from employee where employee_id=${id}")
    }

    def createEmployee(def first_name,def last_name,def afm,def date_of_birth){
        def sql = new Sql(dataSource)
        sql.executeInsert("INSERT INTO employee(first_name,last_name,afm,date_of_birth) VALUES (${first_name},${last_name},${afm},'${date_of_birth}')")
    }

    def updateEmployee(def id, def first_name,def last_name,def afm,def date_of_birth){
        def sql = new Sql(dataSource)
        sql.executeInsert("UPDATE employee SET first_name=${first_name},last_name=${last_name},afm=${afm},date_of_birth='${date_of_birth}'WHERE employee_id=${id})")
    }
}
