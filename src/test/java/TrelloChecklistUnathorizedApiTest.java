import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
        request =RestAssured.given().filter(new AllureRestAssured());
    }

    @DisplayName("CT09- Create Checklist with no authorization")
    @Test
    void createChecklistWithNoAthorization(){
        log(Level.INFO,"Iniciando teste: CT09- Create Checklist with no authorization");

        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("key", apiKey())
                .queryParam("name","automação em C#")
                .when()
                .post()
                .then()
                .statusCode(401)
                .extract().response();

        log(Level.INFO,"Encerrando teste: CT09- Create Checklist with no authorization");
    }

    @DisplayName("CT10- Get a Checklist with no authorization")
    @Test
    void getChecklistWithNoAthorization(){

        log(Level.INFO,"Iniciando teste: CT10- Get a Checklist with no authorization");

        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .when()
                .get()
                .then()
                .statusCode(401);

        log(Level.INFO,"Encerrando teste: CT10- Get a Checklist with no authorization");
    }

    @DisplayName("CT11- Update a Checklist with no authorization")
    @Test
    void UpdateChecklistWithNoAthorization(){

        log(Level.INFO,"Iniciando teste: CT11- Update a Checklist with no authorization");

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
        log(Level.INFO,"Encerrando teste: CT11- Update a Checklist with no authorization");
    }

    @DisplayName("CT12- Delete a Checklist with no authorization")
    @Test
    void DeleteChecklistWithNoAthorization(){

        log(Level.INFO,"Iniciando teste: CT12- Delete a Checklist with no authorization");

        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(ID_CHECKLIST)
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(401);

        log(Level.INFO,"Encerrando teste: CT12- Delete a Checklist with no authorization");
    }


}
