package helper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestHelper {

    public static final String ID_CARD = "692de5425e1d0b3952027429";
    public static final String ID_CHECKLIST = "692de8396d94e4cc2c66ae31";
    public static Logger logger = Logger.getLogger(TestHelper.class.getName());
    private static final Handler consoleHandler = new ConsoleHandler();

        public static String apiKey(){
            return Env.dotEnvOrSystem("TRELLO_API_KEY");
        }

        public static String token(){
            return Env.dotEnvOrSystem("TRELLO_TOKEN");
        }

        public static String post(RequestSpecification request){

        Response response = request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .queryParam("idCard", ID_CARD)
                .queryParam("key", apiKey())
                .queryParam("token", token())
                .queryParam("name","automação em java")
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        return response.getBody().jsonPath().getString("id");
    }

    public static void delete(RequestSpecification request, String id,int statusCode){


        request
                .contentType(ContentType.JSON)
                .baseUri("https://api.trello.com/1/checklists?")
                .basePath(id)
                .queryParam("key", apiKey())
                .queryParam("token", token())
                .when()
                .delete()
                .then()
                .statusCode(statusCode);
    }

    public static void log(Level level, String msg){

       consoleHandler.setLevel(level);
       logger.addHandler(consoleHandler);
       logger.info(msg);

    }
}
