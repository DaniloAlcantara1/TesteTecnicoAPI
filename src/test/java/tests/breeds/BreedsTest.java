package tests.breeds;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BreedsTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://dog.ceo/api";
        RestAssured.port = 443;
        RestAssured.basePath = "/breeds";
    }

//

    /**
     * valida se o status code ao listar todos é 200 com sucesso e se a lista nã esta vazia
     */
    @Test
    public void testStatusCodeIs200() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/list/all")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", notNullValue())
                .log().all();
    }

    /**
     * valida se a estrutura retornada corretamente
     */
    @Test
    public void testResponseStructure() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/list/all")
                .then()
                .body("status", equalTo("success"))
                .body("message", notNullValue())
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();

    }

    /**
     * valida se a lista possui raças conhecidas
     */
    @Test
    public void testBreedListContainsKnownBreeds() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/list/all")
                .then()
                .body("message.bulldog", notNullValue())
                .body("message.retriever", notNullValue())
                .log().all();
    }

    /**
     * valida se o tempo de resposta da requisição é de até 2 segundos
     */
    @Test
    public void testResponseTime() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/list/all")
                .then()
                .time(lessThan(2000L))
                .log().all(); // tempo máximo de 2 segundos
    }


}
