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

public class TrelloChecklistUnathorizedApiTest {

    private RequestSpecification request;

    @BeforeEach
    void setup(){
        request =RestAssured.given();
    }

    @DisplayName("CT09- Create Checklist with no token authorization")
    @Test
    void createChecklistWithNoTokenAthorization(){
        log(Level.INFO,"Iniciando teste: CT09- Create Checklist with no token authorization");

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

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT09- Create Checklist with no token authorization", request, "schema/checklist-schema-id-card-required.json");

        log(Level.INFO,"Encerrando teste: CT09- Create Checklist with no token authorization");
    }

    @DisplayName("CT10- Create Checklist with no key authorization")
    @Test
    void createChecklistWithNoKeyAthorization(){
        log(Level.INFO,"Iniciando teste: CT10- Create Checklist with no key authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("token", token())
                .queryParam("name","automação em C#")
                .when()
                .post()
                .then()
                .statusCode(401)
                .extract().response();

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT10- Create Checklist with no key authorization", request, "schema/checklist-schema-id-card-required.json");

        log(Level.INFO,"Encerrando teste: CT10- Create Checklist with no key authorization");
    }

    @DisplayName("CT11- Create Checklist with no authorization")
    @Test
    void createChecklistWithNoAthorization(){
        log(Level.INFO,"Iniciando teste: CT11- Create Checklist with no authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("name","automação em C#")
                .when()
                .post()
                .then()
                .statusCode(401)
                .extract().response();

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT11- Create Checklist with no authorization", request, "schema/checklist-schema-id-card-required.json");

        log(Level.INFO,"Encerrando teste: CT11- Create Checklist with no authorization");
    }


    @DisplayName("CT12- Get a Checklist with no token authorization")
    @Test
    void getChecklistWithNoTokenAthorization(){

        log(Level.INFO,"Iniciando teste: CT12- Get a Checklist with no token authorization");

        Response response =  request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("key", apiKey())
                .basePath(ID_CHECKLIST)
                .when()
                .get()
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/checklist-schema-id-required.json"))
                .statusCode(401)
                .extract().response();

        log(Level.INFO,"Encerrando teste: CT12- Get a Checklist with no token authorization");
    }

    @DisplayName("CT13- Get a Checklist with no key authorization")
    @Test
    void getChecklistWithNoKeyAthorization(){

        log(Level.INFO,"Iniciando teste: CT13- Get a Checklist with no key authorization");

        Response response =  request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("token", token())
                .basePath(ID_CHECKLIST)
                .when()
                .get()
                .then()
                .statusCode(401)
                .extract().response();

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema:CT13- Get a Checklist with no key authorization", request, "schema/checklist-schema-id-required.json");

        log(Level.INFO,"Encerrando teste: CT13- Get a Checklist with no key authorization");
    }

    @DisplayName("CT14- Get a Checklist with no authorization")
    @Test
    void getChecklistWithNoAthorization(){

        log(Level.INFO,"Iniciando teste: CT14- Get a Checklist with no authorization");

      Response response =  request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .when()
                .get()
                .then()
                .statusCode(401)
              .extract().response();

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT10- Get a Checklist with no authorization", request, "schema/checklist-schema-id-required.json");

        log(Level.INFO,"Encerrando teste: CT14- Get a Checklist with no authorization");
    }

    @DisplayName("CT15- Update a Checklist with no token authorization")
    @Test
    void UpdateChecklistWithNoTokenAthorization(){

        log(Level.INFO,"Iniciando teste: CT15- Update a Checklist with no token authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("key", apiKey())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/checklist-schema-id-required.json"))
                .statusCode(401).extract().response();

        log(Level.INFO,"Encerrando teste: CT15- Update a Checklist with no token authorization");
    }

    @DisplayName("CT16- Update a Checklist with no key authorization")
    @Test
    void UpdateChecklistWithNoKeyAthorization(){

        log(Level.INFO,"Iniciando teste: CT16- Update a Checklist with no key authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("token", token())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .statusCode(401).extract().response();

        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT16- Update a Checklist with no key authorization",request,"schema/checklist-schema-id-required.json");

        log(Level.INFO,"Encerrando teste: CT16- Update a Checklist with no key authorization");
    }

    @DisplayName("CT17- Update a Checklist with no authorization")
    @Test
    void UpdateChecklistWithNoAthorization(){

        log(Level.INFO,"Iniciando teste: CT17- Update a Checklist with no authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/checklist-schema-id-required.json"))
                .statusCode(401).extract().response();

        log(Level.INFO,"Encerrando teste: CT17- Update a Checklist with no authorization");
    }

    @DisplayName("CT18- Delete a Checklist with no token authorization")
    @Test
    void DeleteChecklistWithNoTokenAthorization(){

        log(Level.INFO,"Iniciando teste: CT18- Delete a Checklist with no token authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(401).extract().response();
        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT18- Delete a Checklist with no token authorization", request, "schema/checklist-schema-delete.json");

        log(Level.INFO,"Encerrando teste: CT18- Delete a Checklist with no token authorization");
    }

    @DisplayName("CT19- Delete a Checklist with no key authorization")
    @Test
    void DeleteChecklistWithNoKeyAthorization(){

        log(Level.INFO,"Iniciando teste: CT18- Delete a Checklist with no token authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(401).extract().response();
        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT18- Delete a Checklist with no token authorization", request, "schema/checklist-schema-delete.json");

        log(Level.INFO,"Encerrando teste: CT18- Delete a Checklist with no token authorization");
    }

    @DisplayName("CT20- Delete a Checklist with no authorization")
    @Test
    void DeleteChecklistWithNoAthorization(){

        log(Level.INFO,"Iniciando teste: CT20- Delete a Checklist with no authorization");

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(401).extract().response();
        validateSchema(response.getContentType(), Level.INFO,"Teste de schema: CT12- Delete a Checklist with no authorization", request, "schema/checklist-schema-delete.json");

        log(Level.INFO,"Encerrando teste: CT20- Delete a Checklist with no authorization");
    }


}
