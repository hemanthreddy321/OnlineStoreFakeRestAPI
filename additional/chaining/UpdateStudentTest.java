package chaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateStudentTest {
    //using org.json
    @Test(dependsOnMethods = {"chaining.GetStudentTest.getStudent"})
    public void updateStudent(ITestContext context) {
        JSONObject data = new JSONObject();
        data.put("name", "Scott");
        data.put("location", "Germany"); //update
        data.put("phone", "654321"); //update
        String coursesArr[] = {"C#", "C++"}; //update
        data.put("courses", coursesArr);


        String id = (String) context.getAttribute("stu_id");// getting id value from shared context


        given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(data.toString())

                .when()
                .put("http://localhost:3000/students/{id}")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .log().body();

    }

}
