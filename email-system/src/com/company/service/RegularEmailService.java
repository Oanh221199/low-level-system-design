package com.company.service;

import com.company.interfaces.EmailService;
import com.company.model.Email;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//Tính kế thừa
public class RegularEmailService implements EmailService {
    // Tính đa hình
    // Lambda Expressions: e -> !e.isRead()
    // Stream api: use . stream()
    @Override
    public List<Email> filterUnreadEmails(List<Email> inbox) {
        return inbox.stream()
                .filter(e -> !e.isRead()) // lọc email chưa đọc
                .collect(Collectors.toList());
    }
    //  Tính đa hình
    //  Lambda Expressions: e -> e.getSender().equalsIgnoreCase(sender)
    //  Stream api: use . stream()

    @Override
    public List<Email> filterEmailsBySender(List<Email> inbox, String sender) {
        return inbox.stream()
                .filter(e -> e.getSender().equalsIgnoreCase(sender)) // lọc bởi người gửi
                .collect(Collectors.toList());    }

    //  Tính đa hình
    //  Stream api: use . stream()
     // Method Reference: Email::getReceivedDate
    //  Optional: Optional<Email>
    @Override
    public Email findLatestEmail(List<Email> inbox) {
        return inbox.stream()
                .max(Comparator.comparing(Email::getReceivedDate)) // tìm email có ngày nhận mới nhất
                .orElse(null);
    }
}
