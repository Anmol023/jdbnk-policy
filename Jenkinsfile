pipeline {
    agent any

     environment {
        AWS_ACCESS_KEY_ID = credentials('jenkins-aws-access-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-key-id')
    }

    stages {
        stage('Publish') {
            steps {
                bat 'mvnw package'
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                    bat 'aws configure set region us-east-1'
                    bat 'aws lambda update-function-code --function-name jdbnk-policy --zip-file fileb://./target/jdbnk-policy-2.5.1.jar'
                }
            }
        }
    }
}
