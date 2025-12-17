package system.server;

import lombok.extern.slf4j.Slf4j;
import system.model.Department;
import com.google.gson.Gson;
import static spark.Spark.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class DepartmentApiServer {

    // In-memory list to simulate a database
    private static final List<Department> departments = Department.getSampleDepartments();
    private static int nextId = departments.size() + 1;

    public static void main(String[] args) {
        port(8080);

        Gson gson = new Gson();

        // ----------------------
        // GET /departments -> all departments
        // ----------------------
        get("/departments", (req, res) -> {
            res.type("application/json");
            log.info("GET /departments called");
            return gson.toJson(departments);
        });

        // ----------------------
        // GET /departments/:id -> get department by id
        // ----------------------
        get("/departments/:id", (req, res) -> {
            res.type("application/json");
            String id = req.params(":id");
            log.info("GET /departments/{} called", id);

            Optional<Department> deptOpt = departments.stream()
                    .filter(d -> Objects.equals(d.getId(), id))
                    .findFirst();

            if (deptOpt.isPresent()) {
                return gson.toJson(deptOpt.get());
            } else {
                res.status(404);
                return gson.toJson("Department not found");
            }
        });

        // ----------------------
        // POST /departments -> create new department
        // ----------------------
        post("/departments", (req, res) -> {
            res.type("application/json");
            log.info("POST /departments called");
            log.info("Request body: {}", req.body());

            Department dept = gson.fromJson(req.body(), Department.class);
            dept.setId(String.valueOf(nextId++));
            departments.add(dept);

            res.status(201);
            log.info("Created Department: {}", dept);
            return gson.toJson(dept);
        });

        // ----------------------
        // PUT /departments/:id -> update existing department
        // ----------------------
        put("/departments/:id", (req, res) -> {
            res.type("application/json");
            String id = req.params(":id");
            log.info("PUT /departments/{} called", id);

            Department updatedDept = gson.fromJson(req.body(), Department.class);
            Optional<Department> deptOpt = departments.stream()
                    .filter(d -> Objects.equals(d.getId(), id))
                    .findFirst();

            if (deptOpt.isPresent()) {
                Department dept = deptOpt.get();
                dept.setName(updatedDept.getName());
                log.info("Updated Department: {}", dept);
                return gson.toJson(dept);
            } else {
                res.status(404);
                return gson.toJson("Department not found");
            }
        });

        // ----------------------
        // DELETE /departments/:id -> delete department
        // ----------------------
        delete("/departments/:id", (req, res) -> {
            res.type("application/json");
            String id = req.params(":id");
            log.info("DELETE /departments/{} called", id);

            Optional<Department> deptOpt = departments.stream()
                    .filter(d -> Objects.equals(d.getId(), id))
                    .findFirst();

            if (deptOpt.isPresent()) {
                departments.remove(deptOpt.get());
                res.status(204); // No content
                log.info("Deleted Department with id {}", id);
                return "";
            } else {
                res.status(404);
                return gson.toJson("Department not found");
            }
        });

        System.out.println("Department CRUD API running at http://localhost:8080/departments");
    }
}

