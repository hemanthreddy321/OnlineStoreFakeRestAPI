package chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetStudentTest {
    @Test(dependsOnMethods = {"chaining.CreateStudentTest.createStudent"})
    public void getStudent(ITestContext context) {
        String id = (String) context.getAttribute("stu_id"); // getting id value from shared context

        given()
                .pathParam("id", id)
                .when()
                .get("http://localhost:3000/students/{id}")

                .then()
                .statusCode(200)
                .log().all();
    }

}
