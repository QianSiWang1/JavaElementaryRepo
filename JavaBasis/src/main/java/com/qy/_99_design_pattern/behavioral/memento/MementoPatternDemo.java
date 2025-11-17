package com.qy._99_design_pattern.behavioral.memento;

// 客户端代码
public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // 输入文本
        editor.setContent("Hello");
        // 保存当前状态
        history.saveMemento(editor.createMemento());

        // 继续输入文本
        editor.setContent("Hello, World!");
        // 保存当前状态
        history.saveMemento(editor.createMemento());

        // 显示当前文本
        System.out.println("Current content: " + editor.getContent());

        // 撤销操作
        Memento memento = history.getMemento();
        if (memento != null) {
            editor.restoreFromMemento(memento);
            System.out.println("After undo: " + editor.getContent());
        }

        // 再次撤销操作
        memento = history.getMemento();
        if (memento != null) {
            editor.restoreFromMemento(memento);
            System.out.println("After another undo: " + editor.getContent());
        }
    }
}
