package grailsemployee

class DepartmentsController {
    def departmentService
    def createDepartment() {}

    def saveDepartment() {
        departmentService.createDepartment(params.name)
        redirect(controller: "employees", action: "index")
    }

    def editDepartment(Integer id) {
        def department = departmentService.getDepartmentById(id)
        if (!department) {
            flash.error = 'Το τμημα δεν βρεθηκε!'
            redirect(controller: "employees", action: "index")
            return null
        }
        [department_id: department.department_id, name: department.name]
    }

    def updateDepartment(Integer id) {
        departmentService.updateDepartment(id, params.name)
        redirect(controller: "employees", action: "index")
    }

    def deleteDepartment(Integer id) {
        def department = departmentService.deleteDepartment(id)
        if (department) {
            redirect(controller: "employees", action: "index")
        } else {
            flash.message = 'Δεν μπορεις να διαγραψεις αυτο το τμημα. Γιατι εχει εργαζομενους!'
            redirect(controller: "employees", action: "index")
        }
    }
}
