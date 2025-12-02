import helper.Env;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrelloChecklist400ApiTest {

    private static String trelloToken;
    private static String trelloApiKey;
    private static String id;

    @BeforeAll
    static void setup(){
        trelloApiKey = Env.dotEnvOrSystem("TRELLO_API_KEY");
        trelloToken = Env.dotEnvOrSystem("TRELLO_TOKEN");
    }


    @DisplayName("CT01- Create Checklist with bad request")
    @Test
    void createChecklistWithBadRequest(){

        RequestSpecification request = RestAssured.given();
        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("key", trelloApiKey)
                .queryParam("token", trelloToken)
                .when()
                .post()
                .then()
                .statusCode(400)
                .extract().response();
        

    }

    @DisplayName("CT02- Get a Checklist with bad request")
    @Test
    void getChecklistWithBadRequest(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d94")
                .queryParam("key", trelloApiKey)
                .queryParam("token",trelloToken)
                .when()
                .get()
                .then()
                .statusCode(400);

    }

    @DisplayName("CT03- Update a Checklist with bad request")
    @Test
    void UpdateChecklistWithBadRequest(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d")
                .queryParam("key", trelloApiKey)
                .queryParam("token",trelloToken)
                .when()
                .put()
                .then()
                .statusCode(400);

    }

    @DisplayName("CT04- Delete a Checklist with bad request")
    @Test
    void DeleteChecklistWithBadRequest(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d")
                .queryParam("key", trelloApiKey)
                .queryParam("token",trelloToken)
                .when()
                .delete()
                .then()
                .statusCode(400);

    }


}
