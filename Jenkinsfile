pipeline {
    agent any

    // This allows webhook-based automatic triggering
    triggers {
        githubPush()
    }

    options {
        disableConcurrentBuilds()
        timestamps()
    }

    stages {

        stage('Pull Latest Image') {
            steps {
                echo "Pulling latest Docker image..."
                sh 'docker pull vasubabu564/cicd-app:latest'
            }
        }

        stage('Stop Old Container') {
            steps {
                echo "Stopping old container if exists..."
                sh '''
                    docker stop cicd-app || true
                    docker rm cicd-app || true
                '''
            }
        }

        stage('Run New Container') {
            steps {
                echo "Starting new container..."
                sh '''
                    docker run -d \
                      --name cicd-app \
                      -p 7788:7788 \
                      vasubabu564/cicd-app:latest
                '''
            }
        }
    }

    post {
        success {
            echo "✅ Deployment successful"
        }
        failure {
            echo "❌ Deployment failed"
        }
    }
}
