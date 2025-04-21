package com.company.util;

import com.company.model.Email;

public class SpamFilter {
    public static boolean isSpam(Email email) {
        String subj = email.getSubject().toLowerCase();
        return subj.contains("spam")
                || subj.contains("promotion")
                || subj.contains("win");
    }
}
