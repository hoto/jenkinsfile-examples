pipeline {
  agent none // agent can only be overwritten if the initial value is 'none'
  stages {

    stage('Stage 2') {
      agent any
      steps {
        timeout(time: 1, unit: 'MINUTES') {
          script {
            echo 'This stage does not block an executor because of "agent none"'
            milestone 1
            inputResponse = input([
              message           : 'Please confirm.',
              submitterParameter: 'submitter',
              parameters        : [
                [$class: 'BooleanParameterDefinition', defaultValue: true, name: 'param1', description: 'description1'],
                [$class: 'ChoiceParameterDefinition', choices: 'choice1\nchoice2', name: 'param2', description: 'description2']
              ]
            ])
            milestone 2
            echo "Input response: ${inputResponse}"
          }
        }
      }
    }

  }
}
