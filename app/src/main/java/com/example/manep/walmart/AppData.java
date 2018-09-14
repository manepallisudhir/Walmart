package com.example.manep.walmart;

import java.util.Vector;

public class AppData {

    private static Vector<Object> transitionFIFO = new Vector<>();

    public static Object getTransitionData() {
        Object data = transitionFIFO.get(0);
        transitionFIFO.remove(0);
        return data;
    }

    public static void clearTransitionData() {
        transitionFIFO.clear();
    }

    public static void addTransitionData(Object data) {
        transitionFIFO.add(data);
    }
}
