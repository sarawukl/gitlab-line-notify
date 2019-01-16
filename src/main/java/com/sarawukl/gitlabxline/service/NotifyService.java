package com.sarawukl.gitlabxline.service;

import com.sarawukl.gitlabxline.model.IssueEvent;
import com.sarawukl.gitlabxline.model.MergeRequestEvent;
import com.sarawukl.gitlabxline.model.PushEvent;
import com.sarawukl.gitlabxline.model.PushTagEvent;
import org.springframework.http.ResponseEntity;

public interface NotifyService {

    ResponseEntity<String> pushNotify(String lineToken, PushEvent pushEvent);

    ResponseEntity<String> pushTagNotify(String lineToken, PushTagEvent pushTagEvent);

    ResponseEntity<String> issueNotify(String lineToken, IssueEvent issueEvent);

    ResponseEntity<String> mergeRequestNotify(String lineToken, MergeRequestEvent mergeRequestEvent);

}
