//vars/getApproval.groovy

def call(Map config) {
    
    echo '=========================================='
    echo 'get deployment approval for ${config.name}'
    echo '=========================================='

    timeout(time:${config.waitMinutes}, unit:'MINUTES') {
        input message: "approve deployment of ${config.name}?", ok: "yes"
    }
}
