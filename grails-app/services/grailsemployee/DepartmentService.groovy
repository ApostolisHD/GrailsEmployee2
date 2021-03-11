package grailsemployee

import javax.transaction.Transactional
import groovy.sql.Sql

@Transactional
class DepartmentService {

    def dataSource

    def getAllDepartments() {
        def sql = new Sql(dataSource)
        return sql.rows("""SELECT * 
                                FROM departments""")
    }

    def createDepartment(def name) {
        def sql = new Sql(dataSource)
        sql.executeInsert("""INSERT INTO departments (name) 
                                    VALUES (${name})""")
    }
    def getDepartmentById(Integer id) {
        def sql = new Sql(dataSource)
        sql.firstRow("""SELECT * 
                                    FROM departments 
                                    WHERE department_id = ${id}""")
    }
    def updateDepartment(def id, def name) {
        def sql = new Sql(dataSource)
        sql.executeUpdate("""UPDATE departments 
                                    SET name=${name} 
                                    WHERE department_id=${id}""")
    }
    def deleteDepartment(Integer id) {
        def sql = new Sql(dataSource)
        sql.executeUpdate("""DELETE FROM departments 
                                    WHERE department_id=${id}""")
    }
}
