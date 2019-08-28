package com.pugz.colormatic.core.util;

import net.minecraft.util.IStringSerializable;

public enum ConnectedDirectionsFourWay implements IStringSerializable {

    FULL("full"),
    CENTER("center"),
    THREE_WAY_N("three_way_n"),
    THREE_WAY_S("three_way_s"),
    THREE_WAY_E("three_way_e"),
    THREE_WAY_W("three_way_w"),
    FOUR_WAY("four_way"),
    UP_DOWN_NS("up_down_ns"),
    UP_DOWN_EW("up_down_ew"),
    UP_DOWN_END_N("up_down_end_n"),
    UP_DOWN_END_S("up_down_end_s"),
    UP_DOWN_END_E("up_down_end_e"),
    UP_DOWN_END_W("up_down_end_w"),
    CORNER_NE("corner_ne"),
    CORNER_NW("corner_nw"),
    CORNER_SE("corner_se"),
    CORNER_SW("corner_sw"),
    CORNER_CENTER_NE("corner_center_ne"),
    CORNER_CENTER_NW("corner_center_nw"),
    CORNER_CENTER_SE("corner_center_se"),
    CORNER_CENTER_SW("corner_center_sw"),
    SIDE_N("side_n"),
    SIDE_S("side_s"),
    SIDE_E("side_e"),
    SIDE_W("side_w");

    private final String name;

    ConnectedDirectionsFourWay(String nameIn) {
        name = nameIn;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}