package system.BankingSystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
    private Long id;
    private  String ownerName;
    private double balance;
    private LocalDateTime createdAt;

    public Account(Long id, String ownerName, double initialBalance){

        if (initialBalance < 0){
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.id = id;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.createdAt = LocalDateTime.now();
    }

    public void deposit(double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }

        balance += amount;
    }

    public void withDraw(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("amount cannot be negative");
        }

        if (amount > balance){
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
    }

    // --- Getters only (encapsulation) ---
    public long getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}
