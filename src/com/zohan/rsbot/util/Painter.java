package com.zohan.rsbot.util;

import com.zohan.rsbot.scripts.framework.context.ZohanContext;
import org.powerbot.script.ClientAccessor;
import org.powerbot.script.PaintListener;

import java.awt.*;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

/**
 * @author: Zohan
 */
public abstract class Painter<C extends ZohanContext> extends ClientAccessor<C> implements PaintListener {

    private static final Color BACKGROUND_COLOR = new Color(0, 0, 0, 175);
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Font LARGE_FONT = new Font("Calibri", Font.PLAIN, 20);
    private static final Font REGULAR_FONT = new Font("Calibri", Font.PLAIN, 14);

    private final String scriptName;
    private final double version;

    public Painter(C c, String scriptName, double version) {
        super(c);
        this.scriptName = scriptName;
        this.version = version;
    }

    @Override
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, 250, 90 + paintData().length * 15);
        g.setColor(TEXT_COLOR);
        g.setFont(LARGE_FONT);
        g.drawString(scriptName, 10, 34);
        g.setFont(REGULAR_FONT);
        g.drawString("Version: " + version, 25, 50);
        g.setColor(Color.GREEN);
        g.drawString("Status: " + ctx.status.get(), 25, 65);
        g.setColor(Color.YELLOW);
        g.drawString("Time Ran: " + formatTime(ctx.controller.script().getRuntime()), 25, 80);
        g.setColor(TEXT_COLOR);
        String[] arr = paintData();
        for (int i = 0; i < arr.length; i++) {
            g.drawString(arr[i], 25, 95 + i * 15);
        }
    }

    protected int pH(int val) {
        return (int) ((val) * 3600000D / ctx.controller.script().getRuntime());
    }

    protected String formatTime(long time) {
        String hms = String.format(
                "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(time),
                TimeUnit.MILLISECONDS.toMinutes(time)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                        .toHours(time)),
                TimeUnit.MILLISECONDS.toSeconds(time)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                        .toMinutes(time)));
        return hms;
    }

    protected String formatNumber(int i) {
        return NumberFormat.getIntegerInstance().format(i);
    }

    public abstract String[] paintData();

}
