package com.zohan.rsbot.scripts.framework.context.util;

/**
 * @author: Zohan
 */
public class Status {

    private String status = "Loading...";

    public void set(String s) {
        status = s;
    }

    public String get() {
        return status;
    }
}
