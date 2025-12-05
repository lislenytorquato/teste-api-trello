import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static helper.TestHelper.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TrelloChecklistNotFoundApiTest {

    private RequestSpecification request;

    @BeforeEach
    void setup(){
       request =RestAssured.given();
    }

    @DisplayName("CT21- Create Checklist with idCard not found")
    @Test
    void createChecklistWithIdCardNotFound(){
        log(Level.INFO,"Iniciando teste: CT21- Create Checklist with idCard not found");

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

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT21- Create Checklist with idCard not found", request, "schema/checklist-schema-id-card-required.json");

        log(Level.INFO,"Encerrando teste: CT21- Create Checklist with idCard not found");
    }

    @DisplayName("CT22- Get a Checklist with id not found")
    @Test
    void getChecklistWithIdNotFound(){
        log(Level.INFO,"Iniciando teste: CT17- Get a Checklist with id not found");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("6930324a3a4a718b43fc404c")
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .when()
                .get()
                .then()
                .statusCode(404)
                .extract().response();

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT17- Get a Checklist with id not found", request, "schema/checklist-schema-id-required.json");

        log(Level.INFO,"Encerrando teste: CT17- Get a Checklist with id not found");
    }

    @DisplayName("CT23- Update a Checklist with id not found")
    @Test
    void UpdateChecklistWithIdNotFound(){
        log(Level.INFO,"Iniciando teste: CT18- Update a Checklist with id not found");

       Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("6930324a3a4a718b43fc404c")
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .statusCode(404)
                .extract().response();
       validateSchema(response.getContentType(), Level.INFO, "Teste de schema: CT18- Update a Checklist with id not found", request, "schema/checklist-schema-id-required.json");

       log(Level.INFO,"Encerrando teste: CT18- Update a Checklist with id not found");
    }

    @DisplayName("CT24- Delete a Checklist with id not found")
    @Test
    void DeleteChecklistWithIdNotFound(){
        log(Level.INFO,"Iniciando teste: CT19- Delete a Checklist with id not found");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath("6930324a3a4a718b43fc404c")
                .queryParam("key", apiKey())
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(404)
                .extract().response();

        validateSchema(response.getContentType(),Level.INFO,"Teste de schema: CT19- Delete a Checklist with id not found",request,"schema/checklist-schema-delete.json");

        log(Level.INFO,"Encerrando teste: CT19- Delete a Checklist with id not found");
    }


}
