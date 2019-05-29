def call(Map config) {
    pipeline {

        // logrotate on builds so we don't fill up our history
        options {
            buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
        }

        // it's often easiest to define a global agent for the entire build
        agent {
            label 'config.agent'
        }

        stages {

            stage('Java Build') {
                steps{
                    buildJava name: "config.jobName",
                              type: "config.jobType"
                }

            }

            stage('Dependency Check') {
                steps {
                    dependencyCheck()
                }
            }

            stage('Create Image') {
                steps{
                    createImage type: "config.buildStrategy"
                }
            }

            stage('Publish Image') {
                steps{
                    publishImage externalRegistry: "config.stagingRegistry"
                }
            }
        }
    }

}
