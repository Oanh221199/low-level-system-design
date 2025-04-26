package com.company.model;

import java.util.List;

// Tính trừu tượng
public abstract class User {
    // Tính đóng gói
    private String id;
    private String name;
    private List<Email> emails;

    public User(String id, String name, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.emails = emails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emails=" + emails +
                '}';
    }
}
