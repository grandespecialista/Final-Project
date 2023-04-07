package BackEndTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTests {
    static Properties properties = new Properties();
    private static String username;
    private static String password;
    private static String token;
    private static InputStream confFile;
    private static String basicUrl;
    protected static RequestSpecification requestSpecificationPost;
    protected static ResponseSpecification responseSpecificationPost;
    protected static RequestSpecification requestSpecificationGetMy;
    protected static ResponseSpecification responseSpecificationGetMy;
    protected static RequestSpecification requestSpecificationGetNotMy;
    protected static ResponseSpecification responseSpecificationGetNotMy;

    @BeforeAll
    static void initTest() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        confFile = new FileInputStream("src/main/resources/myProperty.property");
        properties.load(confFile);
        token = properties.getProperty("token");
        basicUrl = properties.getProperty("basic_url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

        basicUrl = properties.getProperty("basic_url");

        requestSpecificationPost = new RequestSpecBuilder()
                .setContentType("application/x-www-form-urlencoded; charset-UTF-8")
                .log(LogDetail.HEADERS)
                .build();

        responseSpecificationPost = new ResponseSpecBuilder()
                .expectContentType("text/html")
                .expectResponseTime(Matchers.lessThan(5000L))
                .log(LogDetail.HEADERS)
                .build();

        requestSpecificationGetMy = new RequestSpecBuilder()
                .setContentType("application/x-www-form-urlencoded; charset-UTF-8")
                .addFormParam("sort", "createdAt")
                .addHeader("X-Auth-Token",token)
                .log(LogDetail.HEADERS)
                .build();

        responseSpecificationGetMy = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .expectHeader("Server", "nginx/1.23.1")
                .log(LogDetail.HEADERS)
                .build();

        requestSpecificationGetNotMy = new RequestSpecBuilder()
                .setContentType("application/x-www-form-urlencoded; charset-UTF-8")
                .addFormParam("sort", "createdAt")
                .addFormParam("owner", "notMy")
                .addHeader("X-Auth-Token",token)
                .log(LogDetail.HEADERS)
                .build();

        responseSpecificationGetNotMy = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .log(LogDetail.HEADERS)
                .build();
    }

    public static String getBasicUrl() {
        return basicUrl;
    }
    public RequestSpecification getRequestSpecificationPost(){
        return requestSpecificationPost;
    }
    public ResponseSpecification getResponseSpecificationPost(){
        return responseSpecificationPost;
    }
    public RequestSpecification getRequestSpecificationGetMy(){
        return requestSpecificationGetMy;
    }
    public ResponseSpecification getResponseSpecificationGetMy(){
        return responseSpecificationGetMy;
    }
    public RequestSpecification getRequestSpecificationGetNotMy(){
        return requestSpecificationGetNotMy;
    }
    public ResponseSpecification getResponseSpecificationGetNotMy(){
        return responseSpecificationGetNotMy;
    }
}
