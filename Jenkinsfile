pipeline {
    agent any
    tools {
        maven 'Maven-3.9.9'
    }

    stages {
        stage('Checkout Source Code'){
            steps {
                checkout scm
            }
        }

        stage('Build and Test'){
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Package Application'){
            steps {
                sh 'mvn package -DskipsTests'
            }
        }

        stage('Archive JAR'){
            steps {
                archiveArtifacts artifacts: 'target/*.jar',
                fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Build, tests and packaging completed.'
        }

        failure{
            echo 'FAILED: Check the Jenkins Console output'
        }
    }
}