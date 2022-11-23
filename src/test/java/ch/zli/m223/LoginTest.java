
package ch.zli.m223;
import io.quarkus.test.junit.QuarkusTest;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import ch.zli.m223.model.ApplicationUser;
import javax.inject.Inject;
import io.restassured.http.ContentType;

@QuarkusTest
public class LoginTest {

    @Inject
    JsonWebToken jwt;


    @Test
    public void testUserLogin() {
        ApplicationUser user = new ApplicationUser();
        user.setEmail("test@example.com");
        user.setFirstname("testUser");
        user.setLastname("testedUser");
        user.setPassword("test123");
        user.setAdmin(false);

        var response = given().when().contentType(ContentType.JSON).body(user).post("/user/login");
        response.body().asString();
    }

    @Test
    public void testAdminLogin() {
        ApplicationUser admin = new ApplicationUser();
        admin.setEmail("admin@example.com");
        admin.setFirstname("adminUser");
        admin.setLastname("Admin");
        admin.setPassword("test123");
        admin.setAdmin(true);
    
        given()
          .when().contentType(ContentType.JSON).body(admin).post("/user/login").then().statusCode(200);
    }
}
