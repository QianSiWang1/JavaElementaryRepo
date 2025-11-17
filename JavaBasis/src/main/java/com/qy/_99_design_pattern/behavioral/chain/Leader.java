package com.qy._99_design_pattern.behavioral.chain;

// 抽象处理者：领导
abstract class Leader {
    protected Leader nextLeader;

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public abstract void handleRequest(int days);
}

