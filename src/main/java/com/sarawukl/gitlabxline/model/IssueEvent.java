package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class IssueEvent extends GitLabIssue {

    @JsonProperty("object_attributes")
    IssueAttributes objectAttributes;

    @JsonProperty("assignees")
    List<GitLabUser> assignees;

    public String toString() {

        StringBuilder issue = new StringBuilder();
        issue.append(String.format("\n  Project: %s", this.getProject().getName()));
        issue.append("\n  Event: Issue ");
        issue.append(String.format("\n    ID: %s", this.getObjectAttributes().getIId()));
        issue.append(String.format("\n    State: %s", this.getObjectAttributes().getState()));
        issue.append(String.format("\n    Title: %s", this.getObjectAttributes().getTitle()));
        if (!this.getAssignees().isEmpty()) {
            issue.append("\n    Assignees:");
            issue.append("\n         - ");
            String assignees = assignListToString(this.getAssignees());
            issue.append(assignees);
        }
        issue.append(String.format("\n    URL: %s", this.getObjectAttributes().getUrl()));

        return issue.toString();
    }

    public String assignListToString(List<GitLabUser> assignees) {
        List<String> list = assignees.stream()
                .map(GitLabUser::getName)
                .collect(Collectors.toList());
        String joiner = "\n         - ";
        return list.stream().
                map(Object::toString).
                collect(Collectors.joining(joiner));
    }
}
