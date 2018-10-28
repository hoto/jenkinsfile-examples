jsl = library(
  identifier: 'jenkins-shared-library@1.0.4',
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/hoto/jenkins-shared-library.git'
    ]
  )
)

pipeline {
  agent any
  stages {

    stage('Where is Jenkins Shared Library cloned') {
      steps {
        script {
          sh 'pwd'
          sh 'ls -la'
          sh 'ls -la ../'
          sh 'ls -la ../050-shared-library-where-is-it-cloned@libs'
          sh 'ls -la ../050-shared-library-where-is-it-cloned@libs/jenkins-shared-library'
          sh 'cd ../050-shared-library-where-is-it-cloned@libs/jenkins-shared-library && git remote -v'
        }
      }
    }

  }
}

