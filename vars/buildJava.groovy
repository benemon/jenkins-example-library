//vars/buildMaven.groovy

def call(Map config) {


    // check if the build type is explicitly configured
    if (config?.type)
    {
        if (config.type.toLowerCase() == 'maven')
        {
            mavenBuild()
        }
        if (config.type.toLowerCase() == 'gradle')
        {
            gradleBuild()
        }
    }

    // else try and work it out
    def isMaven = fileExists 'pom.xml'
    def isGradle = fileExists 'build.gradle'

    if (isMaven && !isGradle)
    {
        mavenBuild()
    }

    else if (!isMaven && isGradle)
    {
        gradleBuild()
    }

    else {
        error "Build failed due to indeterminate build strategy"
    }
}


// Method to support Maven build steps
def mavenBuild(String name) {
    echo "starting maven build for project ${JOB_NAME}"
}

// method to support Gradle build steps
def gradleBuild(String name) {
    echo "starting gradle build for project ${JOB_NAME}"
}
