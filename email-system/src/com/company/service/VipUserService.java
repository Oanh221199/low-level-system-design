package com.company.service;
import com.company.interfaces.UserService;
import com.company.model.Email;
import com.company.model.User;
import com.company.model.VipUser;

import java.util.Collections;
import java.util.List;

public class VipUserService implements UserService {

    @Override
    public List<Email> getEmailsByUserId(List<User> users, String userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId) && user instanceof VipUser)
                .findFirst()
                .map(User::getEmails)
                .orElse(Collections.emptyList());
    }
}
