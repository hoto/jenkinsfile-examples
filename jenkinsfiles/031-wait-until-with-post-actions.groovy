pipeline {
  agent any

  stages {

    stage('Stage 3') {
      steps {
        timeout(1) {
          waitUntil {
            script {
              echo 'This stage will execute again and again until timeout is reached then the stage will fail.'
              return false
            }
          }
        }
      }
    }

  }
}


