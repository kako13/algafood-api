package com.algaworks.algafood.integration;

import com.algaworks.algafood.api.model.input.CozinhaInput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;
import com.algaworks.algafood.util.data.CozinhaTestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {

    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private static final int COZINHA_ID_INEXISTENTE = 100;
    private Cozinha cozinhaBrasileira;
    private int quantidadeCozinhasCadastradas;
    private String jsonCorretoCozinhaChinesa;

    @BeforeEach
    void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";
        jsonCorretoCozinhaChinesa = ResourceUtils.getContentFromResource("/json/correto/cozinha-chinesa.json");

        databaseCleaner.clearTables();
        prepararDados();
    }

    @Test
    void deveRetornarStatus200_QuandoConsultarCozinhas() {

        given()
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void deveRetornarStatus201_QuandoCadastrarCozinha () {
        given()
                .body(jsonCorretoCozinhaChinesa)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
        .when()
                .post()
        .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void deveRetornarStatus200EResponseModel_QuandoConsultarCozinhaExistente() {
        given()
                .pathParams("cozinhaId", cozinhaBrasileira.getId())
                .accept(ContentType.JSON)
        .when()
                .get("/{cozinhaId}")
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("nome", equalTo(cozinhaBrasileira.getNome()));
    }

    @Test
    void deveRetornarStatus200ECozinhaModel_QuandoAlterarUmaCozinhaExistente() throws JsonProcessingException {
        CozinhaInput cozinhaInput = objectMapper.readValue(jsonCorretoCozinhaChinesa, CozinhaInput.class);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonCorretoCozinhaChinesa)
                .pathParams("cozinhaId", cozinhaBrasileira.getId())
        .when()
                .put("/{cozinhaId}")
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("nome", equalTo(cozinhaInput.getNome()))
        ;
    }

    @Test
    void deveRetornarStatus204SemResponseBody_QuandoInativarUmRestaurante() {
        Long cozinhaBrasileiraId = cozinhaBrasileira.getId();
        Response response =
                given()
                        .pathParam("cozinhaId", cozinhaBrasileiraId)
                        .accept(ContentType.JSON)
                .when()
                        .delete("/{cozinhaId}");

        Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaBrasileiraId);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT.value());
        Assertions.assertThat(cozinha.orElse(null)).isNull();
    }

    @Test
    void deveRetornarQuantidadeCorretaDeCozinhas_QuandoConsultarCozinhas() {

        given()
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .body("", hasSize(quantidadeCozinhasCadastradas));
    }

    @Test
    void deveRetornarStatus404_QuandoConsultarCozinhaInexistente() {
        given()
                .pathParams("cozinhaId", COZINHA_ID_INEXISTENTE)
                .accept(ContentType.JSON)
        .when()
                .get("/{cozinhaId}")
        .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    private void prepararDados() {
        cozinhaBrasileira = CozinhaTestData.umaCozinhaNova().build();
        cozinhaRepository.save(cozinhaBrasileira);
        quantidadeCozinhasCadastradas = (int) cozinhaRepository.count();
    }
}
