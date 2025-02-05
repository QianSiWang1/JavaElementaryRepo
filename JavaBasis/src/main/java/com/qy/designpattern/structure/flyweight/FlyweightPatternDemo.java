package com.qy.designpattern.structure.flyweight;

// 客户端代码
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        // 获取字符 'A'
        CharacterFlyweight charA1 = factory.getCharacter('A');
        charA1.display(12);

        // 再次获取字符 'A'
        CharacterFlyweight charA2 = factory.getCharacter('A');
        charA2.display(16);

        // 获取字符 'B'
        CharacterFlyweight charB = factory.getCharacter('B');
        charB.display(14);
    }
}
