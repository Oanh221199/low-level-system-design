package com.company.model;

import java.time.LocalDateTime;
import java.util.List;

public class Email {
    // Tính đóng gói
    private  long id;
    private String sender;
    private String receiver;
    private String subject;
    private String content;
    private List<String> cc;
    private List<String> bcc;
    private LocalDateTime receivedDate;
    private boolean isRead;

    public Email(long id, String sender, String receiver, String subject, String content, List<String> cc, List<String> bcc, LocalDateTime receivedDate, boolean isRead) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
        this.cc = cc;
        this.bcc = bcc;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
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
                ", content='" + content + '\'' +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", receivedDate=" + receivedDate +
                ", isRead=" + isRead +
                '}';
    }
}
