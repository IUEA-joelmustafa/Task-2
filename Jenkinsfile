pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/IUEA-joelmustafa/Task-2.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }

        failure {
            emailext(
                subject: 'Build Failed',
                body: 'Unit tests failed.',
                to: 'team@example.com'
            )
        }
    }
}
