package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

class EmailService {
    private final AtomicInteger countEmail = new AtomicInteger(0);
    private volatile boolean stopSendEmail = false;

    // Danh sách giữ các task gửi email
    private final List<CompletableFuture<Void>> futures = new ArrayList<>();

    // Send email async
    public synchronized void sendEmail(String email) {
        if (stopSendEmail) {
            log("Stopped send email: " + email);
            return;
        }

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            log("Send mail: " + email);
            countEmail.incrementAndGet();
        });

        futures.add(future);
    }

    // Dừng gửi email
    public synchronized void stop() {
        stopSendEmail = true;
        log("Stop send email.");
    }

    // Chờ các task gửi email hiện có hoàn thành
    public void waitUntilDone() {
        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        try {
            all.join();  // chờ tất cả hoàn thành
        } catch (Exception e) {
            log("Exception while waiting: " + e.getMessage());
        }
    }

    private synchronized void log(String mess) {
        System.out.println("Log: " + mess);
    }

    public int getEmailCount() {
        return countEmail.get();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EmailService service = new EmailService();

        // Gửi email trong một luồng riêng để có thể dừng giữa chừng
        Thread senderThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                service.sendEmail("email" + i + "@gmail.com");

                // Giả sử mỗi email gửi mất thời gian, sleep để dễ dừng
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                if (Thread.currentThread().isInterrupted()) break;
            }
        });

        senderThread.start();

        // Chờ 100ms rồi dừng gửi giữa chừng
        Thread.sleep(100);
        service.stop();

        // Đợi luồng gửi email dừng lại
        senderThread.interrupt();
        senderThread.join();

        // Chờ các task đã gửi hoàn thành
        service.waitUntilDone();

        System.out.println("Email count sent: " + service.getEmailCount());
    }
}
