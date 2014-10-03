package com.zohan.rsbot.scripts.fletcher.actions.cutting.actions;

import com.zohan.rsbot.scripts.fletcher.context.FletchContext;
import com.zohan.rsbot.scripts.framework.actions.PriorityAction;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.Component;

import java.util.concurrent.Callable;

/**
 * @Author: Zohan
 */
public class HandleLogInterface extends PriorityAction<FletchContext> {

    private final Component clickKnife;

    public HandleLogInterface(FletchContext arg0) {
        super(arg0);
        clickKnife = ctx.widgets.component(1179, 33).component(1);
    }

    @Override
    public void run() {
        ctx.status.set("Clicking knife");
        clickKnife.click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !clickKnife.valid();
            }
        }, 200, 10);
    }

    @Override
    public boolean valid() {
        return clickKnife.valid();
    }

    public int priority() {
        return 75;
    }
}
