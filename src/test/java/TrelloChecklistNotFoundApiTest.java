import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static helper.TestHelper.*;

public class TrelloChecklistNotFoundApiTest {

    @DisplayName("CT16- Create Checklist with idCard not found")
    @Test
    void createChecklistWithIdCardNotFound(){
        log(Level.INFO,"Iniciando teste: CT16- Create Checklist with idCard not found");

        RequestSpecification request = RestAssured.given();
        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("idCard","5abbe4b7ddc1b351ef961414")
                .queryParam("key", apiKey())
                .queryParam("token", token())
                .queryParam("name","automação em C#")
                .when()
                .post()
                .then()
                .statusCode(404)
                .extract().response();

        log(Level.INFO,"Encerrando teste: CT16- Create Checklist with idCard not found");
    }

    @DisplayName("CT17- Get a Checklist with id not found")
    @Test
    void getChecklistWithIdNotFound(){
        log(Level.INFO,"Iniciando teste: CT17- Get a Checklist with id not found");

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("6930324a3a4a718b43fc404c")
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .when()
                .get()
                .then()
                .statusCode(404);

        log(Level.INFO,"Encerrando teste: CT17- Get a Checklist with id not found");
    }

    @DisplayName("CT18- Update a Checklist with id not found")
    @Test
    void UpdateChecklistWithIdNotFound(){
        log(Level.INFO,"Iniciando teste: CT18- Update a Checklist with id not found");

        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("6930324a3a4a718b43fc404c")
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .statusCode(404);

        log(Level.INFO,"Encerrando teste: CT18- Update a Checklist with id not found");
    }

    @DisplayName("CT19- Delete a Checklist with id not found")
    @Test
    void DeleteChecklistWithBadRequest(){
        log(Level.INFO,"Iniciando teste: CT19- Delete a Checklist with id not found");

        delete("6930324a3a4a718b43fc404c",404);

        log(Level.INFO,"Encerrando teste: CT19- Delete a Checklist with id not found");
    }


}
