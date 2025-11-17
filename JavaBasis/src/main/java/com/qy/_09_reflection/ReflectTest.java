package com.qy._09_reflection;

import com.qy._07_annotation.MyAnnotation;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author QianSiWang
 * @Date 2022/8/21 14:50
 * @Description
 */
public class ReflectTest {

    /**
     * 获取Class对象的方式：
     * 1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
     * 2. 类名.class：通过类名的属性class获取
     * 3. 对象.getClass()：getClass()方法在Object类中定义着。
     */
    @Test
    public void test1() throws ClassNotFoundException {
        //1.Class.forName("全类名")
        Class cls1 = Class.forName("com.qy._09_reflection.Person");
        System.out.println(cls1);
        //2.类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3.对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
        //== 比较三个对象
        System.out.println(cls1 == cls2);//true
        System.out.println(cls1 == cls3);//true


        Class c = Person.class;
        System.out.println(c == cls1);

    }

    /**
     Class对象功能：
     * 获取功能：
     1. 获取成员变量们
     * Field[] getFields()
     * Field getField(String name)

     * Field[] getDeclaredFields()
     * Field getDeclaredField(String name)
     2. 获取构造方法们
     * Constructor<?>[] getConstructors()
     * Constructor<T> getConstructor(类<?>... parameterTypes)

     * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
     * Constructor<?>[] getDeclaredConstructors()
     3. 获取成员方法们：
     * Method[] getMethods()
     * Method getMethod(String name, 类<?>... parameterTypes)

     * Method[] getDeclaredMethods()
     * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

     4. 获取类名
     * String getName()
     */
    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
             1. 获取成员变量们
                 * Field[] getFields()
                 * Field getField(String name)

                 * Field[] getDeclaredFields()
                 * Field getDeclaredField(String name)

         */
        //1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("------------");
        //2.Field getField(String name)
        Field a = personClass.getField("name");
        //获取成员变量a 的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"张三");
        System.out.println(p);

        System.out.println("===================");

        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("num");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);

        Constructor[] constructors = personClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

    }

    /**
     * 创建对象
     */
    @Test
    public void test3() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        System.out.println(person);
        Constructor<?> constructor = personClass.getConstructor(String.class, int.class, int.class);
        Object o = constructor.newInstance("QSW",26,1);
        System.out.println(o);
    }

    @Test
    public void test4() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        person.setAge(26);
        Class<? extends Person> aClass = person.getClass();
        Field name = aClass.getField("name");
        name.set(person,"QianYu");
        Field num = aClass.getDeclaredField("num");
        num.setAccessible(true);
        num.set(person,22);
        System.out.println(person);
        Field age = aClass.getField("age");
        Object o = age.get(person);
        System.out.println(o);
    }
    @Test
    public void test5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        Method method = aClass.getMethod("funcStr",String.class);
        Object str = method.invoke(person, "str");
        System.out.println(str);
        Annotation[] annotations = aClass.getDeclaredAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
            MyAnnotation b = (MyAnnotation) a ;
            System.out.println(b.age());
            System.out.println(b.name());
        }
    }


}
