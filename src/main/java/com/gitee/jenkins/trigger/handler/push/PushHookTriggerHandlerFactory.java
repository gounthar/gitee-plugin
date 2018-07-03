package com.gitee.jenkins.trigger.handler.push;

import com.gitee.jenkins.trigger.TriggerOpenMergeRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robin Müller
 */
public final class PushHookTriggerHandlerFactory {

    private PushHookTriggerHandlerFactory() {}

    public static PushHookTriggerHandler newPushHookTriggerHandler(boolean triggerOnPush,
                                                                   TriggerOpenMergeRequest triggerOpenMergeRequestOnPush,
                                                                   boolean skipWorkInProgressMergeRequest) {
        if (triggerOnPush || triggerOpenMergeRequestOnPush == TriggerOpenMergeRequest.both) {
            return new PushHookTriggerHandlerList(retrieveHandlers(triggerOnPush, triggerOpenMergeRequestOnPush, skipWorkInProgressMergeRequest));
        } else {
            return new NopPushHookTriggerHandler();
        }
    }

    private static List<PushHookTriggerHandler> retrieveHandlers(boolean triggerOnPush,
                                                                 TriggerOpenMergeRequest triggerOpenMergeRequestOnPush,
                                                                 boolean skipWorkInProgressMergeRequest) {
        List<PushHookTriggerHandler> result = new ArrayList<>();
        if (triggerOnPush) {
            result.add(new PushHookTriggerHandlerImpl());
        }

        return result;
    }
}