package it.sevenbits.courses.sm.manager.cmd;


public class CommandInitializator {

    private static final String LISTEN = "LISTEN";
    private static final String TRASH_SUSPICION = "TRASH_SUSPICION";
    private static final String IGNORE = "IGNORE";
    private static final String FLUSH = "FLUSH";


    private static final String MESSAGE = "MESSAGE";
    private static final String TRASH = "TRASH";
    private static final String MESSAGE_START = "MESSAGE_START";
    private static final String MESSAGE_FINISH = "MESSAGE_FINISH";


    void initialize(CommandGenerator commandGenerator) {
        AppendMessageCommand appendMessageCommand = new AppendMessageCommand(null, null);
        EmptyCommand emptyCommand = new EmptyCommand();
        FlushCommand flushCommand = new FlushCommand(null);

        commandGenerator.update(appendMessageCommand);
        commandGenerator.update(flushCommand);

        commandGenerator.update(LISTEN, MESSAGE, appendMessageCommand);
        commandGenerator.update(TRASH_SUSPICION, MESSAGE, appendMessageCommand);
        commandGenerator.update(TRASH_SUSPICION, TRASH, emptyCommand);
        commandGenerator.update(IGNORE, MESSAGE, emptyCommand);
        commandGenerator.update(IGNORE, TRASH, emptyCommand);
        commandGenerator.update(LISTEN, MESSAGE_START, emptyCommand);
        commandGenerator.update(IGNORE, MESSAGE_FINISH, flushCommand);
        commandGenerator.update(FLUSH, TRASH, flushCommand);
        commandGenerator.update(FLUSH, MESSAGE_FINISH, emptyCommand);
    }

}
