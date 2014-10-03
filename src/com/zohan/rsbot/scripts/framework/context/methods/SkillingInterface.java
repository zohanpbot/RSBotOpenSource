package com.zohan.rsbot.scripts.framework.context.methods;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.ClientAccessor;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.Component;

import java.util.concurrent.Callable;

/**
 * @Author: Zohan
 */
public class SkillingInterface extends ClientAccessor<ZohanContext> {

    private static final int MAIN_WIDGET_ID = 1371;
    private static final int DROP_MENU_CLOSED = 62;
    private static final int DROP_MENU_OPEN = 51;
    private static final int ITEM_GRID = 44;

    private static final int MAIN_WIDGET = 1370;
    private static final int CRAFT_BUTTON = 40;
    private static final int CLOSE_BUTTON = 30;


    public SkillingInterface(ZohanContext arg0) {
        super(arg0);
    }

    public boolean opened() {
        return ctx.widgets.component(MAIN_WIDGET, CLOSE_BUTTON).valid();
    }

    public void close() {
        if (opened()) {
            ctx.widgets.component(MAIN_WIDGET, CLOSE_BUTTON).click();
        }
    }

    public String getCategory() {
        return ctx.widgets.component(MAIN_WIDGET_ID, DROP_MENU_OPEN).component(0).text();
    }

    public void setCategory(int index) {
        final Component category = ctx.widgets.component(MAIN_WIDGET_ID, DROP_MENU_CLOSED).component(index);
        if (category.valid()) {
            category.click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return !category.valid();
                }
            });
        } else {
            ctx.widgets.component(MAIN_WIDGET_ID, DROP_MENU_OPEN).click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return category.valid();
                }
            }, 200, 10);
        }
    }

    public int getItemIndex() {
        Component[] widgets = ctx.widgets.component(MAIN_WIDGET_ID, ITEM_GRID).components();
        int index = -1;
        for (int i = 1; i < widgets.length; i += 4) {
            index++;
            if (ctx.widgets.component(MAIN_WIDGET_ID, ITEM_GRID).component(i).textureId() == 15201) {
                break;
            }
        }
        return index;
    }

    public void setItem(int index) {
        final Component item = ctx.widgets.component(MAIN_WIDGET_ID, ITEM_GRID).component(1 + index * 4);
        item.click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return item.textureId() == 15201;
            }
        });
    }

    public void clickAction() {
        final Component actionButton = ctx.widgets.component(MAIN_WIDGET, CRAFT_BUTTON);
        actionButton.click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !ctx.widgets.component(MAIN_WIDGET_ID, 0).valid();
            }
        }, 200, 20);
    }

}
