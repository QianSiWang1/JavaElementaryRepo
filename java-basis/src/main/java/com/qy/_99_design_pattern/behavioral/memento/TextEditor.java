package com.qy._99_design_pattern.behavioral.memento;

// 原发器类：文本编辑器
class TextEditor {
    private String content;

    public TextEditor() {
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // 创建备忘录对象
    public Memento createMemento() {
        return new Memento(content);
    }

    // 从备忘录对象中恢复状态
    public void restoreFromMemento(Memento memento) {
        this.content = memento.getState();
    }
}
