package BackEndTests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class POST_LoginTests extends AbstractTests{
    @Test
    void POST_validUser3() {
        given()
                .body("{\n"
                        + " \"username\": bug,\n"
                        + " \"password\":ae0e4bdad7,\n"
                        + "}")
                .contentType(ContentType.JSON)

                .when()
                .post(getBasicUrl() + "login")
                .then()
                .statusCode(200)
                .body(containsString("token"))
                .contentType("text/html");
    }
    @Test
    void POST_validUser20()    {
        given()
                .queryParam("username", "bugmanbugmanbugman20")
                .queryParam("password", "d0b85ec0bb")
                .contentType("application/x-www-form-urlencoded; charset-UTF-8")
                .when()
                .post(getBasicUrl() + "login")
                .then()
                .statusCode(200)
                .body(containsString("token"))
                .contentType("text/html");
    }

    @Test
    void POST_noUsername() {
// empty username field
        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "")
                .queryParam("password", "d0b85ec0bb")
                .when()
                .post(getBasicUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                .statusCode(401);
    }
    @Test
    void POST_noPassword(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "bugmanbugmanbugman20")
                .queryParam("password", "")
                .when()
                .post(getBasicUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                .statusCode(401);
    }

    @Test
    void POST_noUserNoPassword(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "")
                .queryParam("password", "")
                .when()
                .post(getBasicUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                .statusCode(401);
    }

    @Test
    void POST_invalidUser21(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "bugmanbugmanbugman211")
                .queryParam("password", "3e19aaeef0")
                .when()
                .post(getBasicUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                .statusCode(401);

    }

    @Test
    void POST_invalidUser2(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "bu")
                .queryParam("password", "97bf9c5c97")
                .when()
                .post(getBasicUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                .statusCode(401);

    }

    @Test
    void POST_invalidUserWithChar() {

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "bu>")
                .queryParam("password", "5b59ab12d7")
                .when()
                .post(getBasicUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                .statusCode(401);
    }
}
