pipeline {
  agent any
  stages {

    stage('usernamePassword') {
      steps {
        script {
          withCredentials([
            usernamePassword(credentialsId: 'gitlab',
              usernameVariable: 'username',
              passwordVariable: 'password')
          ]) {
            print 'username, password='
            print username + password

            print 'username.collect { it }='
            print username.collect { it }

            print 'password.collect { it }='
            print password.collect { it }
          }
        }
      }
    }

    stage('usernameColonPassword') {
      steps {
        script {
          withCredentials([
            usernameColonPassword(
              credentialsId: 'gitlab',
              variable: 'userpass')
          ]) {
            print 'userpass='
            print userpass

            print 'userpass.collect { it }='
            print userpass.collect { it }
          }
        }
      }
    }
  }
}
