package BackEndTests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class GET_myPosts extends AbstractTests {

    @Test
    void DESC_MyPosts() {
        given()
                .spec(getRequestSpecificationGetMy())
                .formParam("order", "DESC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetMy())
                .statusCode(200);

    }

    @Test
    void ASC_MyPosts() {
        given()
                .spec(getRequestSpecificationGetMy())
                .formParam("order", "ASC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetMy())
                .statusCode(200);

    }

    @Test
    void DESC_MyPostsNoAuth() {
        given()
                .spec(getRequestSpecificationGetMy())
                .header("X-Auth-Token", "")
                .formParam("order", "DESC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetMy())
                .statusCode(401);

    }

    @Test
    void ASC_MyPostsNoAuth() {
        given()
                .spec(getRequestSpecificationGetMy())
                .header("X-Auth-Token", "")
                .formParam("order", "ASC")
                .formParam("page", 1)
                .when()
                .get(getBasicUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetMy())
                .statusCode(401);
    }

    @Test
    void DESC_MyPostsNegative() {
        given()
                .spec(getRequestSpecificationGetMy())
                .formParam("order", "DESC")
                .formParam("page", -1)
                .when()
                .get(getBasicUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetMy())
                .statusCode(400);

    }

    @Test
    void ASC_MyPostsNegative() {
        given()
                .spec(getRequestSpecificationGetMy())
                .formParam("order", "ASC")
                .formParam("page", -1)
                .when()
                .get(getBasicUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetMy())
                .statusCode(400);

    }
}
