package com.example.sohyeon.emotionaldiary.biosignal;


public class State {
    protected int state;

    public int getState() {
        return state;
    }

    public static State fromReceivedData(int state) {
        return new State(state);
    }

    protected State(int state) {
        this.state = state;
    }

    protected State(State otherState) {
        state = otherState.state;
    }

    protected State() {
        this.state = -1;
    }

}
