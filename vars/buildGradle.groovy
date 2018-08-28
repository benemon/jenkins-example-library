//vars/buildGradle.groovy

def call(Map config) {
    node{
        echo "doing a Gradle build on build ${config.name}"
    }

}
