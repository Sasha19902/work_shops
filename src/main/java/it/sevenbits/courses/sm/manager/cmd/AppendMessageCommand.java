package it.sevenbits.courses.sm.manager.cmd;

import it.sevenbits.courses.sm.manager.sm.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

public class AppendMessageCommand implements INetworkManagerCommand, Updatable {

    private StringBuilder stringBuilder;
    private NetworkPackage networkPackage;

    public AppendMessageCommand(StringBuilder stringBuilder, NetworkPackage networkPackage) {
        this.networkPackage = networkPackage;
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void execute() {
        stringBuilder.append(networkPackage.getMessage());
    }

    @Override
    public void update(StringBuilder stringBuilder, NetworkPackage networkPackage) {
        this.stringBuilder = stringBuilder;
        this.networkPackage = networkPackage;
    }
}
