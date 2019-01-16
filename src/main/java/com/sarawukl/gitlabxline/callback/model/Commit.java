package com.sarawukl.gitlabxline.callback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Commit {

    @JsonProperty("id")
    String id;

    @JsonProperty("message")
    String message;

    @JsonProperty("timestamp")
    String timestamp;

    @JsonProperty("url")
    String url;

    @JsonProperty("author")
    Author author;

    @JsonProperty("added")
    List<String> added;

    @JsonProperty("modified")
    List<String> modified;

    @JsonProperty("removed")
    List<String> removed;

    public String toString() {

        StringBuilder commits = new StringBuilder();
        commits.append(String.format("\n    ID: %s", this.getId().substring(0, 7)));
        commits.append(String.format("\n    Message: %s", this.getMessage()));

        if (!added.isEmpty()) {
            commits.append("\n     - added: ");
            commits.append("\n        - ");
            commits.append(commitListToString(added));
        }
        if (!modified.isEmpty()) {
            commits.append("\n     - modified: ");
            commits.append("\n        - ");
            commits.append(commitListToString(modified));
        }
        if (!removed.isEmpty()) {
            commits.append("\n     - removed: ");
            commits.append("\n        - ");
            commits.append(commitListToString(removed));
        }

        return commits.toString();
    }

    public String commitListToString(List<String> list) {
        String joiner = "\n        - ";
        return list.stream().
                map(Object::toString).
                collect(Collectors.joining(joiner));
    }
}

