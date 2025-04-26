package com.company.service;

import com.company.interfaces.UserService;
import com.company.model.Email;
import com.company.model.RegularUser;
import com.company.model.User;
import com.company.model.VipUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegularUserSevice  implements UserService {
    @Override
    public List<Email> getEmailsByUserId(List<User> users, String userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId) && user instanceof RegularUser)
                .findFirst()
                .map(User::getEmails)
                .orElse(Collections.emptyList());
    }

}
