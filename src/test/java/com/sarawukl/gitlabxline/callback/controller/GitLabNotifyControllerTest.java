package com.sarawukl.gitlabxline.callback.controller;

import com.sarawukl.gitlabxline.callback.service.NotifyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class GitLabNotifyControllerTest {

    GitLabNotifyController controller;

    @Mock
    NotifyService service;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        controller = new GitLabNotifyController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void pushNotify() throws Exception {

        when(service.pushNotify(any(), any())).thenReturn(new ResponseEntity<String>("", HttpStatus.OK));

        mockMvc.perform(post("/push").contentType(MediaType.APPLICATION_JSON).content("{}").header("X-Gitlab-Event", "Push Hook").header("Line-Token", "qwerty")).andExpect(status().isOk());

        verify(service, times(1)).pushNotify(any(), any());
    }

    @Test
    public void pushTagNotify() throws Exception {

        when(service.pushTagNotify(any(), any())).thenReturn(new ResponseEntity<String>("", HttpStatus.OK));

        mockMvc.perform(post("/tag").contentType(MediaType.APPLICATION_JSON).content("{}").header("X-Gitlab-Event", "Tag Push Hook").header("Line-Token", "qwerty")).andExpect(status().isOk());

        verify(service, times(1)).pushTagNotify(any(), any());
    }

    @Test
    public void issueNotify() throws Exception {

        when(service.issueNotify(any(), any())).thenReturn(new ResponseEntity<String>("", HttpStatus.OK));

        mockMvc.perform(post("/issue").contentType(MediaType.APPLICATION_JSON).content("{}").header("X-Gitlab-Event", "Issue Hook").header("Line-Token", "qwerty")).andExpect(status().isOk());

        verify(service, times(1)).issueNotify(any(), any());
    }

    @Test
    public void mergeRequestNotify() throws Exception {

        when(service.mergeRequestNotify(any(), any())).thenReturn(new ResponseEntity<String>("", HttpStatus.OK));

        mockMvc.perform(post("/merge").contentType(MediaType.APPLICATION_JSON).content("{}").header("X-Gitlab-Event", "Merge Request Hook").header("Line-Token", "qwerty")).andExpect(status().isOk());

        verify(service, times(1)).mergeRequestNotify(any(), any());
    }
}