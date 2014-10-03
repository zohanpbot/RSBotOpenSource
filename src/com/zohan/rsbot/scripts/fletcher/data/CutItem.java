package com.zohan.rsbot.scripts.fletcher.data;

/**
 * @Author: Zohan
 */
public enum CutItem {

    ARROW_SHAFT("Arrow Shaft", 1511, "Normal Wood", 0, 0),
    SHORTBOW("Shortbow", 1511, "Normal Wood", 1, 0),
    SHIELDBOW("Shortbow", 1511, "Normal Wood", 3, 0),
    OAK_SHORTBOW("Oak Shortbow", 1521, "Oak", 0, 2),
    OAK_SHIELDBOW("Oak Shieldbow", 1521, "Oak", 2, 2),
    WILLOW_SHORTBOW("Willow Shortbow", 1519, "Willow", 0, 3),
    WILLOW_SHIELDBOW("Willow Shieldbow", 1519, "Willow", 2, 3),
    MAPLE_SHORTBOW("Maple Shortbow", 1517, "Maple", 0, 5),
    MAPLE_SHIELDBOW("Maple Shieldbow", 1517, "Maple", 2, 5),
    YEW_SHORTBOW("Yew Shortbow", 1515, "Yew", 0, 7),
    YEW_SHIELDBOW("Yew Shieldbow", 1515, "Yew", 2, 7),
    MAGIC_SHORTBOW("Magic Shortbow", 1513, "Magic", 0, 8),
    MAGIC_SHIELDBOW("Magic Shieldbow", 1513, "Magic", 1, 8);



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
