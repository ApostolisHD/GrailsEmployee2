package grailsemployee

class DepartmentsController {
    DepartureService departureService

    def create() {

    }

    def save(){
        departureService.createDeparture(params.name)
        println  "params ${params}"
        redirect(controller:"user", action:"index")
    }

}
