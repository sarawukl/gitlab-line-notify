package com.sarawukl.gitlabxline.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PushTagEvent extends GitLabPush {

    public String toString() {

        StringBuilder gitEvent = new StringBuilder();

        gitEvent.append(String.format("\n  Project: %s", this.getProject().getName()));
        gitEvent.append(String.format("\n  Event: %s", this.getObjectKind()));
        gitEvent.append(String.format("\n  User: %s", this.getUserName()));
        gitEvent.append(String.format("\n  Tag Reference: %s", this.getRef().replace("refs/tags/", "")));
        gitEvent.append(String.format("\n  URL: %s", this.getProject().getHomepage()));

        return gitEvent.toString();
    }
}