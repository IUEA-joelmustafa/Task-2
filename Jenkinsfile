pipeline {
    agent none

    stages {

        stage('Manual Checkout') {
            agent { label 'docker-java' }
            steps {
                checkout scm
                stash name: 'source-code', includes: '**'
            }
        }

        stage('Database Check') {
            agent { label 'java-static-agent' }
            steps {
                unstash 'source-code'
                sh '''
                    echo "=== Environment Check ==="
                    echo "Host: $(hostname)"
                    java -version
                    echo "=== Check Passed ==="
                '''
            }
        }

        stage('Build & Test') {
            agent { label 'docker-java' }
            steps {
                unstash 'source-code'
                dir('Simple') {
                    sh 'mvn clean install -Djava.awt.headless=true'
                }
                stash name: 'app-artifact', includes: 'Simple/target/*.jar'
            }
        }

        stage('Deploy to Staging') {
            agent { label 'java-static-agent' }
            steps {
                unstash 'source-code'
                unstash 'app-artifact'
                dir('Simple') {
                    sh 'chmod +x deploy.sh && ./deploy.sh staging'
                }
            }
        }
    }

    post {
        success {
            echo 'Build successful! Project is live.'
        }
        failure {
            echo 'Build failed! Check the logs.'
        }
        always {
            node('java-static-agent') {
                junit testResults: '**/target/surefire-reports/*.xml',
                      allowEmptyResults: true
            }
        }
    }
}
