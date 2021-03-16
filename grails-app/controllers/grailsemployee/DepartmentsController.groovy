package grailsemployee

class DepartmentsController {
    DepartmentService departmentService

    def createDepartment() {

    }

    def saveDepartment(){
        departmentService.createDepartment(params.name)
        redirect(controller:"employees", action:"index")
    }

    def editDepartment(Integer id) {
        def response = departmentService.getDepartmentById(id)
        if(!response) {
            flash.error = 'Το τμημα δεν βρεθηκε!'
            redirect(controller: "employees", action: "index")
            return errors
        }
        [department_id:response.department_id, name:response.name]
    }

    def updateDepartment(Integer id) {
        departmentService.updateDepartment(id, params.name)
        redirect(controller: "employees",action: "index")
    }

    def deleteDepartment(Integer id) {
        def response = departmentService.deleteDepartment(id)

        if(response){
            redirect(controller: "employees" , action: "index")
        }
        else {
            flash.message = 'Δεν μπορεις να διαγραψεις αυτο το τμημα. Γιατι εχει εργαζομενους!'
            redirect(controller: "employees", action: "index")
        }
    }

}
