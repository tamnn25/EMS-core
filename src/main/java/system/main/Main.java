package src.main.java.system.main;

import src.main.java.system.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Khởi động hệ thống quản lý nhân viên...");

        ConsoleUI ui = new ConsoleUI();
        ui.start();

    }
}