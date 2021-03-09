package grailsemployee

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UserController {
    UserService userService

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
                redirect(action:"index")
            }

            def edit(Integer id){
                def response = userService.getEmployee(id)
                [employee_id:response.employee_id[0],first_name:response.first_name[0],last_name:response.last_name[0],afm:response.afm[0],name:response.name[0]]
            }

            def update(Integer id){
                println"${id}"
                userService.updateEmployee(id,params.first_name,params.last_name,params.afm)
                redirect(action:"index")
            }

}
