package com.jiangxinjun.statemachine.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class BasketballMusicStateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Event> {

    @Autowired
    private BasketballMusicStateMachineEventListener eventListener;

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Event> config) throws Exception {
        config
            .withConfiguration()
            .autoStartup(true)
            .listener(eventListener); // 设置状态机事件监听器
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Event> states) throws Exception {
        states
            .withStates()
            .initial(States.IDLE)
            .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Event> transitions) throws Exception {
        transitions
            .withExternal()
            .source(States.IDLE).target(States.PLAYING_BB).event(Event.START_BB_MUSIC)
            .and()
            .withExternal()
            .source(States.PLAYING_BB).target(States.SINGING).event(Event.STOP_BB_MUSIC)
            .and()
            .withExternal()
            .source(States.SINGING).target(States.PLAYING_BB).event(Event.START_BB_MUSIC);
    }
}
