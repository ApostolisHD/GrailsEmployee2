package grailsemployee

import groovy.sql.Sql

import javax.transaction.Transactional


@Transactional
class UserService {
    def dataSource

    def getAllEmployees() {
        def sql = new Sql(dataSource)
        return sql.rows("SELECT * from departments,employee where departments.department_id=employee.id_dep")
    }

    def getEmployee(def id) {
        def sql = new Sql(dataSource)
        sql.firstRow("SELECT * from employee where employee_id=${id}")
    }

    def deleteEmployee(Integer id) {
        def sql = new Sql(dataSource)
        sql.executeUpdate("DELETE from employee where employee_id=${id}")
    }

    def createEmployee(def first_name, def last_name, def afm, def date_of_birth, def id_dep) {
        def sql = new Sql(dataSource)
        sql.executeInsert("INSERT INTO employee(first_name,last_name,afm,date_of_birth,id_dep) VALUES (${first_name},${last_name},${afm},'${date_of_birth}','${id_dep}')")
    }

    def updateEmployee(def id, def first_name, def last_name, def afm, def id_dep) {
        def sql = new Sql(dataSource)
        sql.executeUpdate("UPDATE employee SET first_name=${first_name},last_name=${last_name},afm=${afm},id_dep='${id_dep}' WHERE employee_id=${id}")
    }
}
