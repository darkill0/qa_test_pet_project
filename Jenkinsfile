pipeline{
    agent any

    tools {
        jdk 'openjdk25'
    }

    enviroment {
        GRADLE_OPTS = "-Dorg.gradle.daemon=false"
    }

    stages {
        stage("Checkout from GiyHUb"){
            steps {
                get branch: 'main',
                    url: 'git@github.com:darkill0/qa_test_pet_project.git',
                        credentialsId: 'github-ssh-key'
            }

        }
        stage("Run Users Tests")
                {
                    steps{
                        sh './gradlew clean test -Dtag=api_users'
                    }
                }
        stage("Run Production Tests")
                {
                    steps {
                        sh './gradlew test -Dtag=api-products'
                    }
                }
        stage('Allure Report'){
            steps{
                allure includeProperties: false, results: [[path: 'build/allure-results']]
            }
        }
    }

    post{
        always{
            archiveArtifacts artifacts: 'build/allure-results/**', allowEmptyArchive: true
        }
    }
}