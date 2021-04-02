package grailsemployee

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
        catch (Exception e) {
            e.printStackTrace();
            return []
        }
    }

    def createDepartment(def name) {
        def sql = new Sql(dataSource)
        try {
            return sql.executeInsert("""INSERT INTO departments (name) 
                                    VALUES (${name})""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return null
        }
    }

    def getDepartmentById(Integer id) {
        def sql = new Sql(dataSource)
        try {
            return sql.firstRow("""SELECT * 
                                    FROM departments 
                                    WHERE department_id = ${id}""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return null
        }
    }

    def updateDepartment(def id, def name) {
        def sql = new Sql(dataSource)
        try {
            return sql.executeUpdate("""UPDATE departments 
                                    SET name=${name} 
                                    WHERE department_id=${id}""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return null
        }
    }

    def deleteDepartment(Integer id) {
        def sql = new Sql(dataSource)
        try {
            sql.execute("""DELETE FROM departments 
                                    WHERE department_id=${id}""")
            return true
        }
        catch (Exception e) {
            e.printStackTrace();
            return []
        }
    }
}
