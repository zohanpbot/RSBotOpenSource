package com.zohan.rsbot.scripts.fletcher;

import com.zohan.rsbot.scripts.fletcher.actions.FletchPrioritySequence;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import com.zohan.rsbot.util.Painter;

/**
 * @author: Zohan
 */
public class FletcherPaint extends Painter<ZohanContext> {

    private String[] paintData;
    private final FletcherQueueSequence queue;

    public FletcherPaint(ZohanContext fletchContext, FletcherQueueSequence queue) {
        super(fletchContext, "ZohanFletcher", 0.2);
        paintData = new String[2];
        this.queue = queue;
    }

    @Override
    public String[] paintData() {
        paintData[0] = "Current Task";
        FletchPrioritySequence fps = queue.get();
        paintData[1] = queue.progress();
        return paintData;
    }
}
