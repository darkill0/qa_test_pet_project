pipeline{
    agent any

    tools {
        jdk 'jdk17'
    }

    parameters {
        string(
                name: 'TAGS',
                defaultValue: 'smoke',
                description: 'Enter one or multiple tags separated by comma. Example: smoke,regress,api'
        )
    }

    environment  {
        TAG = "${params.TAGS}"
    }

    stages {
        stage("Checkout from GitHUb"){
            steps {
                git branch: 'main',
                    url: 'git@github.com:darkill0/qa_test_pet_project.git',
                        credentialsId: 'github-ssh-key'
            }

        }
        stage('Run Tests') {

            steps {

                script {

                    echo "Running tags: ${TAG}"

                    sh """
                        chmod +x gradlew
                        ./gradlew clean test -Dtag=${TAG}
                    """
                }
            }
        }

        stage('Generate Allure Report') {

            steps {

                allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'build/allure-results']]
                ])
            }
        }
    }

    post{
        always{
            archiveArtifacts artifacts: 'build/allure-results/**', allowEmptyArchive: true
        }
    }
}