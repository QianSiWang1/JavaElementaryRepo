package com.qy.designpattern.behavioral.chain;

// 具体处理者：部门经理
class DepartmentManager extends Leader {
    @Override
    public void handleRequest(int days) {
        if (days <= 3) {
            System.out.println("Department manager approved the leave for " + days + " day(s).");
        } else {
            if (nextLeader != null) {
                nextLeader.handleRequest(days);
            } else {
                System.out.println("No one can approve the leave for " + days + " day(s).");
            }
        }
    }
}
