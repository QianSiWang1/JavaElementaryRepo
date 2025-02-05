package com.qy.designpattern.behavioral.chain;

// 具体处理者：组长
class TeamLeader extends Leader {
    @Override
    public void handleRequest(int days) {
        if (days <= 1) {
            System.out.println("Team leader approved the leave for " + days + " day(s).");
        } else {
            if (nextLeader != null) {
                nextLeader.handleRequest(days);
            } else {
                System.out.println("No one can approve the leave for " + days + " day(s).");
            }
        }
    }
}
