package com.zohan.rsbot.scripts.fletcher.actions;

import com.zohan.rsbot.scripts.fletcher.context.FletchContext;
import com.zohan.rsbot.scripts.framework.actions.ActionPrioritySequence;
import com.zohan.rsbot.scripts.framework.actions.PriorityAction;
import org.powerbot.script.MessageListener;

/**
 * @Author: Zohan
 */
public abstract class FletchPrioritySequence extends ActionPrioritySequence<FletchContext, PriorityAction<FletchContext>> implements MessageListener {

    public FletchPrioritySequence(FletchContext arg0) {
        super(arg0);
    }

    public abstract boolean valid();

    public abstract String progress();

    public abstract String toString();
}
