package chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudentTest {
    @Test(dependsOnMethods = {"chaining.UpdateStudentTest.updateStudent"})
    public void deleteStudent(ITestContext context) {
        String id = (String) context.getAttribute("stu_id");// getting id value from shared context

        given()
                .pathParam("id", id)
                .when()
                .delete("http://localhost:3000/students/{id}")
                .then()
                .statusCode(200)
                .log().all();

    }

}
