package com.sarawukl.gitlabxline.controller;

import com.sarawukl.gitlabxline.handler.InvalidHeaderException;
import com.sarawukl.gitlabxline.model.IssueEvent;
import com.sarawukl.gitlabxline.model.MergeRequestEvent;
import com.sarawukl.gitlabxline.model.PushEvent;
import com.sarawukl.gitlabxline.model.PushTagEvent;
import com.sarawukl.gitlabxline.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Slf4j
@Controller
public class GitLabNotifyController {

    private final NotifyService notifyService;

    public GitLabNotifyController(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    @PostMapping("/push")
    public ResponseEntity pushNotify(@RequestHeader(value = "Line-Token") String lineToken, @RequestHeader(value = "X-Gitlab-Event") String gitLabEvent, @RequestBody PushEvent data) throws InvalidHeaderException {
        System.out.println(lineToken);
        if (!gitLabEvent.equals("Push Hook") || gitLabEvent.equals(null)) {
            throw new InvalidHeaderException(gitLabEvent);
        }
        return notifyService.pushNotify(lineToken, data);
    }

    @PostMapping("/tag")
    public ResponseEntity pushTagNotify(@RequestHeader(value = "Line-Token") String lineToken, @RequestHeader(value = "X-Gitlab-Event") String gitLabEvent, @RequestBody PushTagEvent data) throws InvalidHeaderException {
        if (!gitLabEvent.equals("Tag Push Hook") || gitLabEvent.equals(null)) {
            throw new InvalidHeaderException(gitLabEvent);
        }
        return notifyService.pushTagNotify(lineToken, data);
    }

    @PostMapping("/issue")
    public ResponseEntity issueNotify(@RequestHeader(value = "Line-Token") String lineToken, @RequestHeader(value = "X-Gitlab-Event") String gitLabEvent, @RequestBody IssueEvent data) throws InvalidHeaderException {
        if (!gitLabEvent.equals("Issue Hook") || gitLabEvent.equals(null)) {
            throw new InvalidHeaderException(gitLabEvent);
        }
        return notifyService.issueNotify(lineToken, data);
    }

    @PostMapping("/merge")
    public ResponseEntity mergeRequestNotify(@RequestHeader(value = "Line-Token") String lineToken, @RequestHeader(value = "X-Gitlab-Event") String gitLabEvent, @RequestBody MergeRequestEvent data) throws InvalidHeaderException {
        if (!gitLabEvent.equals("Merge Request Hook") || gitLabEvent.equals(null)) {
            throw new InvalidHeaderException(gitLabEvent);
        }
        return notifyService.mergeRequestNotify(lineToken, data);
    }
}
