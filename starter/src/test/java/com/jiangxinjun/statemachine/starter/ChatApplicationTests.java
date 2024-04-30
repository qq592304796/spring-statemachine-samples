package com.jiangxinjun.statemachine.starter;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;


@SpringBootApplication
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ChatApplicationTests {

    @Resource
    private StateMachine<States, Event> stateMachine;

    @Test
    void contextLoads() {
        //开始打球，music 起
        stateMachine.sendEvent(Event.START_BB_MUSIC);
		//开始唱跳，你干嘛
        stateMachine.sendEvent(Event.STOP_BB_MUSIC);
		//继续打球，music 继续
        stateMachine.sendEvent(Event.START_BB_MUSIC);
    }
}
