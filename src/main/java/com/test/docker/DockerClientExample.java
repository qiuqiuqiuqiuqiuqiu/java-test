package com.test.docker;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.*;

import java.util.*;

public class DockerClientExample {

    // uri: http://localhost:2375
    // host: localhost
    public static void main(String[] args) throws Exception {

        /**
         * docker http failed may caused by corporate firewall, workarounds:
         * 1. connect to mobile phone Hotspot;
         * 2. connect to clear-guest wifi;
          */

        // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
        final DockerClient docker = DefaultDockerClient.fromEnv().build();

        // use the builder to create a client
        // DefaultDockerClient.Builder builder = DefaultDockerClient.builder();
        // RegistryAuth auth = RegistryAuth.builder()
        //         .serverAddress("localhost")
        //         .username("")
        //         .password("")
        //         .build();
        // DefaultDockerClient docker = builder
        //         .uri("unix:///var/run/docker.sock")
        //         .registryAuth(auth)
        //         .build();

        // final DockerClient docker = DefaultDockerClient.builder()
        //         .uri(URI.create("https://localhost:2375"))
        //         .dockerCertificates(new DockerCertificates(Paths.get("/Users/ethan/.docker/key/")))
        //         .build();

        System.out.println("ping: " + docker.ping());
        System.out.println("cert: " + DefaultDockerClient.fromEnv().dockerCertificates());
        DefaultDockerClient.fromEnv().dockerCertificates();
        System.out.println("host: " + docker.getHost());
        System.out.println("uri: " + DefaultDockerClient.fromEnv().uri().toString());
        System.out.println(docker.info().toString());
        // docker.pull("busybox:latest");

        // Bind container ports to host ports
        final String[] ports = {"80", "22", "443"};
        final Map<String, List<PortBinding>> portBindings = new HashMap<String, List<PortBinding>>();
        for (String port:ports) {
            List<PortBinding> randomPort = new ArrayList<PortBinding>();
            randomPort.add(PortBinding.randomPort("0.0.0.0"));
            portBindings.put(port, randomPort);
        }
        final HostConfig hostConfig = HostConfig.builder()
                .portBindings(portBindings)
                .build();

        // Create container with exposed ports
        final ContainerConfig containerConfig = ContainerConfig.builder()
                .hostConfig(hostConfig)
                .image("busybox:latest")
                .exposedPorts(ports)
                .cmd("sh", "-c", "while :; do sleep 1; done")
                .build();
        final ContainerCreation creation = docker.createContainer(containerConfig);
        final String id = creation.id();
        final ContainerInfo info = docker.inspectContainer(id);
        System.out.println(info);

        // Start container
        docker.startContainer(id);

         // Exec command inside running container with attached STDOUT and STDERR
         String[] command1 = {"sh", "-c", "ls -l"};
         executeCommand(docker, id, command1);
         String[] command2 = {"sh", "-c", "df -h"};
         executeCommand(docker, id, command2);
         final List<Container> containers = docker.listContainers();
         System.out.println(containers.toArray().toString());
         // Kill container
         docker.killContainer(id);
         // Remove container
         docker.removeContainer(id);
         // Close the docker client
         docker.close();
    }

    private static void executeCommand(DockerClient docker, String id, String[] command){
        try {
            final ExecCreation execCreation = docker.execCreate(
                    id, command, DockerClient.ExecCreateParam.attachStdout(),
                    DockerClient.ExecCreateParam.attachStderr());

            final LogStream output = docker.execStart(execCreation.id());
            final String execOutput = output.readFully();
            System.out.println(execOutput);
        } catch (DockerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
