package com.company.interfaces;

import com.company.model.Email;
import com.company.model.User;

import java.util.List;

public interface UserService {
    List<Email> getEmailsByUserId(List<User> users, String userId);
}
