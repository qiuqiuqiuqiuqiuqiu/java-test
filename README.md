# java-test


### Docker & Jenkins
#### Create a busybox to store jenkins data
docker run -v /var/jenkins_home --name=frog-data busybox true
#### Run jenkins as a container
docker run \
  --rm \
  -u root \
  -p 8080:8080 \
  --volumes-from=frog-data \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v "$HOME":/home \
  jenkinsci/blueocean
