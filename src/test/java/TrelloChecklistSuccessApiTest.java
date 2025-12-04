import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static helper.TestHelper.*;

public class TrelloChecklistSuccessApiTest {

    private static String ID_CREATED_TO_BE_DELETED;

    private RequestSpecification request;

    @BeforeEach
    void setup(){
        request =RestAssured.given();
    }

    @DisplayName("CT01- Create Checklist with success")
    @Test
    void createChecklistWithSuccess(){

        log(Level.INFO, "Iniciando teste: CT01- Create Checklist with success...");

        ID_CREATED_TO_BE_DELETED = post(request);

        log(Level.INFO, "Encerrando teste: CT01- Create Checklist with success...");
    }

    @DisplayName("CT02- Get a Checklist with success")
    @Test
    void getChecklistWithSuccess(){

        log(Level.INFO,"Iniciando teste: CT02- Get a Checklist with success");

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

        log(Level.INFO,"Encerrando teste: CT02- Get a Checklist with success");
    }

    @DisplayName("CT03- Update a Checklist with success")
    @Test
    void UpdateChecklistWithSuccess(){

        log(Level.INFO,"Iniciando teste: CT03- Update a Checklist with success");

        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("key", apiKey())
                .queryParam("token",token())
                .queryParam("name","automação em javascript")
                .when()
                .put()
                .then()
                .statusCode(200);

        log(Level.INFO,"Encerrando teste: CT03- Update a Checklist with success");
    }

    @DisplayName("CT04- Delete a Checklist with success")
    @Test
    void DeleteChecklistWithSuccess(){

        log(Level.INFO,"Iniciando teste: CT04- Update a Checklist with success");

        delete(request,ID_CREATED_TO_BE_DELETED,200);

        log(Level.INFO,"Encerrando teste: CT04- Update a Checklist with success");
    }


}
