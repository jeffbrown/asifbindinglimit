package asifbindinglimit

import grails.converters.JSON

class DemoController {

    def createWidget(Widget w) {
        render w as JSON
    }
}

class Widget {
    List<String> names
}
