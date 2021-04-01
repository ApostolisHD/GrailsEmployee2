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
        try {
            def employee = employeeService.createEmployee(request.JSON.first_name, request.JSON.last_name, request.JSON.afm, request.JSON.date_of_birth, request.JSON.id_dep)
            respond("employee": employee, status: 201)
        } catch (Exception) {
            respond("error": null, status: 400)
        }
    }

    def showEmployeeById(Integer id) {
        def employee = employeeService.getEmployee(id)
        try {
            if (employee) {
                respond("employee": employee, status: 200)
            } else {
                respond("error": null, status: 404)
            }
        } catch (Exception e) {
            respond("error": null, status: 500)
        }
    }

    def editEmployee(Integer id) {
        try {
            def employee = employeeService.updateEmployee(id, request.JSON.first_name, request.JSON.last_name, request.JSON.afm, request.JSON.date_of_birth, request.JSON.id_dep)
            respond("employee": employee, status: 200)
        } catch (Exception) {
            respond("error": null, status: 400)
        }
    }

    def deleteEmployee(Integer id) {
        try {
            def employee = employeeService.deleteEmployee(id)
            respond("employee": employee, status: 202)
        } catch (Exception) {
            respond("error": null, status: 400)
        }
    }
}
