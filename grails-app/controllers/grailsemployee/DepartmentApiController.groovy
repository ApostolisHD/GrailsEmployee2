package grailsemployee

class DepartmentApiController {

    def departmentService
    static responseFormats = ['json']

    def getAllDepartments() {
        def departments = departmentService.getAllDepartments()
        respond(departments, status: 200)
    }

    def createDepartment() {
        println("params${request.JSON}")
        def department = departmentService.createDepartment(request.JSON.name)
        if (department)
            respond("department": department, status: 200)
        else
            respond("error": null, status: 500)
    }

    def showDepartmentById(Integer id) {
        respond(departmentService.getDepartmentById(id), status: 200)
    }

    def editDepartment(Integer id) {
        def department = departmentService.updateDepartment(id, request.JSON.name)
        if (department)
            respond("department": department, status: 200)
        else
            respond("error": null, status: 500)
    }

    def deleteDepartment(Integer id) {
        def department = departmentService.deleteDepartment(id)
        if (department)
            respond("department": department, status: 200)
        else
            respond("error": null, status: 500)
    }
}
