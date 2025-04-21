package com.company.model;

import java.time.LocalDateTime;

public class Email {
    // Tính đóng gói
    private  long id;
    private String sender;
    private String receiver;
    private String subject;
    private LocalDateTime receivedDate;
    private boolean isRead;

    public Email() {
    }

    public Email(long id, String sender, String receiver, String subject, LocalDateTime receivedDate, boolean isRead) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.receivedDate = receivedDate;
        this.isRead = isRead;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", receivedDate=" + receivedDate +
                ", isRead=" + isRead +
                '}';
    }
}
