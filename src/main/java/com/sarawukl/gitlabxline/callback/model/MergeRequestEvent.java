package com.sarawukl.gitlabxline.callback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MergeRequestEvent extends GitLabIssue {

    @JsonProperty("object_attributes")
    MergeRequestAttributes objectAttributes;

    public String toString() {

        StringBuilder mergeRequest = new StringBuilder();
        mergeRequest.append(String.format("\n  Project: %s", getProject().getName()));
        mergeRequest.append("\n  Event: Merge Request ");
        mergeRequest.append(String.format("\n    ID: %s", this.getObjectAttributes().getIId()));
        mergeRequest.append(String.format("\n    State: %s", this.getObjectAttributes().getState()));
        mergeRequest.append(String.format("\n    Title: %s", this.getObjectAttributes().getTitle()));
        if (this.getObjectAttributes().getAssignee() != null) {
            mergeRequest.append(String.format("\n    Assignee: %s", this.getObjectAttributes().getAssignee().getName()));
        }
        mergeRequest.append(String.format("\n    URL: %s", this.getObjectAttributes().getUrl()));
        return mergeRequest.toString();
    }
}
