package system.main;

import system.dao.SQLiteManager;
import system.ui.ConsoleUI;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Khởi động hệ thống quản lý nhân viên...");

        SQLiteManager.initializeDatabase();
        SQLiteManager.insertSampleData();



//        ConsoleUI ui = new ConsoleUI();
//        ui.start();
    }
}