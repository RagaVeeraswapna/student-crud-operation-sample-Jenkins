pipeline{
	agent any
	stages{
		stage('Checkout'){
			steps{
				git branch: "main", url: 'https://github.com/RagaVeeraswapna/student-crud-operation-sample-Jenkins.git'
			
			}
			
		}
		stage('Clean') {
           steps{
               echo "######################## Cleaning the project"
               bat 'mvn clean'
           }
        }
        stage('Compile') {
           steps{
               echo "######################## Compile the project"
               bat 'mvn compile'
           }
        }
		
		stage('Build'){
			steps{
				sh 'chmod a+x mvnw'
				sh './mvnw clean package -DskipTests=true' 
			}
			
			post{
				always{
					archiveArtifacts 'target/*.jar'
				}
			}
		}
		
		stage(DockerBuild){
			steps{
				sh 'docker build -t student-crud-demo/student-crud-operations-sample:latest .'
			}
		}
		
	}

}