package com.sarawukl.gitlabxline.callback.service;

import com.sarawukl.gitlabxline.callback.model.IssueEvent;
import com.sarawukl.gitlabxline.callback.model.MergeRequestEvent;
import com.sarawukl.gitlabxline.callback.model.PushEvent;
import com.sarawukl.gitlabxline.callback.model.PushTagEvent;
import org.springframework.http.ResponseEntity;

public interface NotifyService {

    ResponseEntity<String> pushNotify(String lineToken, PushEvent pushEvent);

    ResponseEntity<String> pushTagNotify(String lineToken, PushTagEvent pushTagEvent);

    ResponseEntity<String> issueNotify(String lineToken, IssueEvent issueEvent);

    ResponseEntity<String> mergeRequestNotify(String lineToken, MergeRequestEvent mergeRequestEvent);

}
