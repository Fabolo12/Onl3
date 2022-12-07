package com.popov;

import com.popov.action.Actions;
import com.popov.util.UserInput;


public class Main {
    public static void main(final String[] args) {
        final Actions[] values = Actions.values();
        final String[] names = mapActionToName(values);

        while (true) {
            final int userChoice = UserInput.menu(names);
            values[userChoice].execute();
        }
    }
    private static String[] mapActionToName(final Actions[] values) {
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }
}
