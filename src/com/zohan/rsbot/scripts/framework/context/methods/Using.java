package com.zohan.rsbot.scripts.framework.context.methods;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.ClientAccessor;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.Item;

/**
 * @author: Zohan
 */
public class Using extends ClientAccessor<ZohanContext> {

    public Using(ZohanContext arg0) {
        super(arg0);
    }

    public void use(Item item1, Item item2) {
        if (item1.interact("Use")) {
            item2.click();
            Condition.sleep(Random.nextInt(500, 800));
        }
    }
}
