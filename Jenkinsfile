pipeline {

    agent any

    tools {
        jdk 'jdk17'
    }

    options {
        parallelsAlwaysFailFast()
    }

    parameters {

        string(
                name: 'TAGS',
                defaultValue: 'smoke,api_users',
                description: 'Enter tags separated by comma'
        )
    }

    environment {
        GRADLE_OPTS = "-Dorg.gradle.daemon=false"
    }

    stages {

        stage('Checkout from GitHub') {

            steps {

                git branch: 'main',
                        url: 'git@github.com:darkill0/qa_test_pet_project.git',
                        credentialsId: 'github-ssh-key'
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

        stage('Run Parallel Tests') {

            steps {

                script {

                    def tags = params.TAGS
                            .split(',')
                            .collect { it.trim() }
                            .findAll { it }

                    echo "Selected tags: ${tags}"

                    def parallelStages = [:]

                    tags.each { currentTag ->

                        parallelStages["Run ${currentTag}"] = {

                            stage("Test ${currentTag}") {

                                sh """
                                    mkdir -p build/allure-results/${currentTag}

                                    chmod +x gradlew

                                    ./gradlew test \
                                    -Dtag=${currentTag} \
                                    -Dallure.results.directory=build/allure-results/${currentTag}
                                """
                            }
                        }
                    }

                    parallel parallelStages
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
    }
}