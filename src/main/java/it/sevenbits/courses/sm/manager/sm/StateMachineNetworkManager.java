package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.log.MessageFormatter;
import it.sevenbits.courses.sm.log.MessageFormatterFactory;
import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.NetworkManagerException;
import it.sevenbits.courses.sm.manager.cmd.INetworkManagerCommand;
import it.sevenbits.courses.sm.manager.cmd.MachineCommander;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private static final Logger LOGGER = LoggerFactory.getLogger(StateMachineNetworkManager.class);
    private final MessageFormatter messageFormatter;


    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
        messageFormatter = MessageFormatterFactory.getInitMessageFormatter();

    }

    @Override
    public void listen(INetwork network) throws NetworkManagerException {
        StringBuilder stringBuilder = new StringBuilder();
        MachineCommander machineCommander = new MachineCommander(stringBuilder);
        State currentState = stateTransition.getStartState();

        try {
            while (!isInterrupted) {
                while (network.hasPackage()) {
                    NetworkPackage p = network.getPackage();
                    LOGGER.info(String.format(messageFormatter.getStringFormatByType(p.getType()), p.getMessage()));
                    currentState = stateTransition.nextState(currentState, p);
                    INetworkManagerCommand command = machineCommander.generateCommand(currentState, p);
                    command.execute();
                }
                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        LOGGER.debug("manager stop working");
        isInterrupted = true;
    }
}
