package grailsemployee

class EmployeesController {
    EmployeeService employeeService
    DepartmentService departmentService


    def index() {
        def employees = employeeService.getAllEmployees()
        def username = session.getAttribute("user_name")
        def departments = departmentService.getAllDepartments()
        [employees: employees , user_name:username, departments: departments]
    }

    def createEmployee() {
        def departments = departmentService.getAllDepartments()
        [departments: departments]
    }

    def save() {
        String date_of_birth = params.date_of_birth.replace("-", "/")
        employeeService.createEmployee(params.first_name, params.last_name, params.afm, date_of_birth, params.id_dep)
        println("params ${params}")
        redirect(action: "index")
    }

    def editEmployee(Integer id) {
        def response = employeeService.getEmployee(id)
        def departments = departmentService.getAllDepartments()
        if(!response) {
            flash.error = 'Ο εργαζομενος δεν βρεθηκε!'
            redirect(action: "index")
            return errors
        }
        [employee_id:id, first_name: response.first_name, last_name: response.last_name, afm:response.afm,date_of_birth:response.date_of_birth,departments:departments]
    }

    def updateEmployee(Integer id) {
        String date_of_birth = params.date_of_birth.replace("-", "/")
        employeeService.updateEmployee(id, params.first_name, params.last_name, params.afm,date_of_birth,params.id_dep)
        redirect(action: "index")
    }

    def deleteEmployee(Integer id) {
        employeeService.deleteEmployee(id)
        redirect(action: "index")
    }

}
