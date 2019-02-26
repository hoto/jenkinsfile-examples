pipeline {
  agent any

  stages {

    stage('Stage 1') {
      steps {
        timeout(time: 1, unit: 'SECONDS') {
          waitUntil {
            script {
              echo 'This stage will execute again and again until timeout is reached then the stage will fail.'
              return false
            }
          }
        }
      }
      post {
        always { script { echo 'post.stage1.always' } }
        success { script { echo 'post.stage1.success' } }
        changed { script { echo 'post.stage1.changed' } }
        aborted { script { echo 'post.stage1.aborted' } }
        failure { script { echo 'post.stage1.failure' } }
      }
    }
  }

  post {
    always { script { echo 'post.always' } }
    success { script { echo 'post.success' } }
    changed { script { echo 'post.changed' } }
    aborted { script { echo 'post.aborted' } }
    failure { script { echo 'post.failure' } }
  }
}


