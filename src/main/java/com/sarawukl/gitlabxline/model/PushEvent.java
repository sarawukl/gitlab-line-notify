package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PushEvent extends GitLabPush {

    @JsonProperty("user_username")
    String userUsername;

    @JsonProperty("user_email")
    String userEmail;

    public String toString() {

        StringBuilder gitEvent = new StringBuilder();
        String author = this.getCommits().stream().findFirst().orElse(null).getAuthor().toString();

        gitEvent.append(String.format("\n  Project: %s", this.getProject().getName()));
        gitEvent.append(String.format("\n  Event: %s", this.getObjectKind()));
        gitEvent.append(String.format("\n  User: %s", author));
        gitEvent.append(String.format("\n  Commit: %s", this.getCommits()));
        gitEvent.append(String.format("\n  URL: %s", this.getProject().getHomepage()));

        return gitEvent.toString();
    }
}