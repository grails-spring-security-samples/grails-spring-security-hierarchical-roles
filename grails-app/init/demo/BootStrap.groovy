package demo

class BootStrap {

    def init = { servletContext ->

        final boolean flush = true
        final boolean failOnError = true
        def role = new Role(authority: 'ROLE_DETECTIVE')
        role.save(flush: flush, failOnError: true)
        def user = new User(username: 'sherlock', password: 'elementary')
        user.save(flush: flush)
        def userRole = new UserRole(role: role, user: user)
        userRole.save(flush: flush, failOnError: failOnError)


    }
    def destroy = {
    }
}
