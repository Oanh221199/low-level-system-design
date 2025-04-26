package com.company.model;

import java.time.LocalDateTime;
import java.util.List;

// Tính kế thừa
public class VipUser extends User {
    // Tính đóng gói
    private int vipLevel;

    public VipUser(String id, String name, List<Email> emails, int vipLevel) {
        super(id, name, emails);
        this.vipLevel = vipLevel;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    @Override
    public String toString() {
        return "VipUser{" +
                "vipLevel=" + vipLevel +
                '}';
    }
}
