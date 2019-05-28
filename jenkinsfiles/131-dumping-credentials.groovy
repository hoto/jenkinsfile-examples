// https://github.com/hoto/jenkins-credentials-decryptor

pipeline {
  agent any
  stages {

    stage('Dump credentials') {
      steps {
        script {
           sh '''
             curl -L \
               "https://github.com/hoto/jenkins-credentials-decryptor/releases/download/0.0.5-alpha/jenkins-credentials-decryptor_0.0.5-alpha_$(uname -s)_$(uname -m)" \
                -o jenkins-credentials-decryptor

             chmod +x jenkins-credentials-decryptor
             
             ./jenkins-credentials-decryptor \
               -m $JENKINS_HOME/secrets/master.key \
               -s $JENKINS_HOME/secrets/hudson.util.Secret \
               -c $JENKINS_HOME/credentials.xml 
           '''
        }
      }
    }

  }
}
