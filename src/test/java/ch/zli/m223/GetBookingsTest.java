package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GetBookingsTest {

    @Test
    public void testGetBookingsAsAdmin() {
       
        var Admintoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InRlc3RAZ21haWwuY29tIiwiZ3JvdXBzIjpbIkFkbWluIl0sImdpdmVuX25hbWUiOjEsImlhdCI6MTY2OTIxMDc4MCwiZXhwIjozODE2Njk0NDI3LCJqdGkiOiIxZTg2YjUyZS03MzhiLTQ4MjEtODJlNC04OGU3ZTQ1N2YzYzEifQ.dCShjAVC3Id4RPdGj0oEWhh6lM6RGk01n990VAwDTWRVi3oJjDUr5mYGHa3S29cF_z0O93s0N-567G8ZYjoalxOPZXxTL7MPajTgJdehEz0PHVHkPK0xIG0POzeusrQFfZQbeDAey4plvcCjW-UvNh53pLfYPhwPKtAP4mvYveN2xi20hgMz21_L9SvQCFV39Xt4aJ0exUcjbawmgh7u13-33s9hlJ2ZveH1OXWlUv-_fsyUsNy-9oUQy-UMr3RqFIkdF5Y7d6mZZX1BgT_yK0BoZWdFmdeu3SJ011c6w740A9b_SMq4jJT0aIsJJhA6yiErlPEaIoRKpZdd2-YbjA";
        given()
          .when().header("Authorization", "Bearer "+ Admintoken).get("/booking").then().statusCode(200);
    }

    @Test
    public void testGetBookingsAsUser() {
       
        var Usertoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InRlc3RAZ21haWwuY29tIiwiZ3JvdXBzIjpbIkFkbWluIl0sImdpdmVuX25hbWUiOjEsImlhdCI6MTY2OTIxMDc4MCwiZXhwIjozODE2Njk0NDI3LCJqdGkiOiIxZTg2YjUyZS03MzhiLTQ4MjEtODJlNC04OGU3ZTQ1N2YzYzEifQ.dCShjAVC3Id4RPdGj0oEWhh6lM6RGk01n990VAwDTWRVi3oJjDUr5mYGHa3S29cF_z0O93s0N-567G8ZYjoalxOPZXxTL7MPajTgJdehEz0PHVHkPK0xIG0POzeusrQFfZQbeDAey4plvcCjW-UvNh53pLfYPhwPKtAP4mvYveN2xi20hgMz21_L9SvQCFV39Xt4aJ0exUcjbawmgh7u13-33s9hlJ2ZveH1OXWlUv-_fsyUsNy-9oUQy-UMr3RqFIkdF5Y7d6mZZX1BgT_yK0BoZWdFmdeu3SJ011c6w740A9b_SMq4jJT0aIsJJhA6yiErlPEaIoRKpZdd2-YbjA";
        given()
          .when().header("Authorization", "Bearer "+ Usertoken).get("/booking").then().statusCode(200);
    }

    @Test
    public void testGetBookingsAsVisitor() {
       
        var Usertoken = "";
        given()
          .when().header("Authorization", "Bearer "+ Usertoken).get("/booking").then().statusCode(401);
    }
    
}
