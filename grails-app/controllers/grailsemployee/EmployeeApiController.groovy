package grailsemployee
import com.auth0.jwt.*
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT

import javax.servlet.http.Cookie

class EmployeeApiController {
    def employeeService
    static responseFormats = ['json']

    def getAllEmployees() {
        def employees = employeeService.getAllEmployees()
        respond(employees, status: 200)
    }

    def createEmployee() {
        def employee= employeeService.createEmployee(request.JSON.first_name, request.JSON.last_name, request.JSON.afm, request.JSON.date_of_birth, request.JSON.id_dep)
        if(employee){
            respond("employee":employee, status: 200)
        }
        else {
            respond("error":null , status: 500)
        }
    }

    def showEmployeeById(Integer id) {
        respond (employeeService.getEmployee(id), status: 200)
    }

    def editEmployee(Integer id) {
        def employee= employeeService.updateEmployee(id, request.JSON.first_name, request.JSON.last_name, request.JSON.afm, request.JSON.date_of_birth, request.JSON.id_dep)
        if(employee){
            respond("employee":employee, status: 200)
        }
        else {
            respond("error":null , status: 500)
        }
    }

    def deleteEmployee(Integer id) {
        def employee= employeeService.deleteEmployee(id)
        if(employee){
            respond("employee":employee, status: 200)
        }
        else {
            respond("error":null , status: 500)
        }
    }
}
