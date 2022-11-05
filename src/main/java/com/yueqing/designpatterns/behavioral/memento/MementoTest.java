package com.yueqing.designpatterns.behavioral.memento;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class MementoTest {
    public static void main(String[] args) {
        GameStateMemento memento = new GameStateMemento();
        GameState gameState = new GameState(10,memento);
        gameState.savePoint();
        gameState.setState(20);
        gameState.savePoint();
        gameState.setState(30);
        System.out.println(gameState.getState());

        gameState.restore();
        System.out.println(gameState.getState());
    }

}
