package com.qy._99_design_pattern.behavioral.chain;

// 具体处理者：总经理
class GeneralManager extends Leader {
    @Override
    public void handleRequest(int days) {
        if (days <= 7) {
            System.out.println("General manager approved the leave for " + days + " day(s).");
        } else {
            System.out.println("Leave for " + days + " day(s) cannot be approved.");
        }
    }
}
