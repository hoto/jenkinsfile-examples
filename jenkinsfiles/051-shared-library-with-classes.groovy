jsl = library(
  identifier: 'jenkins-shared-library@1.0.4',
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/hoto/jenkins-shared-library.git'
    ]
  )
)


def build = jsl.com.mycompany.jenkins.Build.new(this)

pipeline {
  agent any
  stages {

    stage('Stage 1') {
      steps {
        script {
          build.setBuildDescription(
            title: 'Build title.',
            description: 'Build description.'
          )
        }
      }
    }

  }
}
