package grailsemployee

import javax.transaction.Transactional
import groovy.sql.Sql

@Transactional
class DepartureService {

    def dataSource

        def getAllDeparture(){
            def sql = new Sql(dataSource)
            return sql.rows("SELECT * from departure")
        }

        def createDeparture(def name){
            def sql = new Sql(dataSource)
            sql.executeInsert("INSERT INTO departure (name) VALUES (${name}")
        }
}
