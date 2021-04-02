package grailsemployee

class DepartmentApiController {

    def departmentService
    static responseFormats = ['json']

    def getAllDepartments() {
        def department = departmentService.getAllDepartments()
        respond("department": department, status: 200)
    }

    def createDepartment() {
        try {
            def department = departmentService.createDepartment(request.JSON.name)
            if (department != null) {
                respond("department": department, status: 201)
            } else {
                respond("error": null, status: 400)
            }
        }
        catch (Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }

    def showDepartmentById(Integer id) {
        def department = departmentService.getDepartmentById(id)
        try {
            if (department) {
                respond("department": department, status: 200)
            } else {
                respond("error": null, status: 404)
            }
        } catch (Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }

    def editDepartment(Integer id) {
        try {
            def department = departmentService.updateDepartment(id, request.JSON.name)
            if (department != null) {
                respond("department": department, status: 200)
            } else {
                respond("error": null, status: 400)
            }
        }
        catch (Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }

    def deleteDepartment(Integer id) {
        try {
            def department = departmentService.deleteDepartment(id)
            if(department) {
                respond(status: 202)
            }else{
                respond("error": null, status: 400)
            }
        }
        catch (Exception exception) {
            exception.printStackTrace()
            respond("error": null, status: 500)
        }
    }
}
