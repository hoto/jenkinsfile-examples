pipeline {
  agent none
  stages {

    stage('Stage 1') {
      agent none
      steps {
        script {
          echo 'This stage does not block an executor, it costs nothing which is good.'
          milestone 1
          inputResponse = input([
            message           : 'Do you want to continue?',
            submitterParameter: 'submitter'
          ])
          milestone 2
          echo "Input response: ${inputResponse}"
        }
      }
    }

  }
}
