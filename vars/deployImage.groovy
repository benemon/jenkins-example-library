//vars/deployImage.groovy

def call(Map config) {
    
    echo '============================================'
    echo 'deploy latest ${config.name} container image'
    echo '============================================'
    
    script {
        openshift.withCluster() {
            openshift.withProject() {
                dc = openshift.selector("dc", "${config.name}")
                dc.rollout().latest()
                timeout(10) {
                    dc.rollout().status("-w")
                }
            }
        }
    }
}
