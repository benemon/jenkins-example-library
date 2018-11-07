//vars/createImage.groovy

def call(Map config) {
    
    echo '============================================'
    echo 'creating ${config.name} from binary artifact'
    echo '============================================'
    
    script {
        openshift.withCluster() {
            openshift.startBuild("${config.name}", "--from-dir=${config.artifactDir}", "--follow")
        }
    }
}
