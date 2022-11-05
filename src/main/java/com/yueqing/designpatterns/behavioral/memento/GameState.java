package com.yueqing.designpatterns.behavioral.memento;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class GameState {

    private int state;
    private final GameStateMemento memento;

    public GameState(int state,GameStateMemento memento) {
        this.state = state;
        this.memento = memento;
    }

    public void savePoint(){
        memento.savePoint(state);
    }

    public void restore(){
        this.state = memento.getLastState();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
