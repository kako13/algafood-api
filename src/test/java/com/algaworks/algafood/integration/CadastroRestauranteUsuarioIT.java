package com.algaworks.algafood.integration;

import com.algaworks.algafood.domain.model.*;
import com.algaworks.algafood.domain.repository.*;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.data.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroRestauranteUsuarioIT {

    public static final int RESTAURANTE_ID_INEXISTENTE = 100;
    public static final String RECURSO_NAO_ENCONTRADO = "Recurso não encontrado";
    @LocalServerPort
    private int port;
    @Autowired
    DatabaseCleaner databaseCleaner;
    @Autowired
    private CozinhaRepository cozinhaRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;
    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PermissaoRepository permissaoRepository;
    private Restaurante restauranteCasaDaFeijoda;
    private Restaurante burgerTopRestaurante;
    private int quantidadeRestaurantesCadastrados;
    private Usuario responsavelNovo;

    @BeforeEach
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/restaurantes/{restauranteId}/responsaveis";

        databaseCleaner.clearTables();

        prepararDados();
    }

    @Test
    void deveRetornar200_QuandoConsultarResponsaveis() {
        given()
                .pathParam("restauranteId", restauranteCasaDaFeijoda.getId())
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .body("", hasSize(quantidadeRestaurantesCadastrados))
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void deveRetornar204_QuandoAssociarResponsavel() {
        given()
                .pathParam("restauranteId", restauranteCasaDaFeijoda.getId())
                .accept(ContentType.JSON)
        .when()
                .put("/{usuarioId}", responsavelNovo.getId())
        .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    void deveRetornar204_QuandoDesassociarResponsavel() {
        Usuario responsavelCasaDaFeijoada = restauranteCasaDaFeijoda.getResponsaveis().stream().findFirst().get();
        given()
                .pathParam("restauranteId", restauranteCasaDaFeijoda.getId())
                .accept(ContentType.JSON)
        .when()
                .delete("/{usuarioId}", responsavelCasaDaFeijoada.getId())
        .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    void deveRetornar400_QuandoAssociarRestauranteInexistente() {
        Usuario responsavelCasaDaFeijoada = restauranteCasaDaFeijoda.getResponsaveis().stream().findFirst().get();
        given()
                .pathParam("restauranteId", RESTAURANTE_ID_INEXISTENTE)
                .accept(ContentType.JSON)
        .when()
                .delete("/{usuarioId}", responsavelCasaDaFeijoada.getId())
        .then()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("title", equalTo(RECURSO_NAO_ENCONTRADO))
                .body("userMessage", equalTo("Não existe cadastro de restaurante com o código "+RESTAURANTE_ID_INEXISTENTE));
    }

    @Test
    void deveRetornar400_QuandoAssociarUsuarioInexistente() {
        Usuario responsavelCasaDaFeijoada = restauranteCasaDaFeijoda.getResponsaveis().stream().findFirst().get();
        given()
                .pathParam("restauranteId", RESTAURANTE_ID_INEXISTENTE)
                .accept(ContentType.JSON)
        .when()
                .delete("/{usuarioId}", responsavelNovo.getId())
        .then()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("title", equalTo(RECURSO_NAO_ENCONTRADO))
                .body("userMessage", equalTo("Não existe cadastro de restaurante com o código "+RESTAURANTE_ID_INEXISTENTE));
    }

    private void prepararDados() {
        Cozinha cozinhaBrasileira = CozinhaTestData
                .umaCozinhaNova()
                .build();
        cozinhaRepository.save(cozinhaBrasileira);
        Cozinha cozinhaAmericada = CozinhaTestData
                .umaCozinhaNova()
                .nome("Americada")
                .build();
        cozinhaRepository.save(cozinhaAmericada);
        Estado estadoSaoPaulo = EstadoTestData
                .umEstadoNovo()
                .build();
        estadoRepository.save(estadoSaoPaulo);
        Cidade cidadeBarueri = CidadeTestData
                .umaCidadeNova()
                .estado(estadoSaoPaulo)
                .build();
        cidadeRepository.save(cidadeBarueri);
        FormaPagamento credito = FormaPagamentoTestData
                .umaFormaPagamentoNova()
                .build();
        formaPagamentoRepository.save(credito);
        Permissao permissaoTotal = PermissaoTestData
                .umaPermissaoExistente()
                .build();
        permissaoRepository.save(permissaoTotal);
        Grupo grupoDev = GruposTestData
                .umGrupoNovo()
                .permissoes(Set.of(permissaoTotal))
                .build();
        grupoRepository.save(grupoDev);
        responsavelNovo = UsuarioTestData.umUsuarioNovo()
                .grupos(Set.of(grupoDev))
                .build();
        usuarioRepository.save(responsavelNovo);
        Usuario responsavel = UsuarioTestData.umUsuarioNovo()
                .grupos(Set.of(grupoDev))
                .build();
        usuarioRepository.save(responsavel);
        restauranteCasaDaFeijoda = RestauranteTestData
                .umRestauranteNovo()
                .endereco(EnderecoTestData
                        .umEndereco()
                        .cidade(cidadeBarueri)
                        .build())
                .cozinha(cozinhaBrasileira)
                .formasPagamento(Set.of(credito))
                .responsaveis(Set.of(responsavel))
                .build();
        restauranteRepository.save(restauranteCasaDaFeijoda);
        quantidadeRestaurantesCadastrados = (int) restauranteRepository.count();
    }
}

