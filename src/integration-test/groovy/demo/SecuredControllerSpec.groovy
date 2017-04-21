package demo

import geb.spock.GebSpec
import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.integration.Integration

@Integration
class SecuredControllerSpec extends GebSpec {

    def setup() {
        browser.baseUrl = "http://localhost:${serverPort}/"
    }

    def "test"() {
        when:
        to SecuredPage

        then:
        at LoginPage

        when:
        login('sherlock', 'elementary')

        then:
        $().text().contains 'Sorry, you\'re not authorized to view this page.'

        when:
        go 'secured/grantRoleHierarchyEntry'

        then:
        $().text() == 'OK'

        when:
        to SecuredPage

        then:
        $().text().contains 'you have ROLE_ADMIN'
    }
}
