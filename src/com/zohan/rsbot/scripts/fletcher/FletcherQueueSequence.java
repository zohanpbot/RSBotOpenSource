package com.zohan.rsbot.scripts.fletcher;

import com.zohan.rsbot.scripts.fletcher.actions.FletchPrioritySequence;
import com.zohan.rsbot.scripts.framework.actions.ActionQueueSequence;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.MessageListener;

import java.util.Queue;

/**
 * @author: Zohan
 */
public class FletcherQueueSequence extends ActionQueueSequence<ZohanContext, FletchPrioritySequence> implements MessageListener {

    public FletcherQueueSequence(ZohanContext arg0) {
        super(arg0);
    }

    public String progress() {
        FletchPrioritySequence fps = queue.peek();
        return fps != null ? fps.progress() : "No Tasks Assigned";
    }

    public FletchPrioritySequence get() {
        return queue.peek();
    }

    public Queue<FletchPrioritySequence> queue() {
        return queue;
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        if (get() != null) {
            get().messaged(messageEvent);
        }
    }
}
