package it.sevenbits.courses.sm.manager.cmd;

import it.sevenbits.courses.sm.network.NetworkPackage;

public class FlushCommand implements INetworkManagerCommand, Updatable {

    private StringBuilder stringBuilder;
    private static final int ZERO_MEMORY = 0;

    public FlushCommand(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void execute() {

        System.out.println("FINAL MESSAGE: " + stringBuilder.toString());
        stringBuilder.setLength(ZERO_MEMORY);
    }

    @Override
    public void update(StringBuilder stringBuilder, NetworkPackage networkPackage) {
        this.stringBuilder = stringBuilder;
    }
}
