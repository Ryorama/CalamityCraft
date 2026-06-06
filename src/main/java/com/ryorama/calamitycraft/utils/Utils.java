package com.ryorama.calamitycraft.utils;

public class Utils {
    public static float mul(float input, int percent) {
        return input * (1 + percentOf(percent));
    }

    public static float percentOf(float value) {
        return value / 100;
    }
}
