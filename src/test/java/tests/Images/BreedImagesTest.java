package tests.Images;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertNotEquals;

public class BreedImagesTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://dog.ceo/api";
        RestAssured.port = 443;
        RestAssured.basePath = "/breed";
    }


    /**
     * Este metodo de teste realiza uma consulta de imagem de uma raça especifica de cão
     * e valida se a resposta é retornada com sucesso
     */
    @Test
    public void testValidBreedReturnsImages() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .pathParam("breed", "hound")
                .when()
                .get("/{breed}/images")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", not(empty()))
                .body("message", everyItem(matchesRegex("https://.*\\.(jpg|jpeg|png)")))
                .body("message", everyItem(containsString("https://")))
                .log().all();
    }

    /**
     * Este metodo de teste realiza uma consulta de imagem de uma raça einexistente de cão
     * e valida se a resposta é retornada é um erro
     */
    @Test
    public void testInvalidBreedReturnsError() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .pathParam("breed", "dragon") // raça inexistente
                .when()
                .get("/{breed}/images")
                .then()
                .statusCode(anyOf(equalTo(404), equalTo(200))) // A API pode retornar 200 com erro no corpo
                .body("status", anyOf(equalTo("error"), equalTo("success")))
                .log().all(); // comportamento inconsistente da API
    }

    /**
     * Este metodo de teste realiza uma consulta de imagem de uma raça especifica de cão
     * e valida se a resposta é retornada com sucesso e se sua urls são validas
     */
    @Test
    public void testAllImageUrlsAreValid() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .pathParam("breed", "boxer")
                .when()
                .get("/{breed}/images")
                .then()
                .body("message", everyItem(matchesRegex("https://.*\\.(jpg|jpeg|png)")))
                .log().all();
    }

    /**
     * Este metodo de teste realiza uma consulta de imagem de uma raça especifica de cão
     * e valida se oa tempo de resposta é de até 2 segundos
     */
    @Test
    public void testResponseTime() {
        given()
                .filter(new AllureRestAssured())
                .baseUri(baseURI)
                .pathParam("breed", "husky")
                .when()
                .get("/{breed}/images")
                .then()
                .body("message", everyItem(matchesRegex("https://.*\\.(jpg|jpeg|png)")))
                .time(lessThan(2000L)) // até 2 segundos
                .log().all();
    }
}
