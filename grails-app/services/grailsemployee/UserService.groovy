package grailsemployee
import groovy.sql.Sql

import javax.transaction.Transactional


@Transactional
class UserService {
    def dataSource

    def getAllEmployees() {
        def sql = new Sql(dataSource)
        return sql.rows("SELECT * from departure,employee where departure.departure_id=employee.id_dep")
    }

    def getEmployee(def id){
        def sql = new Sql(dataSource)
        sql.firstRow("SELECT * from employee,departure where employee_id=${id}")
    }

    def deleteEmployee(Integer id){
        def sql = new Sql(dataSource)
        sql.executeUpdate("DELETE from employee where employee_id=${id}")
    }

    def createEmployee(def first_name,def last_name,def afm,def date_of_birth){
        def sql = new Sql(dataSource)
        sql.executeInsert("INSERT INTO employee(first_name,last_name,afm,date_of_birth) VALUES (${first_name},${last_name},${afm},'${date_of_birth}')")
    }


    def updateEmployee(def id, def first_name,def last_name,def afm){
        def sql = new Sql(dataSource)
        sql.executeUpdate("UPDATE employee SET first_name=${first_name},last_name=${last_name},afm=${afm} WHERE employee_id=${id}")
    }
}
