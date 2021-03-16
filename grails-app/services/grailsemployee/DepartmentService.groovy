package grailsemployee

import org.apache.tools.ant.taskdefs.Echo

import javax.transaction.Transactional
import groovy.sql.Sql

@Transactional
class DepartmentService {

    def dataSource

    def getAllDepartments() {
        def sql = new Sql(dataSource)
        try {
            sql.rows("""SELECT * 
                                FROM departments ORDER BY department_id ASC""")
        }
        catch (Exception e){
            println(e.getMessage())
        }
    }

    def createDepartment(def name) {
        def sql = new Sql(dataSource)
        try {
           return sql.executeInsert("""INSERT INTO departments (name) 
                                    VALUES (${name})""")
        }
        catch (Exception e){
            println(e.getMessage())
            return false
        }
    }
    def getDepartmentById(Integer id) {
        def sql = new Sql(dataSource)
        try {
            return sql.firstRow("""SELECT * 
                                    FROM departments 
                                    WHERE department_id = ${id}""")
        }
        catch (Exception e){
            println(e.getMessage())
            return false
        }
    }
    def updateDepartment(def id, def name) {
        def sql = new Sql(dataSource)
        try {
            return sql.executeUpdate("""UPDATE departments 
                                    SET name=${name} 
                                    WHERE department_id=${id}""")
        }
        catch (Exception e){
            println(e.getMessage())
            return false
        }
    }
    def deleteDepartment(Integer id) {
        def sql = new Sql(dataSource)
        try {
            return sql.executeUpdate("""DELETE FROM departments 
                                    WHERE department_id=${id}""")
            }
            catch (Exception e){
                println(e.getMessage())
                return false
            }
        sql.close()
    }
}
