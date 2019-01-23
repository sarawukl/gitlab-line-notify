package com.sarawukl.gitlabxline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {

    @JsonProperty("name")
    public String name;

    @JsonProperty("email")
    public String email;

    public String toString() {
        return String.format("%s (%s)", this.getName(), this.getEmail());
    }
}
