package com.zohan.rsbot.scripts.fletcher.actions;

import com.zohan.rsbot.scripts.framework.actions.ActionPrioritySequence;
import com.zohan.rsbot.scripts.framework.actions.PriorityAction;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.MessageListener;

/**
 * @Author: Zohan
 */
public abstract class FletchPrioritySequence extends ActionPrioritySequence<ZohanContext, PriorityAction<ZohanContext>> implements MessageListener {

    public FletchPrioritySequence(ZohanContext arg0) {
        super(arg0);
    }

    public abstract boolean valid();

    public abstract String progress();

    public abstract String toString();
}
