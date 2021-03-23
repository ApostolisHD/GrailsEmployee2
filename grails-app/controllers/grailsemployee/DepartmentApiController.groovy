package grailsemployee

class DepartmentApiController {

    def departmentService
    static responseFormats = ['json']

    def getAllDepartments() {
        def departments = departmentService.getAllDepartments()
        respond("departments": departments, status: 200)
    }

    def createDepartment() {
        def department = departmentService.createDepartment(params.name)
        if (department)
            respond("department": department, status: 201)
        else
            respond("error": null, status: 400)
    }

    def showDepartmentById(Integer id) {
        respond(departmentService.getDepartmentById(id), status: 200)
    }

    def editDepartment(Integer id) {
        def department = departmentService.updateDepartment(id, params.name)
        if (department)
            respond("department": department, status: 201)
        else
            respond("error": null, status: 400)
    }

    def deleteDepartment(Integer id) {
        def department = departmentService.deleteDepartment(id)
        if (department)
            respond("department": department, status: 201)
        else
            respond("error": null, status: 400)
    }
}
