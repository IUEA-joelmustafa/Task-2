pipeline {
    agent none

    stages {

        stage('Manual Checkout') {
            agent { label 'docker-java' }
            steps {
                sh '''
                    git init
                    git remote add origin https://github.com/IUEA-joelmustafa/Task-2.git
                    git fetch origin main
                    git checkout main
                '''
                stash name: 'source-code', includes: '**'
            }
        }

        stage('Database Check') {
            agent { label 'java-static-agent' }
            steps {
                unstash 'source-code'
                echo "Checking environment on the static agent..."
                sh '''
                    echo "=== Environment Check ==="
                    echo "Host: $(hostname)"
                    echo "Java: $(java -version 2>&1 | head -1)"
                    echo "Disk: $(df -h ~ | tail -1)"
                    echo "=== Check Passed ==="
                '''
            }
        }

        stage('Build & Test') {
            agent { label 'docker-java' }
            steps {
                unstash 'source-code'
                dir('Simple') {
                    echo "Building Java project on Docker Agent..."
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
                echo "Deploying artifact from Static Agent to Staging..."
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
                unstash 'source-code'
                junit testResults: '**/target/surefire-reports/*.xml',
                      allowEmptyResults: true
            }
        }
    }
}
