package com.yueqing.designpatterns.behavioral.memento;

import java.util.Stack;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class GameStateMemento {

    private final Stack<Integer> stateHistory = new Stack<>();

    public void savePoint(int state){
        stateHistory.push(state);
    }

    public Integer getLastState(){
        return stateHistory.pop();
    }

}
