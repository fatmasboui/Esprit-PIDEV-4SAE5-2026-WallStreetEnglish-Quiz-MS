pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-17'
        }
    }

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
    }

    post {
        success {
            echo 'Quiz Service built and analyzed successfully!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
