package com.qy._99_design_pattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

// 享元工厂：字符工厂
class CharacterFactory {
    private Map<Character, CharacterFlyweight> flyweightPool = new HashMap<>();

    public CharacterFlyweight getCharacter(char key) {
        CharacterFlyweight flyweight = flyweightPool.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteCharacter(key);
            flyweightPool.put(key, flyweight);
        }
        return flyweight;
    }
}
