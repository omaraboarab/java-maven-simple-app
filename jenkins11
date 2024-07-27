pipeline {
    agent any
    tools {
        maven 'maven-3.6' //from the tools configartion
    }
    stages {
        stage("build jar") {
            steps {
                echo 'Building the application ...'
                sh 'mvn package'
            }
        }
        stage('build image') {
            steps {
                echo 'Building the docker image  ...'
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t GH_USERNAME:demo-app:2.0.0 .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push GH_USERNAME:demo-app:2.0.0'
                }
            }
        }
        stage('deploy') {
            steps {
                echo 'Deploying the application ...'
            }
        }        
    }
}
