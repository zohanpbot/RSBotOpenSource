package com.zohan.rsbot.scripts.fletcher.context;

import com.zohan.rsbot.scripts.fletcher.FletcherQueueSequence;
import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.rt6.ClientContext;

/**
 * @Author: Zohan
 */
public class FletchContext extends ZohanContext {

    public final FletcherQueueSequence queue;

    public FletchContext(ClientContext arg0) {
        super(arg0);
        queue = new FletcherQueueSequence(this);
    }

}
