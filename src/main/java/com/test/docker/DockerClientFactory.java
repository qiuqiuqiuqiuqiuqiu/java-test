package com.test.docker;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificates;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.messages.RegistryAuth;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import static com.test.docker.DockerPlugin.LOG;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class DockerClientFactory {

    private static DefaultDockerClient client;
    private static PluginSettings pluginSettings;

    public static synchronized DockerClient docker(PluginSettings pluginSettings) throws Exception{
        if(pluginSettings.equals(DockerClientFactory.pluginSettings) && DockerClientFactory.client != null){
            return DockerClientFactory.client;
        }
        DockerClientFactory.pluginSettings = pluginSettings;
        DockerClientFactory.client = createClient(pluginSettings);
        return DockerClientFactory.client;
    }

    private static DefaultDockerClient createClient(PluginSettings pluginSettings) throws Exception{
        DefaultDockerClient.Builder builder = DefaultDockerClient.builder();
        builder.uri(pluginSettings.getDockerURI());
        if(pluginSettings.getDockerURI().startsWith("https://")){
            setupCerts(pluginSettings, builder);
        }
        if(pluginSettings.useDockerAuthInfo()){
            RegistryAuth auth = RegistryAuth.builder()
                    .serverAddress(pluginSettings.getPrivateRegistryServer())
                    .username(pluginSettings.getPrivateRegistryUsername())
                    .password(pluginSettings.getPrivateRegistryPassword())
                    .build();
            builder.registryAuth(auth);
        }

        DefaultDockerClient docker = builder.build();
        String ping = docker.ping();
        if(!"OK".equals(ping)){
            throw new RuntimeException("Could not ping the docker server, the server said '" + ping + "' instead of 'OK'.");
        }
        return docker;
    }

    private static void setupCerts(PluginSettings pluginSettings, DefaultDockerClient.Builder builder) throws IOException, DockerCertificateException {
        if(isBlank(pluginSettings.getDockerCACert())
                || isBlank(pluginSettings.getDockerClientCert())
                || isBlank(pluginSettings.getDockerClientKey())){
            LOG.warn("Missing docker certificates, will attempt to connect without certificates.");
            return;
        }
        Path certificateDir = Files.createTempDirectory(UUID.randomUUID().toString());
        File tempDirectory = certificateDir.toFile();

        try {
            FileUtils.writeStringToFile(new File(tempDirectory, DockerCertificates.DEFAULT_CA_CERT_NAME),
                    pluginSettings.getDockerCACert(),
                    StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File(tempDirectory, DockerCertificates.DEFAULT_CLIENT_CERT_NAME),
                    pluginSettings.getDockerClientCert(),
                    StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File(tempDirectory, DockerCertificates.DEFAULT_CLIENT_KEY_NAME),
                    pluginSettings.getDockerClientKey(),
                    StandardCharsets.UTF_8);
            builder.dockerCertificates(new DockerCertificates(certificateDir));
        } finally {
            FileUtils.deleteDirectory(tempDirectory);
        }
    }
}
