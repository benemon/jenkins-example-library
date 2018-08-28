//vars/createImage.groovy

def call(Map config) {
    node {
        echo "executing build of type ${config.type}"
    }
}
