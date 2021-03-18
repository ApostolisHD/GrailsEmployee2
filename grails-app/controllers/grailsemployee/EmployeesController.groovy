package grailsemployee

class EmployeesController {
    def employeeService
    def departmentService

    def index() {
        def employees = employeeService.getAllEmployees()
        def username = session.getAttribute("user_name")
        def departments = departmentService.getAllDepartments()
        [employees: employees, user_name: username, departments: departments]
    }

    def createEmployee() {
        def departments = departmentService.getAllDepartments()
        if (!departments) {
            flash.error = 'Πρέπει να φτιάξετε πρώτα τμήμα για συνεχίσετε!'
            redirect(action: "index")
            return errors
        }
        [departments: departments]
    }

    def save() {
        String date_of_birth = params.date_of_birth.replace("-", "/")
        def employee = employeeService.createEmployee(params.first_name, params.last_name, params.afm, date_of_birth, params.id_dep)
        if (!employee) {
            flash.error = 'Το ΑΦΜ που χρησιμοποιήσατε υπάρχει ήδη. Παρακαλώ γράψτε το δικό σας ΑΦΜ!'
        }
        redirect(action: "index")
    }

    def editEmployee(Integer id) {
        def employee = employeeService.getEmployee(id)
        def departments = departmentService.getAllDepartments()
        if (!employee) {
            flash.error = 'Ο εργαζομενος δεν βρεθηκε!'
            redirect(action: "index")
            return errors
        }
        [employee_id: id, first_name: employee.first_name, last_name: employee.last_name, afm: employee.afm, date_of_birth: employee.date_of_birth, departments: departments]
    }

    def updateEmployee(Integer id) {
        String date_of_birth = params.date_of_birth.replace("-", "/")
        employeeService.updateEmployee(id, params.first_name, params.last_name, params.afm, date_of_birth, params.id_dep)
        redirect(action: "index")
    }

    def deleteEmployee(Integer id) {
        employeeService.deleteEmployee(id)
        redirect(action: "index")
    }
}
