package system.server;

import system.model.Department;
import com.google.gson.Gson;
import static spark.Spark.*;

import java.util.List;

public class DepartmentApiServer {

    public static void main(String[] args) {
        port(8080);  // Use a different port than employees API if running both

        Gson gson = new Gson();

        // GET /departments
        get("/departments", (req, res) -> {
            res.type("application/json");
            List<Department> departments = Department.getSampleDepartments();
            return gson.toJson(departments);
        });

        System.out.println("Department API running at http://localhost:8080/departments");
    }
}

