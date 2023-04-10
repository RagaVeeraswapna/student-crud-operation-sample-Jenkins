pipeline{
	agent any
	environment {
       PATH = "C:\\WINDOWS\\SYSTEM32"
    }
    tools { 
      maven 'swapna_maven'
      jdk 'swapna_jdk' 
    }
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
				bat 'chmod a+x mvnw'
				bat './mvnw clean package -DskipTests=true' 
			}
			
			post{
				always{
					archiveArtifacts 'target/*.jar'
				}
			}
		}
		
		stage(DockerBuild){
			steps{
				bat 'docker build -t student-crud-demo/student-crud-operations-sample:latest .'
			}
		}
		
	}

}
