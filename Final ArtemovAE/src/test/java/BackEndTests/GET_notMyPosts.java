package BackEndTests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class GET_notMyPosts extends AbstractTests {
    @Test
    void DESC_notMyPosts() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "DESC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(200);

    }

    @Test
    void ASC_notMyPosts() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "ASC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(200);

    }

    @Test
    void DESC_notMyPostsNoAuth() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .header("X-Auth-Token", "")
                .formParam("order", "DESC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(401);

    }

    @Test
    void ASC_notMyPostsNoAuth() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .header("X-Auth-Token", "")
                .formParam("order", "ASC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(401);
    }

    @Test
    void DESC_notMyPostsNegative() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "DESC")
                .formParam("page", -1)
                .when()
                .get(getBasicUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(400);

    }

    @Test
    void ASC_notMyPostsNegative() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "ASC")
                .formParam("page", -1)
                .when()
                .get(getBasicUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(400);

    }
}
