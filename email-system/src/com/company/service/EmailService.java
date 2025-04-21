package com.company.service;

import com.company.model.Email;

import java.util.List;
// Tính trừu tượng
public interface EmailService {
    List<Email> filterUnreadEmails(List<Email> inbox);
    List<Email> filterEmailsBySender(List<Email> inbox, String sender);
    Email findLatestEmail(List<Email> inbox);
}
