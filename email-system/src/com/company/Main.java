package com.company;

import com.company.model.Email;
import com.company.model.RegularUser;
import com.company.model.VipUser;
import com.company.service.EmailService;
import com.company.service.RegularEmailService;
import com.company.service.VipEmailService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Email> inbox = Arrays.asList(
                new Email(1,"Hello World 1", "Content 1", "a@example.com", LocalDateTime.now().minusHours(2), false),
                new Email(2, "Hello World 2", "Content 2", "b@example.com", LocalDateTime.now().minusDays(1), false),
                new Email(3, "Hello World 3", "Content 3", "c@example.com", LocalDateTime.now().minusMinutes(30), true),
                new Email(4,"Hello World 4", "Content 4", "d@example.com", LocalDateTime.now().minusHours(5), false)
        );

        EmailService regService = new RegularEmailService();
        EmailService vipService = new VipEmailService();

        RegularUser regular = new RegularUser("1", "Nguyen Van A", "a1@gmail.com", LocalDateTime.now());
        VipUser vip = new VipUser("2", "Tran Thi B", "b1@gmail.com", 3, LocalDateTime.now());

        // Sử dụng RegularUser
        //  Lambda Expressions: e -> System.out.println("  " + e.getSubject()
        System.out.println("Regular User Emails:");
        regService.filterUnreadEmails(inbox)
                .forEach(e -> System.out.println("  " + e.getSubject()));

        // Sử dụng VipUser
        //  Lambda Expressions: e -> System.out.println("  " + e.getSubject()
        System.out.println("\nVIP User Emails (no spam):");
        vipService.filterUnreadEmails(inbox)
                .forEach(e -> System.out.println("  " + e.getSubject()));

        // Tìm email gần nhất
        System.out.println("\nRegular User Latest Email: " + regService.findLatestEmail(inbox).getSubject());
        System.out.println("VIP User - Latest Non-Spam Email: " + vipService.findLatestEmail(inbox).getSubject());
    }

}
