package com.zohan.rsbot.scripts.framework.actions;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;

/**
 * @Author: Zohan
 */
public abstract class Sequence<C extends ZohanContext, A extends Action> extends Action<C> {

    public Sequence(C arg0) {
        super(arg0);
    }

    public abstract void add(A... actions);

    public abstract void remove(A... actions);
}
