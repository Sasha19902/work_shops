package it.sevenbits.courses.sm.manager.cmd;

import it.sevenbits.courses.sm.manager.sm.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

public class MachineCommander {

    private StringBuilder stringBuilder;
    private CommandGenerator commandGenerator;
    private boolean flag;

    public MachineCommander(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        commandGenerator = new CommandGenerator(stringBuilder);
        CommandInitializator commandInitializator = new CommandInitializator();
        commandInitializator.initialize(commandGenerator);
    }

    public INetworkManagerCommand generateCommand(State stateMachine, NetworkPackage networkPackage) {
        return commandGenerator.generateCommand(stateMachine, networkPackage);
    }


}
