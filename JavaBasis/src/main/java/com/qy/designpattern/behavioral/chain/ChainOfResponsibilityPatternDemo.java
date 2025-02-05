package com.qy.designpattern.behavioral.chain;

// 客户端代码
public class ChainOfResponsibilityPatternDemo {
    public static void main(String[] args) {
        // 创建处理者
        Leader teamLeader = new TeamLeader();
        Leader departmentManager = new DepartmentManager();
        Leader generalManager = new GeneralManager();

        // 设置责任链
        teamLeader.setNextLeader(departmentManager);
        departmentManager.setNextLeader(generalManager);

        // 发送请求
        teamLeader.handleRequest(1);
        teamLeader.handleRequest(3);
        teamLeader.handleRequest(5);
        teamLeader.handleRequest(10);
    }
}
