pipeline {
  agent any
  stages {
    stage('Stage 1') {
      steps {
        script {
          echo 'Stage 1'
        }
      }
    }
    stage('Stage 2') {
      agent any
      steps {
        script {
          echo 'Stage 2'
        }
      }
      post {
        always {
          script {
            echo 'stage2.always'
          }
        }
        success {
          script {
            echo 'stage2.success'
          }
        }
        changed {
          script {
            echo 'stage2.changed'
          }
        }
        aborted {
          script {
            echo 'stage2.aborted'
          }
        }
        failure {
          script {
            echo 'stage2.failure'
          }
        }
      }
    }

  }
  post {
    always {
      script {
        echo 'post.always'
      }
    }
    success {
      script {
        echo 'post.success'
      }
    }
    changed {
      script {
        echo 'post.changed'
      }
    }
    aborted {
      script {
        echo 'post.aborted'
      }
    }
    failure {
      script {
        echo 'post.failure'
      }
    }
  }
}
