// This is an counter example. Do NOT use it.

pipeline {
  agent any
  stages {

    stage('Stage 2') {
      agent none // this does not change anything as agent can only be overwritten if the parent agent is 'none'
      steps {
        timeout(time: 1, unit: 'MINUTES') {
          script {
            echo 'This stage does block an executor because it inherits the "agent any" from the pipline.'
            milestone 1
            inputResponse = input([
              message           : 'Please confirm.',
              submitterParameter: 'submitter'
            ])
            milestone 2
            echo "Input response: ${inputResponse}"
          }
        }
      }
    }

  }
}
