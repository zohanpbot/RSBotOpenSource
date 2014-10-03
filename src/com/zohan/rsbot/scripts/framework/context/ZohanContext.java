package com.zohan.rsbot.scripts.framework.context;

import com.zohan.rsbot.scripts.framework.context.methods.Banking;
import com.zohan.rsbot.scripts.framework.context.methods.SkillingInterface;
import com.zohan.rsbot.scripts.framework.context.methods.Using;
import com.zohan.rsbot.scripts.framework.context.util.Status;
import org.powerbot.script.rt6.ClientContext;

/**
 * @Author: Zohan
 */
public class ZohanContext extends ClientContext {

    public final SkillingInterface skillint;
    public final Banking banking;
    public final Using using;
    public final Status status;

    public ZohanContext(ClientContext arg0) {
        super(arg0);
        skillint = new SkillingInterface(this);
        banking = new Banking(this);
        using = new Using(this);
        status = new Status();
    }

}
