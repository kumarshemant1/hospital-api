pipeline {
  agent any

  environment {
    NEW_VERSION = '2.0'
  }
  
  stages {
    stage('Checkout') {
      steps {
        echo 'Processing GitHub Code Checkout...'
        echo "version : ${NEW_VERSION}"
      }
    }
    
    stage('Build') {
      steps {
        echo 'Building...'
      }
    }

    stage('Test') {
      steps {
        echo 'Testing...'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying...'
      }
    }
  }
  post {
    always {
      echo 'always...'
    }
    success {
      echo 'success'
    }
    failure {
      echo 'failure'
    }
  }
}
