package com.zohan.rsbot.scripts.fletcher;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import com.zohan.rsbot.util.Painter;
import org.powerbot.script.*;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Zohan
 */

@Script.Manifest(name = "ZohanFletcher", description = "Currently supports cutting, features added upon request", properties = "topic=1177639; hidden=false; client=6")
public class ZohanFletcher extends PollingScript<ZohanContext> implements PaintListener, MessageListener {

    private Painter painter;
    private FletcherGui gui;
    private FletcherQueueSequence queue;


    public void start() {
        queue = new FletcherQueueSequence(ctx);
        painter = new FletcherPaint(ctx, queue);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new FletcherGui(ctx, queue);
            }
        });
    }

    @Override
    public void poll() {
        if (gui != null && !gui.isVisible()) {
            queue.run();
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
        queue.messaged(messageEvent);
    }
}
