package grailsemployee
import groovy.sql.Sql
import javax.transaction.Transactional
import java.sql.Date


@Transactional
class EmployeeService {
    def dataSource

    def getAllEmployees() {
        def sql = new Sql(dataSource)
        try {
            return sql.rows("""SELECT * , to_char(date_of_birth, 'DD-MM-YYYY') as date_of_birth
                               FROM departments,employee 
                               WHERE departments.department_id=employee.id_dep ORDER BY employee_id ASC""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return []
        }
    }

    def getEmployee(Integer id) {
        def sql = new Sql(dataSource)
        try {
            return sql.firstRow("""SELECT * , to_char(date_of_birth, 'DD-MM-YYYY') as date_of_birth
                               FROM employee 
                               WHERE employee_id=${id}""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return null
        }
    }

    def deleteEmployee(Integer id) {
        def sql = new Sql(dataSource)
        try {
            sql.execute("""DELETE FROM employee 
                                    WHERE employee_id=${id}""")
            return true
        }
        catch (Exception e) {
            e.printStackTrace();
            return []
        }
    }

    def createEmployee(def first_name, def last_name, def afm, def date_of_birth, def id_dep) {
        def sql = new Sql(dataSource)
        try {
            return sql.executeInsert("""INSERT INTO employee(first_name,last_name,afm,date_of_birth,id_dep) 
                                    VALUES (${first_name},${last_name},${afm},'${date_of_birth}','${id_dep}')""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return []
        }
    }

    def updateEmployee(Integer id, def first_name, def last_name, def afm, def date_of_birth, def id_dep) {
        def sql = new Sql(dataSource)
        try {
            return sql.executeUpdate("""UPDATE employee 
                                    SET first_name=${first_name},last_name=${last_name},afm=${afm},date_of_birth='${date_of_birth}',id_dep='${id_dep}' 
                                    WHERE employee_id=${id}""")
        }
        catch (Exception e) {
            e.printStackTrace();
            return []
        }
    }
}
