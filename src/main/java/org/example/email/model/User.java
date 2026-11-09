
package org.example.email.model;

import java.io.Serializable;

public class User implements Serializable {

    // Cac thuoc tinh cua nguoi dung
    private String firstName;
    private String lastName;
    private String email;

    // Constructor mac dinh
    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    // Constructor co tham so
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getter va Setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
