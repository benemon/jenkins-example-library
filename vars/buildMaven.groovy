//vars/buildMaven.groovy

def call(Map config) {
    node {
        echo "doing a Maven build on build ${config.name}"
    }
}
