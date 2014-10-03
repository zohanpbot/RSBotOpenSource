package com.zohan.rsbot.scripts.framework.actions;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;

/**
 * @Author: Zohan
 */
public abstract class PriorityAction<C extends ZohanContext> extends Action<C> implements Priortizable {

    public PriorityAction(C arg0) {
        super(arg0);
    }

    public int priority() {
        return 0;
    }
}
