package tests.Images;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RandomImageTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://dog.ceo/api";
        RestAssured.port = 443;
        RestAssured.basePath = "/breeds";
    }

    /**
     * Valida o Status code é retornado ao buscar uma imagem randomica
     */
    @Test
    public void testRandomImageStatusCode() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/image/random")
                .then()
                .statusCode(200);
    }

    /**
     * Valida a estrututra retornada ao buscar uma imagem randomica
     */
    @Test
    public void testRandomImageStructure() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/image/random")
                .then()
                .body("status", equalTo("success"))
                .body("message", notNullValue())
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

    /**
     * Valida se as Urls das imagens randomicas são validas
     */
    @Test
    public void testImageUrlIsValid() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/image/random")
                .then()
                .body("message", matchesRegex("https://.*\\.(jpg|jpeg|png)"));
    }


    /**
     * Valida se a imagem muda busvando randomicamente
     */
    @Test
    public void testImageIsDifferentOnMultipleCalls() {
        String image1 = given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/image/random")
                .then()
                .extract().path("message");

        String image2 = given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/image/random")
                .then()
                .log().all()
                .extract().path("message");

        assert !image1.equals(image2) : "Duas imagens iguais foram retornadas: " + image1;
    }


    /**
     * Valida se tempo de resposta da requisição é de até 2 segundos
     */
    @Test
    public void testResponseTime() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .when()
                .get("/image/random")
                .then()
                .log().all()
                .time(lessThan(2000L)); // até 2 segundos
    }
}

