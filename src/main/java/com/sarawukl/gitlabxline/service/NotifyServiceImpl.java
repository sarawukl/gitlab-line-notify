package com.sarawukl.gitlabxline.service;

import com.sarawukl.gitlabxline.model.IssueEvent;
import com.sarawukl.gitlabxline.model.MergeRequestEvent;
import com.sarawukl.gitlabxline.model.PushEvent;
import com.sarawukl.gitlabxline.model.PushTagEvent;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class NotifyServiceImpl implements NotifyService {

    private final URI lineUrl = URI.create("https://notify-api.line.me/api/notify");
    private final String contentType = "application/x-www-form-urlencoded";

    @Override
    public ResponseEntity<String> pushNotify(String lineToken, PushEvent pushEvent) {
        String data = String.format("message=%s", pushEvent);
        return this.httpPost(lineToken, data);
    }

    @Override
    public ResponseEntity<String> pushTagNotify(String lineToken, PushTagEvent pushTagEvent) {
        String data = String.format("message=%s", pushTagEvent);
        return this.httpPost(lineToken, data);
    }

    @Override
    public ResponseEntity<String> issueNotify(String lineToken, IssueEvent issueEvent) {
        String data = String.format("message=%s", issueEvent);
        return this.httpPost(lineToken, data);
    }

    @Override
    public ResponseEntity<String> mergeRequestNotify(String lineToken, MergeRequestEvent mergeRequestEvent) {
        String data = String.format("message=%s", mergeRequestEvent);
        return this.httpPost(lineToken, data);
    }

    public ResponseEntity<String> httpPost(String lineToken, String data) {
        String bearerAuth = "Bearer " + lineToken;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", contentType);
        headers.add("Content-Length", "" + data.getBytes().length);
        headers.add("Authorization", bearerAuth);
        RestTemplate template = new RestTemplate();
        RequestEntity request = new RequestEntity(
                data, headers, HttpMethod.POST, lineUrl);
        ResponseEntity responseEntity = template.exchange(request, String.class);
        return responseEntity;
    }

}
