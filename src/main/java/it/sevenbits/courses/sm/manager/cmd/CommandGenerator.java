package it.sevenbits.courses.sm.manager.cmd;

import it.sevenbits.courses.sm.manager.sm.Pair;
import it.sevenbits.courses.sm.manager.sm.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandGenerator {

    private Map<Pair<String, String>, INetworkManagerCommand> mapGenerator;
    private Set<Updatable> updatableCommands;
    private StringBuilder stringBuilder;

    CommandGenerator(StringBuilder stringBuilder) {
        mapGenerator = new HashMap<>();
        updatableCommands = new HashSet<>();
        this.stringBuilder = stringBuilder;
    }

    public INetworkManagerCommand generateCommand(State state, NetworkPackage networkPackage) {
        updatableCommands.forEach(act -> act.update(stringBuilder, networkPackage));
        return mapGenerator.get(new Pair<>(state.toString(), networkPackage.getType()));
    }

    void initialize(CommandInitializator initilizator) {
        initilizator.initialize(this);
    }

    void update(String stringType, String networkPackageType, INetworkManagerCommand command) {
        mapGenerator.put(new Pair<>(stringType, networkPackageType), command);
    }

    void update(Updatable updatable) {
        updatableCommands.add(updatable);
    }
}
