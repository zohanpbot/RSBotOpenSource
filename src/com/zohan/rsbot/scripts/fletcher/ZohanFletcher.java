package com.zohan.rsbot.scripts.fletcher;

import com.zohan.rsbot.scripts.fletcher.actions.FletchPrioritySequence;
import com.zohan.rsbot.scripts.fletcher.context.FletchContext;
import com.zohan.rsbot.util.Painter;
import org.powerbot.script.*;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Zohan
 */

@Script.Manifest(name = "ZohanFletcher", description = "Fletches Stoof")
public class ZohanFletcher extends PollingScript<FletchContext> implements PaintListener, MessageListener {

    FletchPrioritySequence sequence;
    Painter painter;
    private FletcherGui gui;

    public void start() {
        painter = new FletcherPaint(ctx);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new FletcherGui(ctx);
            }
        });
    }

    @Override
    public void poll() {
        if (gui != null && !gui.isVisible()) {
            ctx.queue.run();
        }
    }


    @Override
    public void repaint(Graphics graphics) {
        if (painter != null) {
            painter.repaint(graphics);
        }
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        ctx.queue.messaged(messageEvent);
    }
}
