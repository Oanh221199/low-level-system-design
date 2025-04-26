package com.company.model;

import java.time.LocalDateTime;
import java.util.List;

// Tính kế thừa
public class RegularUser extends  User {
    // Tính đóng gói
    private LocalDateTime registrationDate;

    public RegularUser(String id, String name, List<Email> emails, LocalDateTime registrationDate) {
        super(id, name, emails);
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "RegularUser{" +
                "registrationDate=" + registrationDate +
                '}';
    }
}
