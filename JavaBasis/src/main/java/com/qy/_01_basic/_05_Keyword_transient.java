package com.qy._01_basic;

import java.io.*;

public class _05_Keyword_transient implements Serializable {
    public static void main(String[] args) {
        _05_Keyword_transient user = new _05_Keyword_transient("john_doe", "secret123", "john@example.com");

        // 序列化
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("_05_Keyword_Transient.ser"))) {
            oos.writeObject(user);
            System.out.println("序列化前: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("_05_Keyword_Transient.ser"))) {
            _05_Keyword_transient deserializedUser = (_05_Keyword_transient) ois.readObject();
            System.out.println("反序列化后: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String username;
    private transient String password;  // 不会被序列化
    private String email;

    public _05_Keyword_transient(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // getter 和 setter 方法
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "', email='" + email + "'}";
    }
}
