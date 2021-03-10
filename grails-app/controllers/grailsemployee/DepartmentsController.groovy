package grailsemployee

class DepartmentsController {
    DepartmentService departmentService

    def create() {

    }

    def save(){
        departmentService.createDepartment(params.name)
        println  "params ${params}"
        redirect(controller:"user", action:"index")
    }

}
