package com.zohan.rsbot.scripts.fletcher.actions.cutting.actions;

import com.zohan.rsbot.scripts.framework.actions.PriorityAction;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

import java.util.concurrent.Callable;

/**
 * @author: Zohan
 */
public class ClickLogs extends PriorityAction<ZohanContext> {

    private final Component clickKnife;
    private final int logsId;
    private Item logs;

    public ClickLogs(ZohanContext arg0, final int logsId) {
        super(arg0);
        this.logsId = logsId;
        clickKnife = ctx.widgets.component(1179, 33).component(1);
    }

    @Override
    public void run() {
        if (ctx.bank.opened()) {
            ctx.status.set("Closing bank");
            if (ctx.bank.close()) {
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return !ctx.bank.opened();
                    }
                });
            }
        } else {
            ctx.status.set("Clicking logs");
            if (logs.click()) {
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.skillint.opened() || clickKnife.valid();
                    }
                });
            }
        }
    }

    @Override
    public boolean valid() {
        return (logs = ctx.backpack.select().id(logsId).shuffle().poll()).valid();
    }

    public int priority() {
        return 25;
    }
}
