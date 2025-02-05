package com.qy.designpattern.structure.flyweight;

// 具体享元：具体字符
class ConcreteCharacter implements CharacterFlyweight {
    private char character;

    public ConcreteCharacter(char character) {
        this.character = character;
    }

    @Override
    public void display(int fontSize) {
        System.out.println("Character: " + character + ", Font Size: " + fontSize);
    }
}
