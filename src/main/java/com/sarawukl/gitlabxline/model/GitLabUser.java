package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitLabUser {

    @JsonProperty("name")
    String name;

    @JsonProperty("username")
    String userName;

    @JsonProperty("avatar_url")
    String avatarUrl;
}
