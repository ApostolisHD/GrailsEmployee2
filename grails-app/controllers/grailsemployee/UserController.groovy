package grailsemployee

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UserController {
    UserService userService

        def index() {
            def employees = userService.getAllEmployees()
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
                def employee = userService.getEmployee(id)
                [first_name:params.first_name,last_name:params.last_name,afm:params.afm,date_of_birth:params.date_of_birth]
            }

            def update(){
                userService.updateEmployee(params.first_name,params.last_name,params.afm,params.date_of_birth)
                redirect(action:"index")
            }

}
