import helper.TestHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helper.TestHelper.*;
import static helper.TestHelper.token;

public class TrelloChecklistSuccessApiTest {

    private static String ID_CREATED_TO_BE_DELETED;

    @DisplayName("CT01- Create Checklist with success")
    @Test
    void createChecklistWithSuccess(){

      ID_CREATED_TO_BE_DELETED = post();

    }

    @DisplayName("CT02- Get a Checklist with success")
    @Test
    void getChecklistWithSuccess(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .when()
                .get()
                .then()
                .statusCode(200);

    }

    @DisplayName("CT03- Update a Checklist with success")
    @Test
    void UpdateChecklistWithSuccess(){

        delete(ID_CREATED_TO_BE_DELETED,200);

    }

    @DisplayName("CT04- Delete a Checklist with success")
    @Test
    void DeleteChecklistWithSuccess(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CREATED_TO_BE_DELETED)
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .when()
                .delete()
                .then()
                .statusCode(200);

    }


}
