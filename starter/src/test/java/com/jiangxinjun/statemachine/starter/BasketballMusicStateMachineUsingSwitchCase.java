package com.jiangxinjun.statemachine.starter;

public class BasketballMusicStateMachineUsingSwitchCase {
    private boolean isPlayingMusic;

    public BasketballMusicStateMachineUsingSwitchCase() {
        this.isPlayingMusic = false; // 初始状态为音乐未播放
    }

    public void playMusic() {
        if (!isPlayingMusic) {
            System.out.println("Music starts playing...");
            isPlayingMusic = true;
        }
    }

    public void stopMusic() {
        if (isPlayingMusic) {
            System.out.println("Music stops playing...");
            isPlayingMusic = false;
        }
    }

    public void performActivity(String activity) {
        switch (activity) {
            case "basketball":
                System.out.println("Music ~");
                playMusic(); // 打篮球时播放音乐
                break;
            case "sing_rap":
                System.out.println("哎哟 你干嘛 ~");
                stopMusic(); // 唱跳Rap时停止音乐
                break;
            default:
                System.out.println("Invalid activity!");
        }
    }

    public static void main(String[] args) {
        BasketballMusicStateMachineUsingSwitchCase stateMachine = new BasketballMusicStateMachineUsingSwitchCase();

        // 测试状态机
        stateMachine.performActivity("basketball"); // 打篮球，音乐开始播放
        stateMachine.performActivity("sing_rap"); // 唱跳Rap，音乐停止播放
        stateMachine.performActivity("basketball"); // 再次打篮球，音乐重新开始播放
    }
}

