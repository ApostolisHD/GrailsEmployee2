package grailsemployee

class UserController {
    UserService userService
    DepartureService departureService

        def index() {
            def employees = userService.getAllEmployees()
            println "${employees}"
            [employees:employees]
            }

            def delete(Integer id){
                userService.deleteEmployee(id)
                redirect(action:"index")
            }

            def create(){
            }

            def save(){
                String dob = params.date_of_birth.replace("-","/")
                userService.createEmployee(params.first_name,params.last_name,params.afm,dob)
                departureService.createDeparture(params.name)
                println"${params}"
                redirect(action:"index")
            }

            def edit(Integer id){
                def response = userService.getEmployee(id)
                [employee_id:response.employee_id,first_name:response.first_name,last_name:response.last_name,afm:response.afm,name:response.name]
            }

            def update(Integer id){
                println"${id}"
                userService.updateEmployee(id,params.first_name,params.last_name,params.afm)
                redirect(action:"index")
            }
}
