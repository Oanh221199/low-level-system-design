package com.company.model;

import java.time.LocalDateTime;
// Tính kế thừa
public class VipUser extends User {
    // Tính đóng gói
    private int vipLevel;

    public VipUser(String id, String name, String email, int vipLevel, LocalDateTime now) {
        super(id, name, email);
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
