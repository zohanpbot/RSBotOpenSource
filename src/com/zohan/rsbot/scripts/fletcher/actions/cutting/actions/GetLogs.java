package com.zohan.rsbot.scripts.fletcher.actions.cutting.actions;

import com.zohan.rsbot.scripts.framework.actions.PriorityAction;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;

/**
 * @author: Zohan
 */
public class GetLogs extends PriorityAction<ZohanContext> {

    private final int logsId;

    public GetLogs(ZohanContext arg0, final int logsId) {
        super(arg0);
        this.logsId = logsId;
    }

    @Override
    public void run() {
        if (ctx.bank.opened() && ctx.backpack.select().count() > ctx.backpack.select().id(logsId).count()) {
            ctx.status.set("Depositing items");
            ctx.bank.depositInventory();
        } else {
            ctx.status.set("Getting logs");
            ctx.banking.take(logsId, 0);
        }
    }

    @Override
    public boolean valid() {
        return ctx.backpack.select().id(logsId).isEmpty();
    }
}
