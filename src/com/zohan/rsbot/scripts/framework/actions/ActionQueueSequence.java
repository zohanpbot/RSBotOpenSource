package com.zohan.rsbot.scripts.framework.actions;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: Zohan
 */
public class ActionQueueSequence<C extends ZohanContext, A extends Action<C>> extends Sequence<C, A> {

    protected final ArrayBlockingQueue<A> queue;

    public ActionQueueSequence(C arg0) {
        super(arg0);
        queue = new ArrayBlockingQueue<A>(50);
    }

    @Override
    public void run() {
        A action = queue.peek();
        if (action != null) {
            if (action.valid()) {
                action.run();
            } else {
                queue.poll();
            }
        } else {
            queue.poll();
        }
    }

    @Override
    public boolean valid() {
        return !queue.isEmpty();
    }

    @Override
    public void add(A... actions) {
        for (A action : actions) {
            if (!queue.offer(action)) {
                return;
            }
        }
    }

    @Override
    public void remove(A... actions) {
        for (A action : actions) {
            if (queue.contains(action)) {
                queue.remove(action);
            }
        }
    }
}
