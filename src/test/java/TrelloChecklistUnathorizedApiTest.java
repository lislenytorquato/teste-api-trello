import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helper.TestHelper.*;

public class TrelloChecklistUnathorizedApiTest {


    @DisplayName("CT09- Create Checklist with no authorization")
    @Test
    void createChecklistWithNoAthorization(){

        RequestSpecification request = RestAssured.given();
        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("key", apiKey())
                .queryParam("name","automação em C#")
                .when()
                .post()
                .then()
                .statusCode(401)
                .extract().response();


    }

    @DisplayName("CT10- Get a Checklist with no authorization")
    @Test
    void getChecklistWithNoAthorization(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .when()
                .get()
                .then()
                .statusCode(401);

    }

    @DisplayName("CT11- Update a Checklist with no authorization")
    @Test
    void UpdateChecklistWithNoAthorization(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("key", apiKey())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .statusCode(401);

    }

    @DisplayName("CT12- Delete a Checklist with no authorization")
    @Test
    void DeleteChecklistWithNoAthorization(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(401);
    }


}
