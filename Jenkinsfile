pipeline {
    agent any

    tools {
        maven 'Maven'    
        jdk 'JDK17'     
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Cloning repo"
                checkout scm
            }
        }

        stage('Run_Tests') {
            steps {
                echo "Running tests"
                bat 'mvn clean test -Dallure.results.directory=allure-results'
            }
        }

        stage('Allure_Report') {
            steps {
                echo "Generating allure reports"
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'allure-results']]
                ])
            }
        }

        stage('Finishing') {
            steps {
                echo "Stages are finished"
            }
        }
    }

    post {
        always {
            echo "Pipeline is over"
        }
        failure {
            echo "Error"
        }
    }
}
