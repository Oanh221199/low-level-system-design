package com.company;

import com.company.interfaces.UserService;
import com.company.model.Email;
import com.company.model.RegularUser;
import com.company.model.User;
import com.company.model.VipUser;
import com.company.interfaces.EmailService;
import com.company.service.RegularEmailService;
import com.company.service.VipEmailService;
import com.company.util.UserServiceProvider;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Email> inbox = Arrays.asList(
                new Email(1, "a@example.com", "user1@company.com", "Hello World 1", "Content 1",
                        Arrays.asList("cc1@company.com"), Arrays.asList("bcc1@company.com"),
                        LocalDateTime.now().minusHours(2), false),

                new Email(2, "b@example.com", "user1@company.com", "Hello World 2", "Content 2",
                        Arrays.asList("cc2@company.com"), Arrays.asList("bcc2@company.com"),
                        LocalDateTime.now().minusDays(1), false),

                new Email(3, "c@example.com", "user1@company.com", "Hello World 3", "Content 3",
                        Arrays.asList("cc3@company.com"), Arrays.asList("bcc3@company.com"),
                        LocalDateTime.now().minusMinutes(30), true),

                new Email(4, "d@example.com", "user1@company.com", "Hello World 4", "Content 4",
                        Arrays.asList("cc4@company.com"), Arrays.asList("bcc4@company.com"),
                        LocalDateTime.now().minusHours(5), false)
        );

        List<Email> inbox_vip = Arrays.asList(
                new Email(5, "a@example.com", "vip1@company.com", "Hello World 1", "Content 1",
                        Arrays.asList("cc1@company.com"), Arrays.asList("bcc1@company.com"),
                        LocalDateTime.now().minusHours(2), false),

                new Email(6, "b@example.com", "vip1@company.com", "Hello World 2", "Content 2",
                        Arrays.asList("cc2@company.com"), Arrays.asList("bcc2@company.com"),
                        LocalDateTime.now().minusDays(1), false),

                new Email(7, "c@example.com", "vip1@company.com", "Hello World 3", "Content 3",
                        Arrays.asList("cc3@company.com"), Arrays.asList("bcc3@company.com"),
                        LocalDateTime.now().minusMinutes(30), true),

                new Email(8, "d@example.com", "vip1@company.com", "Hello World 4", "Content 4",
                        Arrays.asList("cc4@company.com"), Arrays.asList("bcc4@company.com"),
                        LocalDateTime.now().minusHours(5), false)
        );

        EmailService regService = new RegularEmailService();
        EmailService vipService = new VipEmailService();

        // Regular user
        System.out.println("Regular User Emails:");
        regService.filterUnreadEmails(inbox)
                .forEach(e -> System.out.println("  " + e.getSubject()));

        // VIP user
        System.out.println("\nVIP User Emails (no spam):");
        vipService.filterUnreadEmails(inbox_vip)
                .forEach(e -> System.out.println("  " + e.getSubject()));

        // Latest emails
        System.out.println("\nRegular User Latest Email: " + regService.findLatestEmail(inbox).getSubject());
        System.out.println("VIP User - Latest Non-Spam Email: " + vipService.findLatestEmail(inbox_vip).getSubject());

        User regular = new RegularUser("1", "Nguyen Van A", inbox, LocalDateTime.now());
        User vip = new VipUser("2", "Tran Thi B", inbox_vip, 3);

        List<User> users = Arrays.asList(regular, vip);

        UserService userService = UserServiceProvider.getUserService(regular);
        List<Email> result = userService.getEmailsByUserId(users, regular.getId());

        System.out.println("Regular Emails of user:");
        result.forEach(email -> System.out.println(email.getId()));

        UserService userVipService = UserServiceProvider.getUserService(vip);
        List<Email> result_vip = userVipService.getEmailsByUserId(users, vip.getId());

        System.out.println("Vip Emails of user:");
        result_vip.forEach(email -> System.out.println(email.getId()));
    }
}
