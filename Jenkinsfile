@Library('studio-utils@master') _
//Library code can be found at https://github.com/mulesoft/tooling-jenkins-utils

def isReleaseBranch = (env.BRANCH_NAME == 'master')

pipeline {

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    tools {
        jdk getJDK(8)
        maven 'M3'
    }

    agent {
        label 'ubuntu-18.04'
    }

    stages {
        stage('Build') {
            when {
                anyOf {
                    expression {
                        return (!isReleaseBranch)
                    }
                    expression {
                        return (env.CHANGE_ID)
                    }
                }
            }
            steps {
                buildWithMaven("clean verify -U")
            }
        }

        stage('Deploy') {
            when {
                expression {
                    return (isReleaseBranch)
                }
            }
            steps {
                buildWithMaven("clean deploy -U")
            }
        }
    }

    post {
        always {
            script {
                junit allowEmptyResults: true, testResults: '**\\surefire-reports\\*.xml'
            }
        }
    }

}
