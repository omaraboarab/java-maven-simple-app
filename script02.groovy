def buildJar() {
    echo "building jar file ..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building docker image ..."
withCredentials([usernamePassword(credentialsId:'DockerHub',passwordVariable:'PASSWORD',usernameVariable : 'USER' )])
{
        sh 'docker build -t omaraboarab/jmvn:Jmvn-2.0 .'
        sh "echo $PASSWORD | docker login -u $USER --password-stdin"
        sh 'docker push omaraboarab/jmvn:Jmvn-2.0'
} 
}
def deployApp() {
    echo 'deploying the application...'
} 

return this
