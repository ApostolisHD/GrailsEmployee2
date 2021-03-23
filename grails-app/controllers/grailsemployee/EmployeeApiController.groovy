package grailsemployee

class EmployeeApiController {
    def employeeService
    static responseFormats = ['json']

    def getAllEmployees() {
        def employees = employeeService.getAllEmployees()
        respond (employees, status: 200)
    }

    def createEmployee() {
        def employee= employeeService.createEmployee(params.first_name, params.last_name, params.afm, params.date_of_birth, params.id_dep.toInteger())
        if(employee){
            respond("employee":employee, status: 201)
        }
        else {
            respond("error":null , status: 400)
        }
    }

    def showEmployeeById(Integer id) {
        respond (employeeService.getEmployee(id), status: 200)
    }

    def editEmployee(Integer id) {
        def employee= employeeService.updateEmployee(id, params.first_name, params.last_name, params.afm, params.date_of_birth, params.id_dep.toInteger())
        if(employee){
            respond("employee":employee, status: 201)
        }
        else {
            respond("error":null , status: 400)
        }
    }

    def deleteEmployee(Integer id) {
        def employee= employeeService.deleteEmployee(id)
        if(employee){
            respond("employee":employee, status: 201)
        }
        else {
            respond("error":null , status: 400)
        }
    }
}
