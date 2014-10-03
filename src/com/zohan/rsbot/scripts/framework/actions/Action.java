package com.zohan.rsbot.scripts.framework.actions;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.ClientAccessor;
import org.powerbot.script.Validatable;

/**
 * @Author: Zohan
 */
public abstract class Action<C extends ZohanContext> extends ClientAccessor<C> implements Runnable, Validatable {

    public Action(C arg0) {
        super(arg0);
    }

}
