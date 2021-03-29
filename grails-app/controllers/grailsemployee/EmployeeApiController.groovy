package grailsemployee

class EmployeeApiController {
    def employeeService
    static responseFormats = ['json']


    def getAllEmployees() {
        println("params=${request.cookies}")
        def employees = employeeService.getAllEmployees()
        respond (employees, status: 200)
    }

    def createEmployee() {
        println("params${request.JSON}")
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
        println("params ${request.JSON}")
        def employee= employeeService.updateEmployee(id, request.JSON.first_name, request.JSON.last_name, request.JSON.afm, request.JSON.date_of_birth, request.JSON.id_dep.toInteger())
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
