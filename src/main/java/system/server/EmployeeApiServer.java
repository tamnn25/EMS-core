package system.server;

import static spark.Spark.*;

import system.dao.SQLiteManager;

public class EmployeeApiServer {
    public static void main(String[] args) {
        port(8080);

        // GET /employees
        get("/employees", (req, res) -> {
            res.type("application/json");
            // For now, return hardcoded sample JSON
            return "[{\"id\":1,\"name\":\"Alice\",\"position\":\"Manager\",\"salary\":8000.0}," +
                    "{\"id\":2,\"name\":\"Bob\",\"position\":\"Full-Time\",\"salary\":5000.0}]";
        });

        System.out.println("Server running at http://localhost:8080/");
    }
}
