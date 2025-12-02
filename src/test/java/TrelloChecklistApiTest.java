import helper.Env;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrelloChecklistApiTest {

    private static String trelloToken;
    private static String trelloApiKey;
    private static String id;

    @BeforeAll
    static void setup(){
        trelloApiKey = Env.dotEnvOrSystem("TRELLO_API_KEY");
        trelloToken = Env.dotEnvOrSystem("TRELLO_TOKEN");
    }


    @DisplayName("CT01- Create Checklist with success")
    @Test
    void createChecklistWithSuccess(){

        RequestSpecification request = RestAssured.given();
        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("idCard", "692de5425e1d0b3952027429")
                .queryParam("key", trelloApiKey)
                .queryParam("token", trelloToken)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        id = response.getBody().jsonPath().getString("id");

    }

    @DisplayName("CT02- Get a Checklist with success")
    @Test
    void getChecklistWithSuccess(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d94e4cc2c66ae31")
                .queryParam("key", trelloApiKey)
                .queryParam("token",trelloToken)
                .when()
                .get()
                .then()
                .statusCode(200);

    }

    @DisplayName("CT03- Update a Checklist with success")
    @Test
    void UpdateChecklistWithSuccess(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d94e4cc2c66ae31")
                .queryParam("key", trelloApiKey)
                .queryParam("token",trelloToken)
                .when()
                .put()
                .then()
                .statusCode(200);

    }

    @DisplayName("CT04- Delete a Checklist with success")
    @Test
    void DeleteChecklistWithSuccess(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(id)
                .queryParam("key", trelloApiKey)
                .queryParam("token",trelloToken)
                .when()
                .delete()
                .then()
                .statusCode(200);

    }


}
