package com.zohan.rsbot.scripts.fletcher.data;

/**
 * @Author: Zohan
 */
public enum CutItem {

    ARROW_SHAFT("Arrow Shaft", 1511, "Normal Wood", 0, 0);

    private final int logId, gridIndex, menuIndex;
    private final String name, category;

    CutItem(String name, int logId, String category, int gridIndex, int menuIndex) {
        this.name = name;
        this.logId = logId;
        this.category = category;
        this.gridIndex = gridIndex;
        this.menuIndex = menuIndex;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getLogId() {
        return logId;
    }

    public int getGridIndex() {
        return gridIndex;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public String toString() {
        return getName();
    }
}
