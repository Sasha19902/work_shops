package it.sevenbits.courses.sm.log;

public class MessageFormatterFactory {

    private static final String TYPE_MESSAGE = "MESSAGE";
    private static final String VALUE_ANSWER_MESSAGE = "Part of message: %1$s";

    private static final String TYPE_TRASH = "TRASH";
    private static final String VALUE_ANSWER_TRASH = "Trash received";

    private static final String TYPE_MESSAGE_START = "MESSAGE_START";
    private static final String VALUE_ANSWER_MESSAGE_START = "Message creating started";

    private static final String TYPE_MESSAGE_FINISH = "MESSAGE_FINISH";
    private static final String VALUE_ANSWER_MESSAGE_FINISH = "Message creating finished";

    public static MessageFormatter getInitMessageFormatter() {
        MessageFormatter messageFormatter = new MessageFormatter();

        messageFormatter.update(TYPE_MESSAGE, VALUE_ANSWER_MESSAGE);
        messageFormatter.update(TYPE_TRASH, VALUE_ANSWER_TRASH);
        messageFormatter.update(TYPE_MESSAGE_START, VALUE_ANSWER_MESSAGE_START);
        messageFormatter.update(TYPE_MESSAGE_FINISH, VALUE_ANSWER_MESSAGE_FINISH);

        return messageFormatter;
    }


}
