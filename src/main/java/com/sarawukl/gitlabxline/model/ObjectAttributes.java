package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ObjectAttributes {

    @JsonProperty("id")
    int id;

    @JsonProperty("title")
    String title;

    @JsonProperty("author_id")
    int authorId;

    @JsonProperty("assignee_id")
    int assigneeId;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("updated_at")
    String updatedAt;

    @JsonProperty("description")
    String description;

    @JsonProperty("milestone_id")
    int milestoneId;

    @JsonProperty("state")
    String state;

    @JsonProperty("iid")
    int iId;

    @JsonProperty("url")
    String url;

    @JsonProperty("action")
    String action;

}