package asifbindinglimit

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DemoController)
class DemoControllerSpec extends Specification {

    void "test parameter binding"() {
        given:
        9482.times {
            params."names[${it}]" = "Value ${it}"
        }

        when:
        controller.createWidget()

        then:
        response.json.names.size() == 9482
        response.json.names[0] == 'Value 0'
        response.json.names[1] == 'Value 1'
        response.json.names[2] == 'Value 2'
        response.json.names[9479] == 'Value 9479'
        response.json.names[9480] == 'Value 9480'
        response.json.names[9481] == 'Value 9481'
    }
}
