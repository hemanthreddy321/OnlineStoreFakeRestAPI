package chaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateStudentTest {
    //Post request body creation using using Org.JSON
    @Test
    public void createStudent(ITestContext context) {
        JSONObject data = new JSONObject();
        data.put("name", "Scott");
        data.put("location", "France");
        data.put("phone", "123456");
        String coursesArr[] = {"C", "C++"};
        data.put("courses", coursesArr);


        String id = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("http://localhost:3000/students")
                .jsonPath().getString("id");


        context.setAttribute("stu_id", id); // adding id to context


    }
}