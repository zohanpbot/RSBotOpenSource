package com.zohan.rsbot.scripts.framework.context.methods;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.ClientAccessor;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;

import java.util.concurrent.Callable;

/**
 * @author: Zohan
 */
public class Banking extends ClientAccessor<ZohanContext> {

    public Banking(ZohanContext arg0) {
        super(arg0);
    }

    public void take(final int id, final int amount) {
        Tile nearestBank = ctx.bank.nearest().tile();
        if (nearestBank.distanceTo(ctx.players.local().tile()) < 4) {
            if (ctx.bank.opened()) {
                final int count = ctx.backpack.select().id(id).count();
                ctx.bank.withdraw(id, amount);
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.backpack.select().id(id).count() > count;
                    }
                }, 200, 10);
            } else {
                ctx.bank.open();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.bank.opened();
                    }
                }, 200, 10);
            }
        } else if (!ctx.players.local().inMotion()) {
            ctx.movement.step(nearestBank);
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.players.local().inMotion();
                }
            }, 200, 10);
        }
    }
}
