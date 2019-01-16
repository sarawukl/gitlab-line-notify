package com.sarawukl.gitlabxline.callback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class IssueAttributes extends ObjectAttributes {

    @JsonProperty("assignee_ids")
    List<Integer> assigneeIds;

    @JsonProperty("project_id")
    int projectId;

    @JsonProperty("position")
    int position;

    @JsonProperty("branch_name")
    String branchName;

}
