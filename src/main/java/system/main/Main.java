package system.main;

import system.dao.SQLiteManager;
import system.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Khởi động hệ thống quản lý nhân viên...");

        SQLiteManager.initializeDatabase();
        SQLiteManager.insertSampleData();

        ConsoleUI ui = new ConsoleUI();
        ui.start();

    }
}