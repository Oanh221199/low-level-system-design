package com.company.util;

import com.company.interfaces.UserService;
import com.company.model.RegularUser;
import com.company.model.User;
import com.company.model.VipUser;
import com.company.service.RegularUserSevice;
import com.company.service.VipUserService;

public class UserServiceProvider {
    public static UserService getUserService(User user) {
        if (user instanceof VipUser) {
            return new VipUserService();
        } else if (user instanceof RegularUser) {
            return new RegularUserSevice();
        }
        throw new IllegalArgumentException("Unknown user type");
    }
}
