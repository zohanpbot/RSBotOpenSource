package com.zohan.rsbot.scripts.fletcher.actions;

import com.zohan.rsbot.scripts.framework.actions.PriorityAction;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.Condition;

/**
 * @author: Zohan
 */
public class WaitForFletching extends PriorityAction<ZohanContext> {

    public WaitForFletching(ZohanContext arg0) {
        super(arg0);
    }

    @Override
    public void run() {
        ctx.status.set("Waiting for Fletching");
        Condition.sleep(1500);
    }

    @Override
    public boolean valid() {
        return ctx.varpbits.varpbit(1175) != -1;
    }

    public int priority() {
        return 500;
    }
}
