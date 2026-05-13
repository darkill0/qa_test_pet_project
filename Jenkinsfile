pipeline {

    agent any

    tools {
        jdk 'jdk17'
    }

    parameters {

        string(
                name: 'TAGS',
                defaultValue: 'smoke',
                description: 'Enter tags separated by comma'
        )
    }

    environment {

        GRADLE_OPTS = '-Xmx2g -Dorg.gradle.daemon=false'
    }

    stages {

        stage('Checkout from GitHub') {

            steps {

                git(
                        branch: 'main',
                        url: 'git@github.com:darkill0/qa_test_pet_project.git',
                        credentialsId: 'github-ssh-key'
                )
            }
        }

        stage('Check Environment') {

            steps {

                sh '''
                    echo "========== JAVA =========="
                    java -version

                    echo "========== CHROME =========="
                    google-chrome --version || true

                    echo "========== MEMORY =========="
                    free -h || true

                    echo "========== CPU =========="
                    nproc || true
                '''
            }
        }

        stage('Prepare Allure Directories') {

            steps {

                sh '''
                    rm -rf build/allure-results
                    mkdir -p build/allure-results
                '''
            }
        }

        stage('Run Tests') {

            steps {

                script {

                    def tags = params.TAGS
                            .split(',')
                            .collect { it.trim() }
                            .findAll { it }

                    echo "Selected tags: ${tags}"

                    for (String currentTag : tags) {

                        echo "Running tag: ${currentTag}"

                        sh """
                            chmod +x gradlew

                            ./gradlew clean test \
                            -Dtag=${currentTag} \
                            --stacktrace \
                            --info \
                            --no-daemon \
                            -Dallure.results.directory=build/allure-results/${currentTag}
                        """
                    }
                }
            }
        }

        stage('Generate Allure Report') {

            steps {

                script {

                    def tags = params.TAGS
                            .split(',')
                            .collect { it.trim() }
                            .findAll { it }

                    def allureResults = tags.collect {
                        [path: "build/allure-results/${it}"]
                    }

                    allure(
                            includeProperties: false,
                            jdk: '',
                            results: allureResults
                    )
                }
            }
        }
    }

    post {

        always {

            archiveArtifacts(
                    artifacts: 'build/allure-results/**/*',
                    allowEmptyArchive: true
            )
        }

        failure {

            echo 'Pipeline failed'
        }

        success {

            echo 'Pipeline finished successfully'
        }
    }
}