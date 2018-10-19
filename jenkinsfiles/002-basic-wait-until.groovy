pipeline {
  agent any

  stages {

    stage('Stage 1') {
      options {
        timeout(time: 1, unit: 'MINUTES')
      }
      steps {
        waitUntil {
          script {
            echo 'This stage will succeed immediately without waiting for a minute.'
            return true
          }
        }
      }
    }

    stage('Stage 2') {
      steps {
        timeout(time: 1, unit: 'MINUTES') {
          waitUntil {
            script {
              echo 'Checking if google.com is up...'
              def status = sh script: 'wget -q https://google.com -O /dev/null', returnStatus: true
              return (status == 0)
            }
          }
        }
      }
    }

    stage('Stage 3') {
      options {
        timeout(time: 1, unit: 'MINUTES')
      }
      steps {
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


