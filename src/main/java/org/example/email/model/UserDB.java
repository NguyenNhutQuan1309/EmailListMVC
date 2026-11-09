
package org.example.email.model;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    // Danh sach tam thoi luu nguoi dung
    private static final List<User> users = new ArrayList<>();

    // Them nguoi dung
    public static synchronized void insert(User user) {
        users.add(user);
    }

    // Lay danh sach nguoi dung
    public static synchronized List<User> getAll() {
        return new ArrayList<>(users);
    }
}
