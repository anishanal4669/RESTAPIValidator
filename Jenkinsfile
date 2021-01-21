pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        build(job: 'RESTAPIVAlidator', propagate: true, wait: true)
      }
    }

    stage('') {
      steps {
        build(job: 'myfolder/my-freestyle-job', propagate: true, quietPeriod: 5, wait: true)
      }
    }

  }
}