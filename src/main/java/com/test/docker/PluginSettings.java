package com.test.docker;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.joda.time.Period;

import java.util.Collection;


public class PluginSettings {
    public static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    @Expose
    @SerializedName("server_url")
    private String serverUrl;

    @Expose
    @SerializedName("environment_variables")
    private String environmentVariables;

    @Expose
    @SerializedName("max_docker_containers")
    private String maxDockerContainers;

    @Expose
    @SerializedName("docker_uri")
    private String dockerURI;

    @Expose
    @SerializedName("auto_register_timeout")
    private String autoRegisterTimeout;

    @Expose
    @SerializedName("docker_ca_cert")
    private String dockerCACert;

    @Expose
    @SerializedName("docker_client_cert")
    private String dockerClientCert;

    @Expose
    @SerializedName("docker_client_key")
    private String dockerClientKey;

    @Expose
    @SerializedName("private_registry_server")
    private String privateRegistryServer;

    @Expose
    @SerializedName("private_registry_username")
    private String privateRegistryUsername;

    @Expose
    @SerializedName("private_registry_password")
    private String privateRegistryPassword;

    @Expose
    @SerializedName("enable_private_registry_authentication")
    private boolean useDockerAuthInfo;

    private Period autoRegisterPeriod;

    public static PluginSettings fromJSON(String json){
        return GSON.fromJson(json, PluginSettings.class);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        PluginSettings that = (PluginSettings) o;

        if(serverUrl != null ? !serverUrl.equals(that.serverUrl) : that.serverUrl != null)
            return false;

        if(environmentVariables != null ? !environmentVariables.equals(that.environmentVariables) : that.environmentVariables != null)
            return false;

        if(dockerURI != null ? !dockerURI.equals(that.dockerURI) : that.dockerURI != null)
            return false;

        if(autoRegisterTimeout != null ? autoRegisterTimeout.equals(that.autoRegisterTimeout) : that.autoRegisterTimeout != null)
            return false;

        if(dockerCACert != null ? !dockerCACert.equals(that.dockerCACert) : that.dockerCACert != null)
            return false;

        if(dockerClientCert != null ? !dockerClientCert.equals(that.dockerClientCert) : that.dockerClientCert != null)
            return false;

        if(dockerClientKey != null ? !dockerClientKey.equals(that.dockerClientKey) : that.dockerClientKey != null)
            return false;

        if(useDockerAuthInfo != that.useDockerAuthInfo) return false;

        if(privateRegistryServer != null ? !privateRegistryServer.equals(that.privateRegistryServer) : that.privateRegistryServer != null)
            return false;

        if(privateRegistryUsername != null ? !privateRegistryUsername.equals(that.privateRegistryUsername) : that.privateRegistryUsername != null)
            return false;

        if(privateRegistryPassword != null ? !privateRegistryPassword.equals(that.privateRegistryPassword) : that.privateRegistryPassword != null)
            return false;

        return autoRegisterPeriod != null ? autoRegisterPeriod.equals(that.autoRegisterPeriod) : that.autoRegisterPeriod == null;
    }

    @Override
    public int hashCode(){
        int result = serverUrl != null ? serverUrl.hashCode() : 0;
        result = 31 * result + (environmentVariables != null ? environmentVariables.hashCode() : 0);
        result = 31 * result + (dockerURI != null ? dockerURI.hashCode() : 0);
        result = 31 * result + (autoRegisterTimeout != null ? autoRegisterTimeout.hashCode() : 0);
        result = 31 * result + (dockerCACert != null ? dockerCACert.hashCode() : 0);
        result = 31 * result + (dockerClientCert != null ? dockerClientCert.hashCode() : 0);
        result = 31 * result + (dockerClientKey != null ? dockerClientKey.hashCode() : 0);
        result = 31 * result + (useDockerAuthInfo ? 1 : 0);
        result = 31 * result + (privateRegistryServer != null ? privateRegistryServer.hashCode() : 0);
        result = 31 * result + (privateRegistryUsername != null ? privateRegistryUsername.hashCode() : 0);
        result = 31 * result + (privateRegistryPassword != null ? privateRegistryPassword.hashCode() : 0);
        result = 31 * result + (autoRegisterPeriod != null ? autoRegisterPeriod.hashCode() : 0);

        return result;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public Collection<String> getEnvironmentVariables() {
        return Util.splitIntoLinesAndTrimSpaces(environmentVariables);
    }

    public void setEnvironmentVariables(String environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public Integer getMaxDockerContainers() {
        return Integer.valueOf(maxDockerContainers);
    }

    public void setMaxDockerContainers(Integer maxDockerContainers) {
        this.maxDockerContainers = String.valueOf(maxDockerContainers);
    }

    public String getDockerURI() {
        return dockerURI;
    }

    public void setDockerURI(String dockerURI) {
        this.dockerURI = dockerURI;
    }

    public String getAutoRegisterTimeout() {
        if(autoRegisterTimeout == null){
            autoRegisterTimeout = "10";
        }
        return autoRegisterTimeout;
    }

    public void setAutoRegisterTimeout(String autoRegisterTimeout) {
        this.autoRegisterTimeout = autoRegisterTimeout;
    }

    public String getDockerCACert() {
        return dockerCACert;
    }

    public void setDockerCACert(String dockerCACert) {
        this.dockerCACert = dockerCACert;
    }

    public String getDockerClientCert() {
        return dockerClientCert;
    }

    public void setDockerClientCert(String dockerClientCert) {
        this.dockerClientCert = dockerClientCert;
    }

    public String getDockerClientKey() {
        return dockerClientKey;
    }

    public void setDockerClientKey(String dockerClientKey) {
        this.dockerClientKey = dockerClientKey;
    }

    public String getPrivateRegistryServer() {
        return privateRegistryServer;
    }

    public void setPrivateRegistryServer(String privateRegistryServer) {
        this.privateRegistryServer = privateRegistryServer;
    }

    public String getPrivateRegistryUsername() {
        return privateRegistryUsername;
    }

    public void setPrivateRegistryUsername(String privateRegistryUsername) {
        this.privateRegistryUsername = privateRegistryUsername;
    }

    public String getPrivateRegistryPassword() {
        return privateRegistryPassword;
    }

    public void setPrivateRegistryPassword(String privateRegistryPassword) {
        this.privateRegistryPassword = privateRegistryPassword;
    }

    public Boolean useDockerAuthInfo() {
        return Boolean.valueOf(useDockerAuthInfo);
    }

    public void setUseDockerAuthInfo(boolean useDockerAuthInfo) {
        this.useDockerAuthInfo = useDockerAuthInfo;
    }

    public Period getAutoRegisterPeriod() {
        if (this.autoRegisterPeriod == null){
            this.autoRegisterPeriod = new Period().withMinutes(Integer.parseInt(getAutoRegisterTimeout()));
        }
        return this.autoRegisterPeriod;
    }

    public void setAutoRegisterPeriod(Period autoRegisterPeriod) {
        this.autoRegisterPeriod = autoRegisterPeriod;
    }
}
