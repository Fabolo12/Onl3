package com.popov.action;

import lombok.Getter;

@Getter
public enum Actions {
    CREATE("Create cars", new CreateAction()),
    COMPARE("Compare cars", new CompareAction()),
    SHOW_ALL("Show all cars", new ShowAllAction()),
    OPTIONAL("Examples of Optional", new OptionalAction()),
    GENERIC("Examples of Generic", new GenericAction()),
    EXIT("Finish program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }

    public void execute() {
        action.execute();
    }
}
