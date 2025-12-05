import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;
import java.util.logging.Level;

import static helper.TestHelper.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TrelloChecklistBadRequestApiTest {

    private RequestSpecification request;

    @BeforeEach
    void setup(){
        request =RestAssured.given();
    }

    @DisplayName("CT05- Create Checklist with bad request")
    @Test
    void createChecklistWithBadRequest(){

        log(Level.INFO,"Iniciando teste: CT05- Create Checklist with bad request");

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

       validateSchema(response.getContentType(),Level.INFO,"Teste de schema: CT05- Create Checklist with bad request",request, "schema/checklist-schema-id-card-required.json");

        log(Level.INFO,"Encerrando teste: CT05- Create Checklist with bad request");
    }

    @DisplayName("CT06- Get a Checklist with bad request")
    @Test
    void getChecklistWithBadRequest(){

        log(Level.INFO,"Iniciando teste: CT06- Get a Checklist with bad request");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d94")
                .queryParam("key", apiKey())
                .queryParam("token", token())
                .when()
                .get()
                .then()
                .statusCode(400).extract().response();

        validateSchema(response.getContentType(),Level.INFO,"Teste de schema: CT06- Get a Checklist with bad request",request, "schema/checklist-schema-id-required.json");

        log(Level.INFO,"Encerrando teste: CT06- Get a Checklist with bad request");
    }

    @DisplayName("CT07- Update a Checklist with bad request")
    @Test
    void UpdateChecklistWithBadRequest(){

        log(Level.INFO,"Iniciando teste: CT07- Update a Checklist with bad request");

       Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d")
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .statusCode(400).extract().response();

        validateSchema(response.getContentType(),Level.INFO,"Teste de schema: CT07- Update a Checklist with bad request",request,"schema/checklist-schema-id-required.json");

        log(Level.INFO,"Encerrando teste: CT07- Update a Checklist with bad request");
    }

    @DisplayName("CT08- Delete a Checklist with bad request")
    @Test
    void DeleteChecklistWithBadRequest(){

        log(Level.INFO,"Iniciando teste: CT08- Delete a Checklist with bad request");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("692de8396d")
                .queryParam("key", apiKey())
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(400)
                .extract().response();

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT08- Delete a Checklist with bad request",request,"schema/checklist-schema-delete.json");

        log(Level.INFO,"Encerrando teste: CT08- Delete a Checklist with bad request");
    }


}
