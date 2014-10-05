package com.zohan.rsbot.scripts.fletcher.actions.cutting.actions;

import com.zohan.rsbot.scripts.fletcher.data.CutItem;
import com.zohan.rsbot.scripts.framework.actions.PriorityAction;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;

/**
 * @author: Zohan
 */
public class HandleSkillingInterface extends PriorityAction<ZohanContext> {

    private final CutItem item;

    public HandleSkillingInterface(ZohanContext arg0, CutItem cutItem) {
        super(arg0);
        item = cutItem;
    }

    @Override
    public void run() {
        if (ctx.skillint.getCategory().equals(item.getCategory())) {
            if (ctx.skillint.getItemIndex() == item.getGridIndex()) {
                ctx.status.set("Clicking button");
                ctx.skillint.clickAction();
            } else {
                ctx.status.set("Setting item");
                ctx.skillint.setItem(item.getGridIndex());
            }
        } else {
            ctx.status.set("Setting category");
            ctx.skillint.setCategory(item.getMenuIndex());
        }
    }

    @Override
    public boolean valid() {
        return ctx.skillint.opened();
    }

    public int priority() {
        return 50;
    }
}
