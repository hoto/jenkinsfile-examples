// DO NOT USE THIS
// This is an example of a BAD Jenkinsfile

pipeline {
  agent any // this cannot be relaxed by the child stage to 'none', stages will block an executor
  stages {

    stage('Stage 1') {
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
