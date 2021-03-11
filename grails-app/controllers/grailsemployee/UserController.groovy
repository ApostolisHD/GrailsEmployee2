package grailsemployee

class UserController {
    UserService userService
    DepartmentService departmentService
    AuthenticationService authenticationService

    def index() {
        def employees = userService.getAllEmployees()
        def username = session.getAttribute("user_name")
        def departments = departmentService.getAllDepartments()
        [employees: employees , user_name:username,departments: departments]
    }

    def createEmployee() {
        def departments = departmentService.getAllDepartments()
        [departments: departments]
    }

    def save(Integer id_dep) {
        String date_of_birth = params.date_of_birth.replace("-", "/")
        userService.createEmployee(params.first_name, params.last_name, params.afm, date_of_birth, id_dep)
        redirect(action: "index")
    }

    def editEmployee(Integer id) {
        def response = userService.getEmployee(id)
        def departments = departmentService.getAllDepartments()
        [employee_id: response.employee_id, first_name: response.first_name, last_name: response.last_name, afm: response.afm,departments:departments]
    }

    def updateEmployee(Integer id) {
        userService.updateEmployee(id, params.first_name, params.last_name, params.afm,params.id_dep)
        redirect(action: "index")
    }

    def deleteEmployee(Integer id) {
        userService.deleteEmployee(id)
        redirect(action: "index")
    }

}
