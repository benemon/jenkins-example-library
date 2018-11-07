//vars/buildMaven.groovy

def call(Map config) {
    pom = readMavenPom file: 'pom.xml'
    
    echo '=========================================='
    echo 'executing maven build of ${pom.artifactId}'
    echo '=========================================='
    
    sh 'mvn clean package ${config.mavenOpts}; mkdir -p ${config.artifactDir};cp target/*.jar ${config.artifactDir}/'
}
