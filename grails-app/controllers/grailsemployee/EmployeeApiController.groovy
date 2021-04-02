package grailsemployee

import com.auth0.jwt.*
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT

import javax.servlet.http.Cookie

class EmployeeApiController {
    def employeeService
    static responseFormats = ['json']

    def getAllEmployees() {
        def employee = employeeService.getAllEmployees()
        respond("employee": employee, status: 200)
    }

    def createEmployee() {
        try {
            def employee = employeeService.createEmployee(request.JSON.first_name, request.JSON.last_name, request.JSON.afm, request.JSON.date_of_birth, request.JSON.id_dep)
            if(employee != null) {
                respond("employee": employee, status: 201)
            }else {
                respond("error": null, status: 400)
            }
        } catch (Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }

    def showEmployeeById(Integer id) {
        def employee = employeeService.getEmployee(id)
        try {
            if (employee!=null) {
                respond("employee": employee, status: 200)
            } else {
                respond("error": null, status: 404)
            }
        } catch(Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }

    def editEmployee(Integer id) {
        try {
            def employee = employeeService.updateEmployee(id, request.JSON.first_name, request.JSON.last_name, request.JSON.afm, request.JSON.date_of_birth, request.JSON.id_dep)
            if(employee!=null){
            respond("employee": employee, status: 200)
            }else{
                respond("error": null, status: 400)
            }
        } catch (Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }

    def deleteEmployee(Integer id) {
        try {
            def employee = employeeService.deleteEmployee(id)
            if(employee){
            respond(status: 202)
            }else {
                respond("error": null, status: 400)
            }
        } catch (Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }
}
