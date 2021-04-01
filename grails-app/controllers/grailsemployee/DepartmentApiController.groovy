package grailsemployee

class DepartmentApiController {

    def departmentService
    static responseFormats = ['json']

    def getAllDepartments() {
        def departments = departmentService.getAllDepartments()
        respond(departments, status: 200)
    }

    def createDepartment() {
        def department = departmentService.createDepartment(request.JSON.name)
        if (department)
            respond("department": department, status: 201)
        else
            respond("error": null, status: 400)
    }

    def showDepartmentById(Integer id) {
        def department=departmentService.getDepartmentById(id)
        if (department)
            respond("department": department, status: 200)
        else
            respond("error": null, status: 404)
    }

    def editDepartment(Integer id) {
        def department = departmentService.updateDepartment(id, request.JSON.name)
        if (department) {
            respond("department": department, status: 200)
        }
        else {
            respond("error": null, status: 400)
        }
    }

    def deleteDepartment(Integer id) {
        def department = departmentService.deleteDepartment(id)
        if (department)
            respond("department": department, status: 202)
        else
            respond("error": null, status: 400)
    }
}
