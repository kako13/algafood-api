![Readme Card](https://github-readme-stats.vercel.app/api/pin?username=kako13&repo=algafood-api&show_icons=true&theme=codeSTACKr&hide_border=true&bg_color=00000000)
####

<details>
  <summary><i>02 - Spring e Injeção de Dependências</i></summary>
<ol>

<li>Por que aprender e usar Spring?</li>
<li>Conhecendo o ecossistema Spring</li>
<li>Spring vs Jakarta EE (Java EE)</li>
<li>Conhecendo o Spring Boot</li>
<li>

[Criando um projeto Spring Boot com Spring Initializr](https://start.spring.io)</li>
<li>Conhecendo o Maven e o pom.xml de um projeto Spring Boot</li>
<li>Criando um controller com Spring MVC (Hello World!)</li>
<li>Restart mais rápido da aplicação com DevTools</li>
<li>

[O que é injeção de dependências?](https://github.com/kako13/exemplo-di)</li>

<li> Conhecendo o IoC Container do Spring</li>
<li> Definindo beans com @Component</li>
<li> Injetando dependências (beans Spring)</li>
<li> Usando @Configuration e @Bean para definir beans</li>
<li> Conhecendo os pontos de injeção e a anotação @Autowired</li>
<li> Dependência opcional com @Autowired</li>
<li> Ambiguidade de beans e injeção de lista de beans</li>
<li> Desambiguação de beans com @Primary em um dos beans</li>
<li> Desambiguação de beans com @Qualifier</li>
<li> Desambiguação de beans com anotação customizada ⭐</li>
<li> Mudando o comportamento da aplicação com Spring Profiles (de ambiente à seleção implementações) ⭐</li>
<li><details>
  <summary><i>Criando métodos de callback do ciclo de vida dos beans</i></summary>
<ol>
Existem três formas possíveis:

* Através das anotações @PostConstructor e @PreDestroy:

```
    @PostConstruct
    public void init(){
        System.out.println("INIT " + notificador);
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("DESTROY " + notificador);
    }
```
* Através da anotações @Bean(initMethod = "init", destroyMethod = "destroy"), numa classe de configuração de um bean:

```
@Configuration
public class ServiceConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AtivacaoClienteService ativacaoClienteService(){
        return new AtivacaoClienteService();
    }
}
```
* Através da implementação das interfaces InitializingBean e DisposableBean:

```
public class AtivacaoClienteService implements InitializingBean, DisposableBean {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA) // via SMS
    @Autowired
    private Notificador notificador;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("INIT " + notificador);
        // Qualquer lógica de inicialização adicional pode ser colocada aqui
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DESTROY " + notificador);
        // Qualquer lógica de destruição adicional pode ser colocada aqui
    }
}
```
</ol>
</details></li>

<li>Publicando e consumindo eventos customizados ⭐</li>
<li>

Configurando projetos Spring Boot com o [application.properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)</li>
<li>Substituindo propriedades via linha de comando e variáveis de ambiente</li>
<li>Criando e acessando propriedades customizadas com @Value</li>
<li>Acessando propriedades com @ConfigurationProperties</li>
<li>Alterando a configuração do projeto dependendo do ambiente (com Spring Profiles) ⭐</li>
<li><details>
    <summary>Ativando o Spring Profile por linha de comando e variável de ambiente</summary>
<ol>

Linha de comando:
```
java -jar .\target\algafood-api-0.0.1-SNAPSHOT.jar --spring.profiles.active=development
```

Variável de ambiente:

Linux:
```
export SPRING_PROFILES_ACTIVE=production
```
Windows:
- Temporária
```
set SPRING_PROFILES_ACTIVE=production
```
- Permanente
```
setx SPRING_PROFILES_ACTIVE=production
```
</ol>
</details></li>
</ol>
</details>
<details>
  <summary><i>03 - Introdução ao JPA e Hibernate</i></summary>
<ol>

<li>Instalando o MySQL Server e MySQL Workbench (adotei o docker-compose.yaml)</li>
<li>O que é JPA e Hibernate</li>
<li>Adicionando JPA e configurando o Data Source</li>
<li>Mapeando entidades com JPA</li>
<li>Criando as tabelas do banco a partir das entidades</li>
<li>Mapeando o id da entidade para autoincremento</li>
<li>Importando dados de teste com import.sql</li>
<li>Consultando objetos do banco de dados</li>
<li>Adicionando um objeto no banco de dados</li>
<li>Buscando um objeto pelo id no banco de dados</li>
<li>Atualizando um objeto no banco de dados</li>
<li>Excluindo um objeto do banco de dados</li>
<li>Conhecendo o padrão Agregate do DDD</li>
<li>Conhecendo e implementando o padrão Repository (por agregate)</li>
<li>Conhecendo e usando o Lombok</li>
<li>Desafio: Lombok e repositório de restaurantes</li>
<li>Mapeando relacionamento com @ManyToOne e Dialeto</li>
<li>A anotação @JoinColumn (para nomear coluna de FK)</li>
<li>Propriedade nullable de @Column e @JoinColumn</li>
<li>Desafio: mapeando entidades (Forma Pagamento, Permissão, Cidade e Estado)</li>
</ol>
</details>
<details>
  <summary><i>04 - REST com Spring</i></summary>

<ol>

<li>O que é REST?</li>
<li><details>
    <summary>Conhecendo as constraints do REST</summary>
<ol>

- Cliente-servidor
- Sistema em camadas (desconhecida pelo cliente)
- Stateless
- Cache
- Interface uniforme
- Código sob demanda

</ol>
</details></li>

<li>Diferença entre REST e RESTful</li>
<li>Desenvolvedores de REST APIs puristas e pragmáticos</li>
<li>Conhecendo o protocolo HTTP</li>
<li>Usando o protocolo HTTP</li>
<li>Instalando e testando o Postman</li>
<li><details>
    <summary>8. Entendendo o que são Recursos REST</summary>
<ol>

- Singleton Resource
- Collection Resource

</ol>
</details></li>

<li>Identificando recursos REST</li>
<li>Modelando e requisitando um Collection Resource com GET</li>
<li>Desafio: collection resource de estados</li>
<li>Representações de recursos e content negotiation</li>
<li>Implementando content negotiation para retornar JSON e/ou XML</li>
<li>Consultando Singleton Resource com GET e @PathVariable</li>
<li>Customizando as representações XML e JSON com @JsonIgnore, @JsonProperty e @JsonRootName (Jackson para JSON e XML)</li>
<li>Customizando a representação em XML com Wrapper e anotações do Jackson</li>
<li>Conhecendo os métodos HTTP</li>
<li>Conhecendo os códigos de status HTTP</li>
<li>Definindo o status da resposta HTTP com @ResponseStatus</li>
<li>Manipulando a resposta HTTP com ResponseEntity</li>
<li>Corrigindo o Status HTTP para resource inexistente</li>
<li>Status HTTP para collection resource vazia: qual usar?</li>
<li>Modelando e implementando a inclusão de recursos com POST</li>
<li>Negociando o media type do payload do POST com Content-Type</li>
<li>Modelando e implementando a atualização de recursos com PUT</li>
<li>Modelando e implementando a exclusão de recursos com DELETE</li>
<li>Implementando a camada de domain services (e a importância da linguagem ubíqua)</li>
<li>Refatorando a exclusão de cozinhas para usar domain services</li>
<li>Desafio: modelando e implementando a consulta de recursos de restaurantes</li>
<li>Modelando e implementando a inclusão de recursos de restaurantes</li>
<li>Desafio: Modelando e implementando a atualização de recursos de restaurantes</li>
<li>Desafio: implementando serviços REST de cidades e estados</li>
<li>Analisando solução para atualização parcial de recursos com PATCH</li>
<li>Finalizando a atualização parcial com a API de Reflections do Spring</li>
<li>Introdução ao Modelo de Maturidade de Richardson (RMM)</li>
<li>Conhecendo o nível 0 do RMM (POX - Plain Old XML; podendo ser também em JSON)</li>
<li>Conhecendo o nível 1 do RMM (identificação de recursos)</li>
<li>Conhecendo o nível 2 do RMM (nível 1 + Verbos e códigos de Status HTTP; é o mais comum no mercado)</li>
<li>Conhecendo o nível 3 do RMM (nível 2 + HATEOS)</li>

</ol>
</details>

<details>
    <summary><i>05. Super poderes do Spring Data JPA</i></summary>
<ol>

<li>Implementando consultas JPQL em repositórios</li>
<li>Conhecendo o projeto Spring Data JPA (SDJ)</li>
<li>Criando um repositório com Spring Data JPA (SDJ)</li>
<li>Refatorando o código do projeto para usar o repositório do SDJ</li>
<li>Desafio: refatorando todos os repositórios para usar SDJ</li>
<li>Criando consultas com query methods</li>
<li>

[Usando as keywords para definir critérios de query methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)</li>
<li><details>
<summary>Conhecendo os prefixos de query methods</summary>
<ol>

- prefixos de consulta (find, get, read, stream, query)
- prefixo booleano (exists)
- totalizador (count)
- flags de limite (first, last, top2)

</ol>
</details></li>

<li>Usando queries JPQL customizadas com @Query</li>
<li>Externalizando consultas JPQL para um arquivo XML ⭐</li>


<li><details>
<summary>Implementando um repositório SDJ customizado ⭐</summary>
<ol>

1. Criar uma classe com o mesmo nome da interface SDJ Repository utilizada e adicionar o sufixo 'Impl', ex:
```
RestauranteRepository
```
criar classe:
```
RestauranteRepositoryImpl
```

2. Implementar consultas utilizando EntityManager, aplicando as logicas desejadas
3. Extrair uma interface desta nova classe adotando nomenclatura com prefixo Customized ou sufixo Queries, ex:
```
CustomizedRestauranteRepository
```
ou:
```
RestauranteRepositoryQueries
```
4. E na interface SDJ Repository em questão, herdar a nova interface

Desta forma o Spring conseguirá resolver e vincular a interface SDJ a implementação em tempo de compilação. 
Possibilitando que o dev note possíveis erros.
</ol>
</details>

<li>Implementando uma consulta dinâmica com JPQL</li>
<li>Implementando uma consulta simples com Criteria API</li>
<li>Adicionando restrições na cláusula where com Criteria API</li>
<li>Tornando a consulta com Criteria API com filtros dinâmicos ⭐</li>
<li>Conhecendo o uso do padrão Specifications (DDD) com SDJ ⭐</li>
<li>Implementando Specifications com SDJ ⭐</li>
<li>Criando uma fábrica de Specifications ⭐</li>
<li>Injetando o próprio repositório na implementação customizada e a anotação @Lazy ⭐</li>
<li>Estendendo o JpaRepository para customizar o repositório base ⭐</li>

###
###### *Utilizando o Spring na versão 3.1.3 e Java na versão 17, não é possível capturar a exception 'EmptyResultDataAccessException' ao tentar excluir uma entidade inexistente. Ajustes foram necessários.*

</ol>
</details>

<details>
    <summary><i>06. Explorando mais do JPA e Hibernate</i></summary>
<ol>

<li>Mapeando relacionamento bidirecional com @OneToMany</li>
<li>Mapeando relacionamento muitos-para-muitos com @ManyToMany</li>

<li><details>
    <summary>Analisando o impacto do relacionamento muitos-para-muitos na REST API</summary>

Por se tratar de um relacionamento, ao desenvolver a alteração de um recurso, devemos considerar se estas relações devem ou não ser alteradas

Além disso, em no nosso caso temos um acúmulo de função por parte do Modelo de Representação de Domínio, pois ele também cumpre o papel de Modelo de Representação de Recurso.
E isso não é bom, pois como os modelos estão associados e temos diversos recursos, cada recurso tem a sua própria necessidade ao utilizar um Modelo de Representação.

Ou seja, as mudanças nos modelos pensando no domínio, podeão impactar o comportamento das APIs.


</details></li>

<li>Mapeando classes incorporáveis com @Embedded e @Embeddable</li>
<li>Testando e analisando o impacto da incorporação de classe na REST API</li>
<li>Mapeando propriedades com @CreationTimestamp e @UpdateTimestamp ⭐</li>
<li>Desafio: mapeando relacionamento muitos-para-um</li>
<li>Desafio: mapeando relacionamento um-para-muitos</li>
<li>Desafio: mapeando relacionamentos muitos-para-muitos</li>
<li><details>
    <summary>Entendendo o Eager Loading</summary>

Carregamento ansioso. Relacionamentos terminados em 'One'.

Eager Loading é o comportamento de carregar entidades relaciondas ao carregar a entidade em questão,
e não determina o número de consultas que serão realizadas, este será definindo pela inplementação JPA

Uma observação importante sobre o comportamento da anotação @JoinColumn(name = "cozinha_id", nullable = false) (not null ao criar a tabela), 
é que ela também possui a finallidade de alterar a forma que a implementção JPA irá gerar a consulta. Como realizar um join (inner join) ao invés de um left join,
já que é certo que a outra tabela possui um registro relacionado.

A ideia primeiramente é compreender o comportamento para que mais adiante a gente possa customizar de ocordo a necessidade.

</details></li>
<li><details>
    <summary>Entendendo o Lazy Loading</summary>

Carregamento preguiçoso. Relacionamentos terminados em 'Many'.

Many Loading é o comportamento de **não carregar** entidades relaciondas ao carregar a entidade em questão,
e não determina o número de consultas que serão realizadas, este será definindo pela inplementação JPA

As consultas dos relacionamentos são feitas conforme o uso, ou seja, sob demanda.

Mais adiante iremos customizar este comportamento de ocordo com a necessidade.

</details></li>
<li><details>
    <summary>Alterando a estratégia de fetching para Lazy Loading</summary>

Para atender e a configuração @ManyToOne(fetch = FetchType.LAZY) que colocamos no atributo Cozinha da Classe Restaurante, tivemos que utilizar a anotação 
@JsonIgnoreProperties({"hibernateLazyInitializer"}), que corresponde a ignorar a propriedade "hibernateLazyInitializer" do proxy Cozinha$HibernateProxy$
criado em tempo de execução pelo hibernate.  
</details></li>
<li><details>
    <summary>Alterando a estratégia de fetching para Eager Loading</summary>

Não é recomendado alterar a propriedade de um relacionamento que por padrão é Lazy (OneToMany e ManyToMany) para Eager. 
É importante avaliar com cautela se esta alteração é realmente necessária. Tenha cuidado ao utilizar, pois será feita 
uma nova consulta para cada registro de relacionamento que a entidade em questão possua, mesmo que não seja utilizado algum campo do relacionamento.
</details></li>
<li><details>
    <summary>Resolvendo o Problema do N+1 com fetch join na JPQL</summary>
 
Para reduzir o número de consultas desta situação, devemos utilizar o `JOIN FETCH` para carregar as relações `nullable = false` (`NOT NULL`), seja ManyToOne ou ManyToMany. 
E desta forma fazer apenas uma consulta para trazer os relacionamentos.
Para entidades `nullable = true`, devemos utilizar o `LEFT JOIN FETCH`.

_Quando utilizamos este tipo de abordagem em relacionamentos ManyToMany o resultado da consulta é um produto cartesiano, 
que é considerado e tratado pelo JPA, ou seja, devido à combinação a consulta gerada no banco de dados retorna um número 
maior de registros do que objetos retornados na API._
</details></li>


</ol>
</details>

<details>
    <summary><i>07. Pool de conexões e Flyway</i></summary>
<ol>
<li><details>
    <summary>Entendendo o funcionamento de um pool de conexões</summary>
    
Componente de software que gerencia um conjunto de conexões com o banco de dados para reutilização, onde é possível 
determinar o mínimo e máximo de conexões ativas. Ao iniciar a aplicação o pool já disponibiliza um conjunto de conexões, 
e após isso apenas gerencia, sem encerrar as conexões, apenas quando estas são excedentes. Isso reduz o tempo e 
processamento que seriam gastos com a abertura e fechamento de conexões. Existem mais configurações e particularidades 
a depender da solução adotada.
 
</details>
</li>
<li>Conhecendo o Hikari: a solução padrão de pool de conexões no Spring Boot</li>
<li>Configurando o pool de conexões do Hikari ⭐</li>
<li>Schema generation em produção não é uma boa prática</li>
<li>Flyway: ferramenta de versionamento de schemas de banco de dados (incremental)</li>
<li>Adicionando o Flyway no projeto e criando a primeira migração</li>
<li>Evoluindo o banco de dados com novas migrações</li>
<li>Criando migrações complexas com remanejamento de dados ⭐</li>
<li><details>
    <summary>Criando migração a partir de DDL gerado por schema generation ⭐</summary>

_*Ao utilizar este recurso deve-se editar o tamanho dos campos gerados automaticamente no `ddl.sql`. Tem melhor 
utilizadade como template, criando uma estrutura com os nomes, obrigatoriedades, chaves unicas, entre outros.*_
</details>
</li>
<li><details>
    <summary>Adicionando dados de testes com callback do Flyway ⭐</summary>

`insert ignore` é um recurso do MySql com similarem em outros bancos de dados, ele ignora os erro durante os inserts do 
afterMigrate.sql de forma que, caso sejam inseridos novos dados de teste eles não serão excluídos quando iniciar a aplicação e rodar as migrações.

Já no nosso caso, adotamos o contole manual, para que a massa de testes esteja sempre no mesmo estado e o comportamento fique parecido
com quando utlilizamos o import.sql.
</details>
</li>
<li><details>
    <summary>Reparando migrações com erros ⭐</summary>

Em ambiente de desenvolvimento, basta excluir o registro da migration com que falhou da tabela do Flyway, corrigir o 
ponto com erro e iniciar/reiniciar a aplicação.
Caso não tenha acesso à base de dados, é possível utilizar o plugin do flyway através do maven.

**Em produção, caso ocorra algum problema no meio de uma migration, é necessário desfazer o que já foi realizado pelos
scripts que não apresentaram erro, além dos passos anteriores.**

</details>
</li>
<li><details>
    <summary>Desafio: Criando migrações e mapeando as entidades Pedido e ItemPedido ⭐</summary>

As entidades foram mapeadas e as anotações foram utilizadas para aproveitar a estrutura do DDL generation para migrações.
Através das seguintes configurações:

    #Criar scripts DDL com base no 'mapeamento das classes', e popular banco com base no import.sql ou afterMigrate.sql
    spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
    spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=src/main/resources/db/ddl.sql

Após concluir as migrações, as anotações de definição dos campos foram retiradas, permanecendo apenas anotações de nomenclatura, 
que precisam mapear as tabela sem alterar o nome do atributo da classe. Isso mantém a semântica do código e o estado da tabela. 
E também foram preservadas as definições de obrigatoriedade, já que a configuração `nullable=true`, influencia nas consultas geradas pelo framework. 

</details>
</li>

_*Não se deve utilizar dados de testes em migrações, comandos DML são utilizados **apenas em casos de migração de dados 
por conta de alguma alteração.** Consultar aulas 8 e 10._

</ol>
</details>
<details>
    <summary><i>08. Tratamento e modelagem de erros da API ⭐</i></summary>
<ol>

<li>Introdução ao tratamento e modelagem de erros</li>
<li><details>
    <summary>Lançando exceções customizadas anotadas com @ResponseStatus ⭐</summary>

Esta abordagem separa as anotações de ResponseStatus entre a possíveis exceptions e o controller. Para um poc pode fazer 
sentido. Mas tem como ponto negativo a mistura (o contato) de classes de negócio com a camada web, além de não podermos 
incluir um body quando cair em alguma das exceptions anotadas. 


Foi necessário alterar o método de exclusão do serviço de cozinhas, pois aparentemente o Spring framework nesta versão `3.1.3` não
lança a exception `EmptyResultDataAccessException`.

</details>
</li>
<li><details>
    <summary>Lançando exceções do tipo ResponseStatusException ⭐</summary>

Estas exceptions já contém o código de retorno imbutido, como a `ServerWebInputException`, elas são úties para ganhar 
agilidade no desenvolvimento para não ter que criar as exceptions customizadas. E utilizando a `ResponseStatusException`, que é mais genérica, pode-se determinar 
o código de retorno da requisição. 


</details>
</li>
<li><details>
    <summary>Estendendo ResponseStatusException ⭐</summary>

A vantagem desta abordagem é que quem lança a exception consegue definir o código HTTP de retorno. Podendo até mesmo 
apenas uma classe de exceção ficar responsável por qualquer retorno com código HTTP, de forma centralizada, vez que ele 
pode ser passado.
A desvantagem é que a passagem do código ficaria numa classe de serviço/negócio.
_Mas essa não será a aboradagem do curso_
</details>
</li>
<li>Simplificando o código com o uso de @ResponseStatus em exceptions ⭐</li>
<li>Desafio: refatorando os serviços REST</li>
<li>Analisando os impactos da refatoração</li>
<li><details>
    <summary>Criando a exception NegocioException ⭐</summary>

Agora com uma nova exception `NegocioException` anotada com `@ResponseStatus(code = HttpStatus.BAD_REQUEST)`, agora 
ciente das possíveis exceptions dos serviços de cada entidade, é na camada web (controllers) que devemos **pensar melhor** 
nos códigos de retorno da API e determinar se é um erro de negócio.
</details></li>
<li>Desafio: usando a exception NegocioException</li>
<li><details>
    <summary>Afinando a granularidade e definindo a hierarquia das exceptions de negócios ⭐</summary>

Para sabermos qual a melhor granularidade das exceptions do projeto devemos saber se, quem vai consumir os métodos da classe 
de serviço (controller) precisa saber reagir de forma diferente caso o método falhe e gere uma exception. Se sim, é o caso 
de aumentar a granularidade e gerar exceptions mais específicas. No nosso caso, precisamos saber qual foi o problema de forma específica, 
para definirmos qual o código HTTP será retornado.

</details></li>
<li>Desafio: lançando exceptions de granularidade fina</li>
<li><details>
    <summary>Tratando exceções em nível de controlador com @ExceptionHandler ⭐</summary>

Agora é possível atribuir um body combinando com o código de retorno que desejarmos.
O ExceptionHandler de EntidadeNaoEncontradaException só considera a hierarquia da exception declarada na sua anotação para tratar dentro do seu método, 
quando a "causa" (Throwable `cause`) é utilizada no dentro `catch`. Do contrário, ele vai desconsiderar a exception e 
vai seguir o fluxo dentro do `catch`, ou seja, retornando o código determinado na anotação da classe 
NegocioException e utilizando o modelo de representação padrão do Spring.

Por isso, para não deixar de utilizar a "causa" (Throwable `cause`), criamos um ExceptionHandler de NegocioException.
Desta forma poderemos atribuir um body customizado, o que não era possível até então, e determinar no método o código de retorno,
que antes estava na anotação da exception.

Foi criado um modelo de representação de nome Problema para os erros da API
</details></li>
<li>Tratando exceções globais com @ExceptionHandler e @ControllerAdvice ⭐</li>
<li>Desafio: implementando exception handler ⭐</li>
<li><details>
    <summary>Criando um exception handler global com ResponseEntityExceptionHandler ⭐</summary>

Global neste caso, por conta de cobrir diversas exceptions diferenctes:


- `HttpRequestMethodNotSupportedException`
- `HttpMediaTypeNotSupportedException`
- `HttpMediaTypeNotAcceptableException`
- `MissingPathVariableException`
- `MissingServletRequestParameterException`
- `MissingServletRequestPartException`
- `ServletRequestBindingException`
- `MethodArgumentNotValidException`
- `NoHandlerFoundException`
- `AsyncRequestTimeoutException`
- `ErrorResponseException`
- `ConversionNotSupportedException`
- `TypeMismatchException`
- `HttpMessageNotReadableException`
- `HttpMessageNotWritableException`
- `BindException`

E neste caso pode ou não retornar um modelo de representação padrão, a depender da versão do framework. O curso propõe a versão 
2.1.7 do Spring Boot, e o corpo da resposta retorna vazio. Enquanto no meu caso, usando a versão 3.1.3 já existem o seguinte modelo padrão:

```
{
"type": "about:blank",
"title": "Unsupported Media Type",
"status": 415,
"detail": "Content-Type 'application/xml;charset=UTF-8' is not supported.",
"instance": "/cidades/5"
}
```
</details></li>
<li>Customizando o corpo da resposta padrão de ResponseEntityExceptionHandler ⭐ ⭐</li>
<li><details>
    <summary> Conhecendo a RFC 7807 (Problem Details for HTTP APIs) ⭐</summary>

 Tem como benefício indicar ao cliente de form 
Especificações:
- [JSON:API](https://jsonapi.org)
```
{
  "errors": [
    {
      "status": "422",
      "source": { "pointer": "/data/attributes/firstName" },
      "title":  "Invalid Attribute",
      "detail": "First name must contain at least two characters."
    }
  ]
}
```
- [vnd.error](https://github.com/blongden/vnd.error)
```
{
    "message": "Validation failed",
    "path": "/username",
    "logref": 42,
    "_links": {
        "about": {
            "href": "http://path.to/user/resource/1"
        },
        "describes": {
            "href": "http://path.to/describes"
        },
        "help": {
            "href": "http://path.to/help"
        }
    }
}
```
- [Problem Details for HTTP APIs](https://datatracker.ietf.org/doc/html/rfc7807) (RFC 7807)
```
{
  "status": 400,
  "type": "https://algafood.com.br/recurso-em-uso"
  "title": "Recurso em uso"
  "detail": "Não foi possivel excluir a cozinha de código 8, porque ela está em uso"
  "instance": "/cozinhas/8/erros/98204983'
}
```

</details></li>
<li>Padronizando o formato de problemas no corpo de respostas com a RFC 7807 ⭐ ⭐</li>
<li>Desafio: usando o formato de problemas no corpo de respostas</li>
<li>Customizando exception handlers de ResponseEntityExceptionHandler ⭐ ⭐</li>
<li><details>
    <summary>Tratando a exception InvalidFormatException na desserialização ⭐ ⭐ ⭐</summary>

Foi a adicionada a dependência `commons-lang3` do apache:
```
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
</dependency>
```

Desta forma foi possível utilizar o método `ExceptionUtils.getRootCause(ex)` que devolve um `Throwable`, e caso ele seja
do tipo `InvalidFormatException` (o caso de preenchimento de tipo de dado inválido) é chamado o método que trata esta 
exception. E nele recuperamos do rootCause, ou seja, da exception, o campo em questão atravé do método `ex.getPath()` e `reference.getFieldName()`.
Então iteramos para formar a hierarquia dos campos intercalando com ponto `'.'`, quando existente, para preencher 
na mensagem de erro.
</details></li>
<li><details>
    <summary>Habilitando erros na desserialização de propriedades inexistentes ou ignoradas ⭐ ⭐</summary>

Por padrão a jackson ignora o envio de campos inexistentes no modelo. Este comportamento pode ser alterado adicionado a 
configuração `spring.jackson.deserialization.fail-on-unknown-properties=true` no application.properties. Desta forma será
lançada a exception `HttpMessageNotReadableException` ao invés de ignorar.

Por outro lado, por padrão a jackson permite o envido de campos anotado com `@JsonIgnore` no modelo (ao invés de bloquear).
Este comportamento pode ser alterado com a configuração `spring.jackson.deserialization.fail-on-ignored-properties=true` no application.properties, desta forma, se um campo que deve 
ser ignorado for enviado será lançada a exception `HttpMessageNotReadableException`.

Ambos os casos são tratados pelo nosso `ApiExceptionHandler`.
</details></li>

<li><details>
    <summary>Desafio: tratando a PropertyBindingException na desserialização ⭐</summary>


Foi implementado o método `handlePropertyBindingException` que tratará da mesma forma os campos com `@JsonIgnore` e
com campos inexistentes, caso sejam enviados. Ou seja trata tanto quando a causa é `IgnoredPropertyException` quanto 
`UnrecognizedPropertyException`. 
</details></li>

<li><details>
    <summary>Lançando exception de desserialização na atualização parcial (PATCH) ⭐ ⭐ ⭐</summary>

Este método utiliza o ObjectMapper para deserializar o corpo da requisição, então para deixar com o mesmo 
comportamento dos demais foram feitas adaptações.

Primeiramento parametrizamos o ObjectMapper para passar a falhar (retornar cod 500) quando for 
informado um campo anotado com `@JsonIgnore`:
- `objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);`

Para falhar ao passar um campo que não faz parte do nosso modelo de representação, este já é o comportamento padrão, foi 
declarado para deixar explícito o comportamento:

- `objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);`  

Quanto ao fluxo de exception:

Após as alterações acima, ao passarmos um campo desconhecido ou ignorado, retorna 500. E ainda que apresente a exception 
`IgnoredPropertyException`, a causa na stack de retorno é uma `IllegalArgumentException`. Portanto, fizemos a tradução, 
para que fosse lançada a `HttpMessageNotReadableException`. Desta forma é seguido o fluxo da `PropertyBindingException` 
(super classe das exceptions `IgnoredPropertyException` e `UnrecognizedPropertyException`) no ControllerAdvice (Exception Handler).

Benefício:
- Desta forma não foi necessário criar mais um handler para tratar este caso em especial.

Foi necessário também uma instância de `ServletServerHttpRequest` com base numa request recuperada do framework, para atender
a assinatura não depreciada da exception `HttpMessageNotReadableException`.

</details></li>
<li><details>
<summary>Desafio: tratando exception de parâmetro de URL inválido ⭐</summary>

TypeMismatchException é lançada em caso de erros em propriedades para instanciação de beans.
MethodArgumentTypeMismatchException é mais específica, é lançada em caso de erros de tipo de parâmetros em métodos.

1. MethodArgumentTypeMismatchException é um subtipo de TypeMismatchException

2. ResponseEntityExceptionHandler já trata TypeMismatchException de forma mais abrangente

3. Então, especializamos o método handleTypeMismatch e verificamos se a exception
   é uma instância de MethodArgumentTypeMismatchException

4. Se for, chamamos um método especialista em tratar esse tipo de exception

5. Poderíamos fazer tudo dentro de handleTypeMismatch, mas preferi separar em outro método

</details></li>
<li>Desafio: tratando a exceção NoHandlerFoundException ⭐</li>
<li><details>
<summary>Desafio: tratando outras exceções não capturadas ⭐</summary>

É importante colocar o printStackTrace (pelo menos por enquanto, que não estamos fazendo logging) para mostrar a 
stacktrace no console. Se não fizer isso, você não vai ver a stacktrace de exceptions que seriam importantes para você, 
especialmente durante a fase de desenvolvimento

A exception foi estimulada e lançada propositadamente via controller para fins de teste no método POST de cidades.
</details></li>
<li><details>
<summary>Estendendo o formato do problema para adicionar novas propriedades ⭐</summary>

Agora é possível passar uma indicação mais específica ao consumidor caso ocorra algum erro.

Foi adicionada a propriedade userMessage ao Problem. E para o caso em que a mensagem já está explicativa o bastante para
o consumidor da API, foi definido como userMessage o mesmo conteúdo do detail.
</details></li>
<li>Desafio: estendendo o formato do problema ⭐</li>


#
###### Resumo:

###### Como devolver codigo de Status HTTP e a mensagem a partir de exceptions de duas formas: 
###### - Utilizando a anotação `@ResponseStatus` nas exceptions
###### - Utilizando as classes de exceção `ResponseStatusException`, vide `Ctrl+h`
###
###### Abordando as exceptions:
###### - Afinamos a granularidade e definimos uma hierarquia das exceptions de negócio
###### - Utilizamos @ExceptionHandler em métodos para tratar exceções em nível de controlador
###### - Foi criado um modelo de representação de nome Problema para os erros da API
###### - Utilizamos @ControllerAdvice na classe ApiExceptionHandler para tratar exceções em nível **global**
###### - Criamos ExceptionHandler para exceptions que não são customizadas (do 'framework')
###### - Criamos um exception handler global com ResponseEntityExceptionHandler
###### - Customizamos o corpo de resposta de erro padrão através ResponseEntityExceptionHandler
###### - Padronizamos o formato de problemas no corpo de respostas com a RFC 7807
###### - Tratamos a exception InvalidFormatException na desserialização de forma mais específica
###### - Tratamos as possíveis exceptions forma mais específica
###### - "Estendemos" a especificação do Problem Details adicionando uma nova propriedade 


</ol>
</details>
<details>
    <summary><i>09. Validações com Bean Validation</i></summary>
<ol>

<li><details>
<summary>Validação do modelo com Bean Validation ⭐</summary>

A partir da versão 2.3.x do Spring, o Bean Validation (e outras bibliotecas de validação) não é adicionado automaticamente 
como dependência do pacote spring-boot-starter-web. Logo, deve-se adicionar o starter da dependência em questão manualemnte.

```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

</details></li>
<li><details>
<summary>Adicionando constraints e validando no controller com @Valid ⭐</summary>

Quando tentamos adicionar um novo Restaurante, através do verbo POST, sem informar o campo 'nome' ou infomando como 'null'.
Recebemos o código de retorno 500 e a exception DataIntegrityViolationException é lançada, por conta do campo ser obrigatório (not null)
no banco.
Quando adicionamos @NotNull na propriedade 'nome' do Problem e fazemos a mesma requisição, recebemos como código de retorno
500 e a exception lançada é a DataIntegrityViolationException.
Então ao anotarmos o parâmetro Restaurante, que é RequestBody do método do controller, com o @Valid, passamos a receber o 
código 400

</details></li>
<li><details>
<summary>Desafio: tratando exception de violação de constraints de validação ⭐</summary>

Foi implementado o método `handleMethodArgumentNotValid` da interface `ResponseEntityExceptionHandler`.
</details></li>
<li><details>
<summary>Estendendo o Problem Details para adicionar as propriedades com constraints violadas ⭐</summary>

Foi incluída a seguinte propriedade e inner class no Problem:

```
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {
        private String name;
        private String userMessage;
    }
```

A exception `MethodArgumentNotValidException` nos fornece um `BindingResult` através do método `ex.getBindingResult()`,
e este armazena dados sobre as propriedades violadas, como o nome do campo, valor e etc.

Desta forma é possível preencher o novo atributo do Problem, uma lista de Fields, com o que obtemos do bindingResults:
```
List<FieldError> fieldErrors = bindingResult.getFieldErrors();
```
</details></li>
<li><details>
<summary>Conhecendo e adicionando mais constraints de validação no modelo ⭐</summary>

Existe uma implementação Hibernate do Bean Validation, [Hibernate Validator](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#preface)
que possui algumas funcionalidades depreciadas, já que nas versões atuais o Bean Validation já trazia algumas funcionalidades
que só existiam no hibernate. O Hibernate validator também possui funcionalidades por região, como `@CPF`, `@CNPJ` no caso
do Brasil.

De qualquer forma, é melhor priorizar as funcionalidades do Bean Validation do Spring.

Conhecemos as notações:

- `@NotNull`
- `@NotEmpty` 
- `@NotBlank`
- `@PositiveOrZero`
- `@DecimalMin("1")`
</details></li>
<li><details>
<summary>Validando as associações de uma entidade em cascata ⭐</summary>

Adicionada a anotação `@Valid` na propriedade que também possui atributos anotados para serem validados.

</details></li>
<li><details>
<summary>Agrupando e restringindo constraints que devem ser usadas na validação ⭐</summary>

A ideia de agrupar validações, funciona como uma "marcação" em nossas anotações.

Para criar um grupo de validação basta criar um interface e nela declarar uma nova interface:
```
public interface Groups {

    interface CadastroRestaurante {}
}
```

Podemos agrupar validações através dos 'Groups' que podem ser informados nas anotações de validação como `@NotNull`, 
`@NotBlank` e afins, exceto o `@Valid`. Como no exemplo:

```
    @NotBlank(groups = Groups.CadastroRestaurante.class)
    @Column(nullable = false)
    private String nome;

    @PositiveOrZero(groups = Groups.CadastroRestaurante.class)
    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @Valid
    @NotNull(groups = Groups.CadastroRestaurante.class)
    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false) //"num_idt_cozinha" definindo nome da coluna
    private Cozinha cozinha;
```

E depois no controller **ao invés** de anotar o parâmetro do RequestBody com ~~`@Valid`~~, utilizaremos o `@Validated` passando
o Groups como parâmetro:

```
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public Restaurante adicionar(@RequestBody @Validated(Groups.CadastroRestaurante.class) Restaurante restaurante) {
     try {
         return cadastroService.salvar(restaurante);
     } catch (CozinhaNaoEncontradaException e) {
         throw new NegocioException(e.getMessage(), e.getCause());
     }
 }
```
Isso quer dizer que ao validar o representation model recebido na requisição, o fluxo de validação ocorrerá apenas nas 
propriedades anotadas com o mesmo Group da anotação `@Validated` um nível acima, ou seja, no controller.

Nos casos em que **não for informado** um `@Validated` e o grupo, a aplicação irá adotar um grupo `Default.class` por padrão.
Logo, qualquer anotação bean validation por padrão utiliza o grupo `Default.class`.
</details></li>
<li><details>
<summary>Convertendo grupos de constraints para validação em cascata com @ConvertGroup ⭐ ⭐ ⭐</summary>

Com o tempo o número de Groups pode crescer e isso provavemente vai causar um acúmulo de Groups em algum atributo de alguma 
que seja informada em mais de uma requisição. 

Então mudamos a abordagem voltando o `@Validated` do parâmetro RequestBody do controller para `@Valid`, e dentro do Restaurante 
retiramos os Groups das anotações também, ou seja, agora temos o Group 'Default.class' validando o Restaurante. Enquanto que 
na Cozinha dexamos o Group `@NotNull(groups = Groups.CozinhaId.class)` na propriedade `id`.

Agora na propriedade Cozinha da classe Restaurante utilizamos o `@ConvertGroup(from = Default.class, to = Groups.CozinhaId.class)`.
Isso significa que ao passar um Restaurante numa requisição o fluxo de validação vai considerar apenas as propriedades anotadas 
com `Groups.CozinhaId.class` na Cozinha.  
</details></li>
<li>Desafio: adicionando constraints de validação no modelo</li>
<li>Customizando mensagens de validação na anotação da constraint</li>
<li><details>
<summary>Customizando e resolvendo mensagens de validação globais em Resource Bundle ⭐ ⭐ ⭐</summary>

Criamos um `messages.properties` para centralizar as mensagens de erro de validação de modelo.

Nesta abordagem a precedência é por especificidade, e podemos utilizar placeholders:

```
//Mais específico
NotBlank.restaurante.nome=Nome do restaurante é obrigatório
NotBlank.cozinha.nome=Nome de cozinha é obrigatório
NotBlank.nome=Informe um nome, pois o campo é obrigatório

//Menos especifico
NotBlank={0} é obrigatório

//Placeholders menos específico
nome=O campo nome

//Placeholders mais específico
restaurante.nome=Nome do restaurante
cozinha.nome=Nome da cozinha
estado.nome=Nome do estado
```

E no método handle do bean validation `handleMethodArgumentNotValid` montamos a mensagem para passar no 
userMessage da seguinte forma:

```
List<Problem.Field> fields = fieldErrors.stream()
       .map(fieldError -> {

           String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

           return Problem.Field.builder()
               .name(fieldError.getField())
               .userMessage(message)
               .build();
       })
       .collect(Collectors.toList());
```
</details></li>
<li>Desafio: customizando mensagens de validação</li>
<li><details>
<summary>Resolvendo mensagens de validação com Resource Bundle do Bean Validation ⭐ ⭐ ⭐</summary>

O Bean Validation ao lançar a exception de validação busca a mensagem num resource bundle. O `messages.properties` é o resource
bundle do **Spring**, já os arquivos de propriedades localizados na dependência `org.hibernate.validator:hibernate-validator:8.0.1.Final`:
- `ValidationMessages.properties` (Inglês)
- `ValidationMessages_pt.properties` (Português)
- `ValidationMessages_pt_BR.properties` (Complemento pt-br)

São 'resource bundle' do **Bean Validation**.

Desta forma a mensagem é primeiramente resolvida nos arquivos `ValidationMessages`, e depois é resolvida e sobrescrita (caso necessário) no 
`messages.properties`, o que resulta num **efeito de precedência do properties do Spring**. Mesmo sobrescrevendo o arquivo `ValidationMessages.properties`.

Da mesma forma, passar a chave da mensagem (independente arquivo properties) no parâmetro da anotação `@PositiveOrZero(message = "{TaxaFrete.invalida}")`, 
não tem efeito, caso a mensagem já tenha sido resolvida no resource bundle do Spring.

_Na versão 3.1.3 do Spring que estou utilizando, ao tentar sobrescrever o `jakarta.validation.constraints.PositiveOrZero.message=minha msg`
no `messages.properties`, já funcionou, diferente do comportamento apresentado na versão da aula. De qualquer forma a sobrescrita do resource 
bundle `ValidationMessages.properties` funcionou normalmente_

</details></li>
<li><details>
<summary>Usando o Resource Bundle do Spring como Resource Bundle do Bean Validation ⭐ ⭐ ⭐</summary>

Criamos uma classe de configuração com um método que retorna um bean de `LocalValidatorFactoryBean`, para fazer a 
integração e configuração do Bean Validation com o Spring. E nele determinamos se o MessageSource será o do Spring ou do 
Bean validation:
```
@Configuration
public class ValidationConfig {

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource); // com messages.properties
        return bean;

    }
}
```
Se informada a linha: 
`bean.setValidationMessageSource(messageSource);`, será utilizado o `messages.properties` do spring, do contrário será 
utilizado o `ValidationMessages.properties`, seja ele do `org.hibernate.validator:hibernate-validator` ou um novo que o sobrecreva. 
</details></li>

<li><details>
<summary>Criando constraints de validação customizadas usando composição ⭐ ⭐ ⭐</summary>

Sobre o comportamento para anotações customizadas.
Se (a anotação customizada for anotada por uma anotação do framework & a anotação do framework já possuir uma msg no messages.properties)
      mesmo definindo uma msg para a anotação customizada, será devolvida a mensagem da anotação do framework
      
Existe uma **[issue](https://github.com/spring-projects/spring-framework/issues/20519)** aberta para o caso. Mas acabo de testar e mesmo hoje permanece este comportamento.
</details></li>

<li><details>
<summary>Criando constraints de validação customizadas com implementação de ConstraintValidator ⭐ ⭐ ⭐</summary>

Criamos uma anotação customizada que verifica se a taxa frete é multiplo do número passado na anotação `@Multiplo`.
Para isso foi necessário criar uma classe que implementará a lógica de validação, `MultiploValidator`. Ela implementa a 
interface `ConstraintValidator<Multiplo, Number>` especificando a própria anotação e o tipo de dado passado. E devemos 
implementar obrigatoriamente o método `isValid`, para a lógica de validação. E opcionalmete o método `initialize`, quando 
for necessário recuperar alguma informação passada na anotação, como o número.

Quanto a mensagem da constraint, pode ser definida na "classe" da anotação, na anotação sobre a propriedade, ou através do
messages.properties, que neste caso, é utilizado pelo Bean Validation, recuperando os parâmetros:
```
Multiplo={0} deve ser um valor múltiplo de {1}.
```
Podendo utilizar as variações aprendidas nas aulas anteriores.
O valor `{0}` é referente ao nome da propriedade, e o `{1}` recebe o parâmetro passado na anotação.
</details></li>

<li>Criando constraints de validação customizadas em nível de classe ⭐ ⭐ ⭐</li>
</ol>
</details>