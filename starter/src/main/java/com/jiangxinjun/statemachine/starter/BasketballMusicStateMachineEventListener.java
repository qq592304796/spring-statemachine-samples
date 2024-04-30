package com.jiangxinjun.statemachine.starter;

import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

@Component
public class BasketballMusicStateMachineEventListener extends StateMachineListenerAdapter<States, Event> {

    @Override
    public void stateChanged(State<States, Event> from, State<States, Event> to) {
        // 初始化from为空。直接返回不处理
        if (from == null) {
            return;
        }
        if (from.getId() == States.IDLE && to.getId() == States.PLAYING_BB) {
            System.out.println("开始打篮球，music 起");
        } else if (from.getId() == States.PLAYING_BB && to.getId() == States.SINGING) {
            System.out.println("唱跳，你干嘛");
        } else if (from.getId() == States.SINGING && to.getId() == States.PLAYING_BB) {
            System.out.println("继续打篮球，music 继续");
        }
    }
}
