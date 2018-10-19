jenkinsSharedLibrary = library(
  identifier: 'jenkins-shared-library@1.0.1',
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/hoto/jenkins-shared-library.git'
    ]
  )
)


def sharedLibraryPackage = jenkinsSharedLibrary.com.mycompany.jenkins
def build = sharedLibraryPackage.Build.new(this)

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
