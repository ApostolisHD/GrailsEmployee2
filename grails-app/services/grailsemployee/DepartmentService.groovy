package grailsemployee

import javax.transaction.Transactional
import groovy.sql.Sql

@Transactional
class DepartmentService {

    def dataSource

    def getAllDepartments() {
        def sql = new Sql(dataSource)
        return sql.rows("SELECT * from departments")
    }

    def createDepartment(def name) {
        def sql = new Sql(dataSource)
        sql.executeInsert("INSERT INTO departments (name) VALUES (${name})")
    }
}
