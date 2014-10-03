package com.zohan.rsbot.scripts.fletcher;

import com.zohan.rsbot.scripts.fletcher.actions.FletchPrioritySequence;
import com.zohan.rsbot.scripts.fletcher.context.FletchContext;
import com.zohan.rsbot.util.Painter;

/**
 * @author: Zohan
 */
public class FletcherPaint extends Painter<FletchContext> {

    private String[] paintData;

    public FletcherPaint(FletchContext fletchContext) {
        super(fletchContext, "ZohanFletcher", 0.2);
        paintData = new String[2];
    }

    @Override
    public String[] paintData() {
        paintData[0] = "Current Task";
        FletchPrioritySequence fps = ctx.queue.get();
        paintData[1] = ctx.queue.progress();
        return paintData;
    }
}
