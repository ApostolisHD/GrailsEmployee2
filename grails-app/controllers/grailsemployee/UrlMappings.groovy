package grailsemployee

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "authentication", action: "Login")

        "/authentication"(controller:"authenticationApi",action:"login",method:"GET")
        "/authentication/logout"(controller:"authenticationApi",action:"logout",method:"GET")

        "/employee"(controller: "employeeApi", action: "getAllEmployees", method: "GET")
        "/employee"(controller: "employeeApi", action: "createEmployee", method: "POST")
        "/employee/$id"(controller: "employeeApi", action: "showEmployeeById", method:"GET")
        "/employee/$id"(controller: "employeeApi", action: "editEmployee", method:"PUT")
        "/employee/$id"(controller: "employeeApi", action: "deleteEmployee", method:"DELETE")

        "/department"(controller: "departmentApi", action: "getAllDepartments", method: "GET")
        "/department"(controller: "departmentApi", action: "createDepartment", method: "POST")
        "/department/$id"(controller: "departmentApi", action: "showDepartmentById", method:"GET")
        "/department/$id"(controller: "departmentApi", action: "editDepartment", method:"PUT")
        "/department/$id"(controller: "departmentApi", action: "deleteDepartment", method:"DELETE")

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
