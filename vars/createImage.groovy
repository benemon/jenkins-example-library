//vars/createImage.groovy

def call(Map config) {
    node {
        echo 'Executing build of type ${config.type}'
    }
}
