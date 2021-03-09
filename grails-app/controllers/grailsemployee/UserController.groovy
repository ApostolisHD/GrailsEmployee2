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
                println"${employee}"
                [employee_id:employee.employee_id,first_name:employee.first_name,last_name:employee.last_name,afm:employee.afm]
            }

            def update(Integer id){
                println"${id}"
                userService.updateEmployee(id,params.first_name,params.last_name,params.afm)
                redirect(action:"index")
            }

}
