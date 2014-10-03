package com.zohan.rsbot.scripts.framework.actions;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: Zohan
 */
public class ActionPrioritySequence<C extends ZohanContext, A extends Action<C> & Priortizable> extends Sequence<C, A> implements Comparator<A> {

    protected final ArrayList<A> actionList;

    public ActionPrioritySequence(C arg0) {
        super(arg0);
        actionList = new ArrayList<A>();
    }

    @Override
    public void add(A... actions) {
        for (A action : actions) {
            if (!actionList.contains(action)) {
                actionList.add(action);
            }
        }
        Collections.sort(actionList, this);
    }

    @Override
    public void remove(A... actions) {
        for (A action : actions) {
            if (actionList.contains(action)) {
                actionList.remove(action);
            }
        }
    }

    @Override
    public void run() {
        for (A action : actionList) {
            if (action.valid()) {
                action.run();
                return;
            }
        }
    }

    @Override
    public boolean valid() {
        return true;
    }

    @Override
    public int compare(A o1, A o2) {
        return o2.priority() - o1.priority();
    }
}
