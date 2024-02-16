package com.algaworks.algafood.integration;

import com.algaworks.algafood.api.model.RestauranteModel;
import com.algaworks.algafood.api.model.input.RestauranteInput;
import com.algaworks.algafood.domain.model.*;
import com.algaworks.algafood.domain.repository.*;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;
import com.algaworks.algafood.util.data.*;
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

import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroRestauranteIT {

    public static final int RESTAURANTE_ID_INEXISTENTE = 100;
    public static final String DADOS_INVALIDOS_PROBLEM_TITLE = "Dados inválidos";
    public static final String VIOLACAO_DE_REGRA_DE_NEGOCIO_PROBLEM_TYPE = "Violação de regra de negócio";
    public static final String CAMPOS_INVALIDOS_PROBLEM_USER_MSG = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";
    @LocalServerPort
    private int port;
    @Autowired
    private DatabaseCleaner databaseCleaner;
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

    @Autowired
    private ObjectMapper objectMapper;

    private int quantidadeRestaurantesCadastrados;
    private String jsonCorretoRestauranteCasaDaPamonha;
    private String jsonRestauranteSemFrete;
    private String jsonRestauranteSemCozinha;
    private String jsonRestauranteComCozinhaInexistente;
    private String jsonCorretoRestauranteCasaDoPaoDeQueijo;
    private Restaurante restauranteCasaDaFeijoda;
    private Estado estadoSP;
    private Cidade cidadeBarueri;
    private Restaurante burgerTopRestaurante;

    @BeforeEach
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/restaurantes";

        jsonCorretoRestauranteCasaDaPamonha = ResourceUtils.getContentFromResource(
                "/json/correto/restaurante-rancho-da-pamonha.json");
        jsonCorretoRestauranteCasaDoPaoDeQueijo = ResourceUtils.getContentFromResource(
                "/json/correto/restaurante-casa-do-pao-de-queijo.json");
        jsonRestauranteSemFrete = ResourceUtils.getContentFromResource(
                "/json/incorreto/restaurante-rancho-da-pamonha-sem-frete.json");
        jsonRestauranteSemCozinha = ResourceUtils.getContentFromResource(
                "/json/incorreto/restaurante-rancho-da-pamonha-sem-cozinha.json");
        jsonRestauranteComCozinhaInexistente = ResourceUtils.getContentFromResource(
                "/json/incorreto/restaurante-rancho-da-pamonha-com-cozinha-inexistente.json");

        databaseCleaner.clearTables();
        prepararDados();
    }

    @Test
    void deveRetornarCodigo200_QuandoListarRestaurantes() {
        given()
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("", notNullValue());
    }

    @Test
    void deveRetornarStatus201ERestauranteModel_QuandoCadastrarRestaurante() throws JsonProcessingException {
        RestauranteInput restauranteInput = objectMapper.readValue(jsonCorretoRestauranteCasaDaPamonha, RestauranteInput.class);
        given()
                .body(jsonCorretoRestauranteCasaDaPamonha)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
        .when()
                .post()
        .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("nome", equalTo(restauranteInput.getNome()))
                .body("taxaFrete", equalTo(restauranteInput.getTaxaFrete().setScale(2, RoundingMode.HALF_UP).floatValue()))
                .body("cozinha.id", equalTo(restauranteInput.getCozinha().getId().intValue()))
                .body("ativo", equalTo(Boolean.TRUE))
                .body("aberto", equalTo(Boolean.FALSE))
                .body("endereco.cep", equalTo(restauranteInput.getEndereco().getCep()))
                .body("endereco.logradouro", equalTo(restauranteInput.getEndereco().getLogradouro()))
                .body("endereco.numero", equalTo(restauranteInput.getEndereco().getNumero()))
                .body("endereco.complemento", equalTo(restauranteInput.getEndereco().getComplemento()))
                .body("endereco.bairro", equalTo(restauranteInput.getEndereco().getBairro()))
                .body("endereco.cidade.id", equalTo(restauranteInput.getEndereco().getCidade().getId().intValue()))
        ;
    }

    @Test
    void deveRetornarStatus200ERestauranteModel_QuandoConsultarUmRestauranteExistente() {
        given()
                .pathParams("restauranteId", restauranteCasaDaFeijoda.getId())
                .accept(ContentType.JSON)
        .when()
                .get("/{restauranteId}")
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", equalTo(restauranteCasaDaFeijoda.getId().intValue()))
                .body("nome", equalTo(restauranteCasaDaFeijoda.getNome()))
                .body("taxaFrete", equalTo(restauranteCasaDaFeijoda.getTaxaFrete().floatValue()))
                .body("cozinha.id", equalTo(restauranteCasaDaFeijoda.getCozinha().getId().intValue()))
                .body("cozinha.nome", equalTo(restauranteCasaDaFeijoda.getCozinha().getNome()))
                .body("ativo", equalTo(restauranteCasaDaFeijoda.getAtivo()))
                .body("aberto", equalTo(restauranteCasaDaFeijoda.getAberto()))
                .body("endereco.cep", equalTo(restauranteCasaDaFeijoda.getEndereco().getCep()))
                .body("endereco.logradouro", equalTo(restauranteCasaDaFeijoda.getEndereco().getLogradouro()))
                .body("endereco.numero", equalTo(restauranteCasaDaFeijoda.getEndereco().getNumero()))
                .body("endereco.complemento", equalTo(restauranteCasaDaFeijoda.getEndereco().getComplemento()))
                .body("endereco.bairro", equalTo(restauranteCasaDaFeijoda.getEndereco().getBairro()))
                .body("endereco.cidade.id", equalTo(restauranteCasaDaFeijoda.getEndereco().getCidade().getId().intValue()))
                .body("endereco.cidade.nome", equalTo(restauranteCasaDaFeijoda.getEndereco().getCidade().getNome()))
                .body("endereco.cidade.estado", equalTo(restauranteCasaDaFeijoda.getEndereco().getCidade().getEstado().getNome()))
        ;
    }

    @Test
    void deveRetornarStatus200ERestauranteModel_QuandoAlterarUmRestauranteExistente() throws JsonProcessingException {
        RestauranteInput restauranteInput = objectMapper.readValue(jsonCorretoRestauranteCasaDoPaoDeQueijo, RestauranteInput.class);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonCorretoRestauranteCasaDoPaoDeQueijo)
                .pathParams("restauranteId", restauranteCasaDaFeijoda.getId())
        .when()
                .put("/{restauranteId}")
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("nome", equalTo(restauranteInput.getNome()))
                .body("taxaFrete", equalTo(restauranteInput.getTaxaFrete().setScale(2, RoundingMode.HALF_UP).floatValue()))
                .body("cozinha.id", equalTo(restauranteInput.getCozinha().getId().intValue()))
                .body("ativo", equalTo(Boolean.FALSE))
                .body("aberto", equalTo(Boolean.FALSE))
                .body("endereco.cep", equalTo(restauranteInput.getEndereco().getCep()))
                .body("endereco.logradouro", equalTo(restauranteInput.getEndereco().getLogradouro()))
                .body("endereco.numero", equalTo(restauranteInput.getEndereco().getNumero()))
                .body("endereco.complemento", equalTo(restauranteInput.getEndereco().getComplemento()))
                .body("endereco.bairro", equalTo(restauranteInput.getEndereco().getBairro()))
                .body("endereco.cidade.id", equalTo(restauranteInput.getEndereco().getCidade().getId().intValue()))
        ;
    }

    @Test
    void deveRetornarStatus200EProjecaoApenasNome_QuandoPassarProjecapPorRequestParam() {
        Response response =
                given()
                        .param("projecao","apenas-nome")
                        .accept(ContentType.JSON)
                .when()
                        .get();

        response.jsonPath().prettyPrint();
        assertEquals(response.getStatusCode(), HttpStatus.OK.value());

        List<RestauranteModel> restaurantes = response.jsonPath().getList("$", RestauranteModel.class);
        assertEquals(2, restaurantes.size());

        RestauranteModel restauranteCasaDaFeijoada = restaurantes.get(0);
        assertEquals("Casa da Feijoada", restauranteCasaDaFeijoada.getNome());
        assertEquals(1L, restauranteCasaDaFeijoada.getId());

        RestauranteModel restauranteBurguerTop = restaurantes.get(1);
        assertEquals("Burger Top", restauranteBurguerTop.getNome());
        assertEquals(2L, restauranteBurguerTop.getId());

        Assertions.assertThat(restauranteCasaDaFeijoada).hasAllNullFieldsOrPropertiesExcept("id", "nome");
    }

    @Test
    void deveRetornarStatus204SemResponseBody_QuandoAtivarUmRestaurante() {
        Long restauranteId = restauranteCasaDaFeijoda.getId();
        Response response =
                given()
                        .pathParam("restauranteId", restauranteId)
                        .accept(ContentType.JSON)
                .when()
                        .put("/{restauranteId}/ativo");

        Optional<Restaurante> restauranteAtivado = restauranteRepository.findById(restauranteId);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT.value());
        assertEquals(Boolean.TRUE, restauranteAtivado.get().getAtivo());
    }

    @Test
    void deveRetornarStatus204SemResponseBody_QuandoAtivarListaDeRestaurantes() {
        Long restauranteId = restauranteCasaDaFeijoda.getId();
        Response response =
                given()
                        .body(List.of(1L,2L))
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                .when()
                        .put("/ativacoes");

        restauranteRepository.findAll()
                .forEach(e -> assertEquals(Boolean.TRUE, e.getAtivo()));
    }

    @Test
    void deveRetornarStatus204SemResponseBody_QuandoInativarUmRestaurante() {
        Long restauranteId = burgerTopRestaurante.getId();
        Response response =
                given()
                        .pathParam("restauranteId", restauranteId)
                        .accept(ContentType.JSON)
                .when()
                        .delete("/{restauranteId}/ativo");

        Optional<Restaurante> restauranteAtivado = restauranteRepository.findById(restauranteId);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT.value());
        assertEquals(Boolean.FALSE, restauranteAtivado.get().getAtivo());
    }

    @Test
    void deveRetornarStatus204SemResponseBody_QuandoInativarListaDeRestaurantes() {
        Long restauranteId = restauranteCasaDaFeijoda.getId();
        Response response =
                given()
                        .body(List.of(1L,2L))
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .delete("/ativacoes");

        restauranteRepository.findAll()
                .forEach(e -> assertEquals(Boolean.FALSE, e.getAtivo()));
    }

    @Test
    void deveRetornarStatus204SemResponseBody_QuandoAbrirUmRestaurante() {

        Long restauranteId = burgerTopRestaurante.getId();
        Response response =
                given()
                        .pathParam("restauranteId", restauranteId)
                        .accept(ContentType.JSON)
                .when()
                        .put("/{restauranteId}/abertura");

        Optional<Restaurante> restauranteAtivado = restauranteRepository.findById(restauranteId);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT.value());
        assertEquals(Boolean.TRUE, restauranteAtivado.get().getAberto());
    }

    @Test
    void deveRetornarStatus204SemResponseBody_QuandoFecharUmRestaurante() {
        Long restauranteId = burgerTopRestaurante.getId();
        Response response =
                given()
                        .pathParam("restauranteId", restauranteId)
                        .accept(ContentType.JSON)
                .when()
                        .put("/{restauranteId}/fechamento");

        Optional<Restaurante> restauranteAtivado = restauranteRepository.findById(restauranteId);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT.value());
        assertEquals(Boolean.FALSE, restauranteAtivado.get().getAberto());
    }

    @Test
    void deveRetornarQuantidadeCorretaDeRestaurantes_QuandoConsultarRestaurantes() {
        given()
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .body("", hasSize(quantidadeRestaurantesCadastrados))
                .body("nome", hasItem(restauranteCasaDaFeijoda.getNome()));
    }

    @Test
    void deveRetornarStatus400_QuandoCadastrarRestauranteSemTaxaFrete() {
        given()
                .body(jsonRestauranteSemFrete)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
        .when()
                .post()
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("title", equalTo(DADOS_INVALIDOS_PROBLEM_TITLE))
                .body("userMessage", equalTo(CAMPOS_INVALIDOS_PROBLEM_USER_MSG));
    }

    @Test
    void deveRetornarStatus400_QuandoCadastrarRestauranteSemCozinha() {
        given()
                .body(jsonRestauranteSemCozinha)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
        .when()
                .post()
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("title", equalTo(DADOS_INVALIDOS_PROBLEM_TITLE))
                .body("userMessage", equalTo(CAMPOS_INVALIDOS_PROBLEM_USER_MSG));
    }

    @Test
    void deveRetornarStatus400_QuandoCadastrarRestauranteComCozinhaInexistente() {
        given()
                .body(jsonRestauranteComCozinhaInexistente)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
        .when()
                .post()
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("title", equalTo(VIOLACAO_DE_REGRA_DE_NEGOCIO_PROBLEM_TYPE))
                .body("userMessage", equalTo("Não existe um cadastro de cozinha com o código '100'"));
    }

    @Test
    void deveRetornarStatus404_QuandoConsultarRestauranteInexistente() {
        given()
                .pathParams("restauranteId", RESTAURANTE_ID_INEXISTENTE)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
        .when()
                .get("/{restauranteId}")
        .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
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
        burgerTopRestaurante = RestauranteTestData
                .umRestauranteNovo()
                .nome("Burger Top")
                .aberto(Boolean.TRUE)
                .ativo(Boolean.TRUE)
                .endereco(EnderecoTestData
                        .umEndereco()
                        .cidade(cidadeBarueri)
                        .build())
                .cozinha(cozinhaAmericada)
                .formasPagamento(Set.of(credito))
                .responsaveis(Set.of(responsavel))
                .build();
        restauranteRepository.save(burgerTopRestaurante);
        quantidadeRestaurantesCadastrados = (int) restauranteRepository.count();
    }
}