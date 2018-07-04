package com.gitee.jenkins.webhook.build;

import com.gitee.jenkins.trigger.GiteePushTrigger;
import com.gitee.jenkins.gitee.hook.model.PushHook;
import hudson.model.FreeStyleProject;
import org.apache.commons.io.IOUtils;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.jvnet.hudson.test.JenkinsRule;
import org.kohsuke.stapler.HttpResponses;
import org.kohsuke.stapler.StaplerResponse;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Robin Müller
 */
@RunWith(MockitoJUnitRunner.class)
public class PushBuildActionTest {

    @ClassRule
    public static JenkinsRule jenkins = new JenkinsRule();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private StaplerResponse response;

    @Mock
    private GiteePushTrigger trigger;

    @Test
    public void skip_missingRepositoryUrl() throws IOException {
        FreeStyleProject testProject = jenkins.createFreeStyleProject();
        testProject.addTrigger(trigger);

        new PushBuildAction(testProject, getJson("PushEvent_missingRepositoryUrl.json"), null).execute(response);

        verify(trigger, never()).onPost(any(PushHook.class));
    }

    @Test
    public void build() throws IOException {
        try {
            FreeStyleProject testProject = jenkins.createFreeStyleProject();
            testProject.addTrigger(trigger);

            exception.expect(HttpResponses.HttpResponseException.class);
            new PushBuildAction(testProject, getJson("PushEvent.json"), null).execute(response);
        } finally {
            ArgumentCaptor<PushHook> pushHookArgumentCaptor = ArgumentCaptor.forClass(PushHook.class);
            verify(trigger).onPost(pushHookArgumentCaptor.capture());
            assertThat(pushHookArgumentCaptor.getValue().getProject(), is(notNullValue()));
            assertThat(pushHookArgumentCaptor.getValue().getProject().getWebUrl(), is(notNullValue()));
        }
    }

    @Test
    public void invalidToken() throws IOException {
        FreeStyleProject testProject = jenkins.createFreeStyleProject();
        when(trigger.getSecretToken()).thenReturn("secret");
        testProject.addTrigger(trigger);

        exception.expect(HttpResponses.HttpResponseException.class);
        new PushBuildAction(testProject, getJson("PushEvent.json"), "wrong-secret").execute(response);

        verify(trigger, never()).onPost(any(PushHook.class));
    }

    private String getJson(String name) throws IOException {
        return IOUtils.toString(getClass().getResourceAsStream(name));
    }
}
