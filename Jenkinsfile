pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-cloud-token')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Unit Tests') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.token=${SONAR_TOKEN}'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t quiz-service .'
            }
        }

        stage('Cleanup') {
            steps {
                sh 'docker image prune -f'
            }
        }
    }

    post {
        success {
            echo 'Quiz Service built and analyzed successfully!'
        }
        failure {
            echo 'Build failed. Check logs.'
        }
    }
}
