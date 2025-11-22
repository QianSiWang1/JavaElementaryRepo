package com.qy._02_class_about._01_modifiers;

public class _01_Modifiers_private {
    // 私有字段 - 只能在_01_Modifiers_private类内部访问
    private String accountNumber;
    private double balance;
    private String password;

    // 私有构造方法 - 只能在类内部调用
    private _01_Modifiers_private() {
        // 用于特殊初始化
    }

    public _01_Modifiers_private(String accountNumber, double initialBalance, String password) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.password = password;
    }

    // 私有方法 - 只能在类内部调用
    private boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // 私有内部类 - 只能在外部类内部使用
    private class Transaction {
        private String type;
        private double amount;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
    }

    // 公共方法可以访问私有成员
    public boolean withdraw(double amount, String inputPassword) {
        if (!authenticate(inputPassword)) { // 调用私有方法
            System.out.println("密码错误");
            return false;
        }

        if (amount > balance) {
            System.out.println("余额不足");
            return false;
        }

        balance -= amount; // 访问私有字段
        // 记录私有内部类的交易
        Transaction transaction = new Transaction("WITHDRAW", amount);
        return true;
    }

    // 公共方法访问私有字段
    public double getBalance() {
        return balance;
    }

    // 私有字段通过公共方法间接访问
    public String getAccountNumber() {
        return accountNumber;
    }

    public static void main(String[] args) {
        _01_Modifiers_private account = new _01_Modifiers_private("123456", 1000, "password123");

        // 可以访问公共方法
        account.withdraw(100, "password123");
        System.out.println("余额: " + account.getBalance());

        // 以下代码都会编译错误，因为访问了私有成员：
        // System.out.println(account.balance);        // 错误：private字段
        // System.out.println(account.password);       // 错误：private字段
        // account.authenticate("123");                // 错误：private方法
        // _01_Modifiers_private acc2 = new _01_Modifiers_private();       // 错误：private构造方法
    }
}
