package com.zohan.rsbot.scripts.fletcher.actions.cutting;

import com.zohan.rsbot.scripts.fletcher.actions.FletchPrioritySequence;
import com.zohan.rsbot.scripts.fletcher.actions.WaitForFletching;
import com.zohan.rsbot.scripts.fletcher.actions.cutting.actions.ClickLogs;
import com.zohan.rsbot.scripts.fletcher.actions.cutting.actions.GetLogs;
import com.zohan.rsbot.scripts.fletcher.actions.cutting.actions.HandleLogInterface;
import com.zohan.rsbot.scripts.fletcher.actions.cutting.actions.HandleSkillingInterface;
import com.zohan.rsbot.scripts.fletcher.context.FletchContext;
import com.zohan.rsbot.scripts.fletcher.data.CutItem;
import org.powerbot.script.MessageEvent;

/**
 * @Author: Zohan
 */
public class Cutting extends FletchPrioritySequence {

    private final int amount;
    private final CutItem item;

    private int count = 0;

    public Cutting(FletchContext arg0, CutItem item, int amount) {
        super(arg0);
        this.item = item;
        this.amount = amount;
        add(new HandleLogInterface(ctx), new HandleSkillingInterface(ctx, item), new WaitForFletching(ctx), new ClickLogs(ctx, item.getLogId()), new GetLogs(ctx, item.getLogId()));
    }

    @Override
    public boolean valid() {
        return amount > count;
    }

    @Override
    public String progress() {
        return "Cutting - " + item.getName() + ": " + count + "/" + amount;
    }

    @Override
    public String toString() {
        return "Cutting => " + amount;
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        if (messageEvent.text().contains("You carefully cut the wood")) {
            count += 15;
        }
    }
}
