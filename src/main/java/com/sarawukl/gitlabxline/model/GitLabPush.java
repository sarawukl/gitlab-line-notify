package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class GitLabPush {

    @JsonProperty("object_kind")
    String objectKind;

    @JsonProperty("before")
    String before;

    @JsonProperty("after")
    String after;

    @JsonProperty("ref")
    String ref;

    @JsonProperty("checkout_sha")
    String checkoutSha;

    @JsonProperty("user_id")
    int userId;

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("user_username")
    String userUsername;

    @JsonProperty("user_email")
    String userEmail;

    @JsonProperty("user_avatar")
    String userAvatar;

    @JsonProperty("project_id")
    int projectId;

    @JsonProperty("project")
    Project project;

    @JsonProperty("repository")
    Repository repository;

    @JsonProperty("commits")
    List<Commit> commits;

    @JsonProperty("total_commits_count")
    int totalCommitsCount;
}
