package demo

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='entry')
@ToString(includes='entry', includeNames=true, includePackage=false)
class RoleHierarchyEntry implements Serializable {

	private static final long serialVersionUID = 1

	String entry

	static constraints = {
		entry blank: false, unique: true
	}

	static mapping = {
		cache true
	}
}
