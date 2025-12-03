package _01_thread._03_concurrent_challenge;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import javax.annotation.concurrent.Immutable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qy
 */
public class _01_ImmutabilitySolutions {
    /**
     * 深度不可变类设计
     */
    @Immutable  // 使用注解标记（如JSR-305）
    public static final class ImmutablePerson {
        // 1. 类声明为final，防止子类修改行为
        // 2. 所有字段为final
        private final String name;
        private final int age;
        private final List<String> hobbies;

        // 3. 通过构造函数初始化所有字段
        public ImmutablePerson(String name, int age, List<String> hobbies) {
            this.name = name;
            this.age = age;
            // 4. 对可变对象进行防御性复制
            this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));
        }

        // 5. 不提供setter方法
        public String getName() { return name; }
        public int getAge() { return age; }

        // 6. 返回不可变视图
        public List<String> getHobbies() {
            return hobbies;  // 已经是不可变列表
        }

        // 7. 提供"with"方法创建新对象（函数式风格）
        public ImmutablePerson withAge(int newAge) {
            return new ImmutablePerson(this.name, newAge, this.hobbies);
        }
    }

    /**
     * 使用不可变集合（Guava）
     */
    public static class GuavaImmutables {
        // 创建不可变集合
        private final ImmutableList<String> names =
                ImmutableList.of("Alice", "Bob", "Charlie");

        private final ImmutableMap<String, Integer> scores =
                ImmutableMap.of("Alice", 95, "Bob", 87);
    }
}
