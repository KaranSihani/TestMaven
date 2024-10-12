pipeline {
    agent any
    
    tools {
        maven 'Maven3.9.7'
    }
    
    stages {
        stage('checkout'){
            steps {
            checkout changelog: false, poll: false, scm: scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KaranSihani/TestMaven.git']])
         }
		}
        
        stage('build'){
            steps {
                 bat 'mvn clean'
            }
        }
         stage('test'){
            steps {
                 bat 'mvn test'
            }
        }
        stage('code quality'){
           steps {
              withSonarQubeEnv('FirstTest') {
               bat 'mvn clean verify sonar:sonar'
              }
        }
      }
      
      stage('Publish to Artifactory'){
           steps {
              rtMavenDeployer(
			  id: 'deployer',
			  serverId: 'KaranSihani',
			  releaseRepo: 'Test.KaranSihani',
			  snapshotRepo: 'Test.KaranSihani'
              )
			  rtMavenRun(
			  pom: 'pom.xml',
			  goals: 'clean install',
			  deployerId: 'deployer'
			  )
			  rtPublishBuildInfo(
			  serverId: 'KaranSihani'
			  )
			 } 
			  
        }
        
    }
 }
