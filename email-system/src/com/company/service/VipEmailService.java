package com.company.service;

import com.company.interfaces.EmailService;
import com.company.model.Email;
import com.company.util.SpamFilter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Tính kế thừa
public class VipEmailService implements EmailService {

    // Tính đa hình
    // Lambda Expressions: e -> !e.isRead() && !SpamFilter.isSpam(e)
    // Stream API: sử dụng .stream()
    @Override
    public List<Email> filterUnreadEmails(List<Email> inbox) {
        return inbox.stream()
                .filter(e -> !e.isRead() && !SpamFilter.isSpam(e)) // lọc email chưa đọc và không phải spam
                .collect(Collectors.toList());
    }

    // Tính đa hình
    // Lambda Expressions: e -> e.getSender().equalsIgnoreCase(sender) && !SpamFilter.isSpam(e)
    // Stream API: sử dụng .stream()
    @Override
    public List<Email> filterEmailsBySender(List<Email> inbox, String sender) {
        return inbox.stream()
                .filter(e -> e.getSender().equalsIgnoreCase(sender)// lọc bởi người gửi
                        && !SpamFilter.isSpam(e)) // thêm điều kiện không phải spam
                .collect(Collectors.toList());
    }

    // Tính đa hình
    // Stream API: inbox.stream()
    // Method Reference: Email::getReceivedDate
    // Optional: dùng .orElse(null) (Optional<Email>)
    @Override
    public Email findLatestEmail(List<Email> inbox) {
        return inbox.stream()
                .filter(e -> !SpamFilter.isSpam(e)) // lọc bỏ email spam
                .max(Comparator.comparing(Email::getReceivedDate)) // tìm email có ngày nhận mới nhất
                .orElse(null);
    }
}
