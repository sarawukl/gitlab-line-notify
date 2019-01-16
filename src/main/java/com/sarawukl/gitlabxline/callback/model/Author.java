package com.sarawukl.gitlabxline.callback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Author {

    @JsonProperty("name")
    public String name;

    @JsonProperty("email")
    public String email;

    public String toString() {
        return String.format("%s (%s)", this.getName(), this.getEmail());
    }
}
