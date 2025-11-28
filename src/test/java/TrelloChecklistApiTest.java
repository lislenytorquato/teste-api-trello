import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrelloChecklistApiTest {




    @DisplayName("CT01- Create Checklist with success")
    @Test
    void createChecklistWithSuccess(){

        Dotenv dotenv = Dotenv.load();
        String trelloApiKey = dotenv.get("TRELLO_API_KEY");
        String trelloToken = dotenv.get("TRELLO_TOKEN");


        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists")
                .queryParam("idCard", "5abbe4b7ddc1b351ef961414")
                .queryParam("key",trelloApiKey)
                .queryParam("token",trelloToken)
                .when()
                .post()
                .then()
                .statusCode(200);

    }
}
