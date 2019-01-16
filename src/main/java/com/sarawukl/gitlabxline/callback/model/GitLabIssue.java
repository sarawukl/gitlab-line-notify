package com.sarawukl.gitlabxline.callback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GitLabIssue {

    @JsonProperty("project")
    Project project;

    @JsonProperty("repository")
    Repository repository;

    @JsonProperty("user")
    GitLabUser user;

    @JsonProperty("object_kind")
    String objectKind;

    @JsonProperty("assignee")
    GitLabUser assignee;

    @JsonProperty("labels")
    List<Label> labels;

    @JsonProperty("changes")
    Changes changes;

    @Data
    public static class Label {

        @JsonProperty("id")
        int id;

        @JsonProperty("title")
        String title;

        @JsonProperty("color")
        String color;

        @JsonProperty("project_id")
        int projectId;

        @JsonProperty("created_at")
        String createdAt;

        @JsonProperty("updated_at")
        String updatedAt;

        @JsonProperty("template")
        boolean template;

        @JsonProperty("description")
        String description;

        @JsonProperty("type")
        String type;

        @JsonProperty("group_id")
        int groupId;
    }

    @Data
    public static class Changes {

        @JsonProperty("labels")
        Labels labels;
    }

    @Data
    public static class Labels {

        @JsonProperty("previous")
        List<Label> previous;

        @JsonProperty("current")
        List<Label> current;
    }

}
