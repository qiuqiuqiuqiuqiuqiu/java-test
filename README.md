# java-test


# Docker & Jenkins
## Create a busybox to store jenkins data
docker run -v /var/jenkins_home --name=frog-data busybox true
## Run jenkins as a container
docker run -t -i -u root -p 8084:8080 -p 5004:5004 --volumes-from=frog-data --name=frog jenkins/jenkins:2.166