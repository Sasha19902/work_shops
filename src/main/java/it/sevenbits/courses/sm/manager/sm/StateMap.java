package it.sevenbits.courses.sm.manager.sm;

import java.util.HashMap;
import java.util.Map;

class StateMap {
    private final State defaultState = new State("IGNORE");
    private final String MESSAGE_START = "MESSAGE_START";
    private final String MESSAGE_FINAL = "MESSAGE_FINISH";
    private final String FLUSH = "FLUSH";

    private final Map<Pair<State, String>, State> states;

    StateMap() {

        states = new HashMap<>();
        State listenState = new State("LISTEN");
        State stubSuspicion = new State("TRASH_SUSPICION");
        State flush = new State(FLUSH);

        states.put(new Pair<>(defaultState, MESSAGE_START), listenState);
        states.put(new Pair<>(defaultState, MESSAGE_FINAL), defaultState);

        states.put(new Pair<>(flush, MESSAGE_START), listenState);
        states.put(new Pair<>(flush, MESSAGE_FINAL), flush);
        states.put(new Pair<>(flush, "MESSAGE"), flush);
        states.put(new Pair<>(flush, "TRASH"), flush);

        states.put(new Pair<>(defaultState, "MESSAGE"), defaultState);
        states.put(new Pair<>(defaultState, "TRASH"), defaultState);


        states.put(new Pair<>(listenState, "MESSAGE"), listenState);
        states.put(new Pair<>(listenState, "TRASH"), stubSuspicion);

        states.put(new Pair<>(stubSuspicion, "MESSAGE"), stubSuspicion);
        states.put(new Pair<>(stubSuspicion, "TRASH"), flush);


    }

    public State getStartState() {
        return defaultState;
    }

    public State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }
}
