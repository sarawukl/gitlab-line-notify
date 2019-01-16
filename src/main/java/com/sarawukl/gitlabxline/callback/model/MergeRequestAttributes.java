package com.sarawukl.gitlabxline.callback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MergeRequestAttributes extends ObjectAttributes {

    @JsonProperty("target_branch")
    String targetBranch;

    @JsonProperty("target_project_id")
    int targetProjectId;

    @JsonProperty("source_branch")
    String sourceBranch;

    @JsonProperty("source_project_id")
    int sourceProjectId;

    @JsonProperty("merge_status")
    String mergeStatus;

    @JsonProperty("source")
    Project source;

    @JsonProperty("target")
    Project target;

    @JsonProperty("last_commit")
    LastCommit lastCommit;

    @JsonProperty("work_in_progress")
    boolean workInProgress;

    @JsonProperty("assignee")
    GitLabUser assignee;

    @Data
    public static class LastCommit {

        @JsonProperty("id")
        String id;

        @JsonProperty("message")
        String message;

        @JsonProperty("timeStamp")
        String timestamp;

        @JsonProperty("url")
        String url;

        @JsonProperty("author")
        Author author;
    }
}
