package grailsemployee

class UserController {
    UserService userService
    DepartureService departureService

    def index() {
        def employees = userService.getAllEmployees()
        [employees: employees]
    }

    def delete(Integer id) {
        userService.deleteEmployee(id)
        redirect(action: "index")
    }

    def create() {
        def departure = departureService.getAllDeparture()
        [departure: departure]
    }

    def save(Integer id_dep) {
        String date_of_birth = params.date_of_birth.replace("-", "/")
        userService.createEmployee(params.first_name, params.last_name, params.afm, date_of_birth, id_dep)
        println "${params}"
        redirect(action: "index")
    }

    def edit(Integer id) {
        def response = userService.getEmployee(id)
        def departure = departureService.getAllDeparture()
        [employee_id: response.employee_id, first_name: response.first_name, last_name: response.last_name, afm: response.afm,departure:departure]
    }

    def update(Integer id) {
        userService.updateEmployee(id, params.first_name, params.last_name, params.afm,params.id_dep)
        redirect(action: "index")
    }


}
