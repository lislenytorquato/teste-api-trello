import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helper.TestHelper.*;

public class TrelloChecklistBadRequestApiTest {


    @DisplayName("CT05- Create Checklist with bad request")
    @Test
    void createChecklistWithBadRequest(){

        RequestSpecification request = RestAssured.given();
        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("key", apiKey())
                .queryParam("token", token())
                .queryParam("name","automação em C#")
                .when()
                .post()
                .then()
                .statusCode(400)
                .extract().response();


    }

    @DisplayName("CT06- Get a Checklist with bad request")
    @Test
    void getChecklistWithBadRequest(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d94")
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .when()
                .get()
                .then()
                .statusCode(400);

    }

    @DisplayName("CT07- Update a Checklist with bad request")
    @Test
    void UpdateChecklistWithBadRequest(){

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d")
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .statusCode(400);

    }

    @DisplayName("CT08- Delete a Checklist with bad request")
    @Test
    void DeleteChecklistWithBadRequest(){

        delete("692de8396d",400);
    }


}
