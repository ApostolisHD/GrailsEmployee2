package grailsemployee

class UserController {
    UserService userService

        def index() {
            def employees = userService.getAllEmployees()
            [employees:employees]
            }
            def delete(def id){
                def deleteEmployee = userService.deleteEmployee(id)
                redirect(action:"index")
            }
            def create(def first_name, def last_name,def afm, def date_of_birth){
                def createEmployee = userService.createEmployee(first_name,last_name,afm,date_of_birth)
                redirect(action:"index")
            }

}
