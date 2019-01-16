package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class Project {

    @Nullable
    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("web_url")
    String webUrl;

    @JsonProperty("avatar_url")
    Object avatarUrl;

    @JsonProperty("git_ssh_url")
    String gitSshUrl;

    @JsonProperty("git_http_url")
    String gitHttpUrl;

    @JsonProperty("namespace")
    String namespace;

    @JsonProperty("visibility_level")
    int visibilityLevel;

    @JsonProperty("path_with_namespace")
    String pathWithNamespace;

    @JsonProperty("default_branch")
    String defaultBranch;

    @JsonProperty("homepage")
    String homepage;

    @JsonProperty("url")
    String url;

    @JsonProperty("ssh_url")
    String sshUrl;

    @JsonProperty("http_url")
    String httpUrl;

}