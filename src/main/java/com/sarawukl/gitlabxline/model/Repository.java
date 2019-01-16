package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Repository {

    @JsonProperty("name")
    String name;

    @JsonProperty("url")
    String url;

    @JsonProperty("description")
    String description;

    @JsonProperty("homepage")
    String homepage;

    @JsonProperty("git_http_url")
    String gitHttpUrl;

    @JsonProperty("git_ssh_url")
    String gitSshUrl;

    @JsonProperty("visibility_level")
    int visibilityLevel;

}
