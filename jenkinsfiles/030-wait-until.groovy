pipeline {
  agent any

  stages {

    stage('Stage 1') {
      steps {
        timeout(time: 1, unit: 'MINUTES') {
          waitUntil {
            script {
              echo 'This stage will succeed immediately without waiting for a minute.'
              return true
            }
          }
        }
      }
    }

    stage('Stage 2') {
      steps {
        timeout(time: 1, unit: 'MINUTES') {
          waitUntil {
            script {
              echo 'This stage should succeed immediately if google.com is up, otherwise jenkins will retry until 1min runs out.'
              def status = sh script: 'wget -q https://google.com -O /dev/null', returnStatus: true
              return (status == 0)
            }
          }
        }
      }
    }

    stage('Stage 3') {
      steps {
        timeout(time: 10, unit: 'SECONDS') {
          waitUntil {
            script {
              echo 'This stage will be executed again and again until 10sec is reached and then the stage will be marked as failure.'
              return false
            }
          }
        }
      }
    }

  }
}


