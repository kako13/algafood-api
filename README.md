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
    <summary><i>08. Tratamento e modelagem de erros da API</i> ⭐</summary>
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
    <summary><i>09. Validações com Bean Validation</i> ⭐</summary>
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

<li><details>
<summary>Ajustando Exception Handler para adicionar mensagens de validação em nível de classe ⭐ ⭐ ⭐</summary>

Agora ao invés de pegarmos os erros pelo `bindingResult.getFieldErrors();`, utilizamos `bindingResult.getAllErrors()`,
já que a notação é em nivel de classe, não mais em nível de propriedades (campos/atributo). Por isso alteramos o nome da
propriedade `fields` para `objects`, já que estendemos a especificação do 'Problem Details' alinhando com o nosso uso e 
este campo não faz parte da especificção.

Passamos a receber `null` no campo `name` do Problem de retorno.

Para corrijir o comportamento, durante a iteração dos erros, fizemos um teste (if) verificando, `objectError instanceof FieldError`, 
caso sim fazemos o cast para `FieldError` para continuar com o comportamento das demais validações, com o nome da 
propriedade (campo/atributo) no campo `name` do Problem de retorno:
```
if (objectError instanceof FieldError) {
   name = ((FieldError) objectError).getField();
}
```

Para facilitar na customização da mensagem, a descoberta da ordem dos argumentos passados na anotação utilizar pode ser 
feita apresentando todos os argumentos na mensagem do messages.properties: 
```
ValorZeroIncluiDescricao={0} - {1} - {2} - {3} - valor zero inclui descricao
```
No caso foi utilizado a partir do indice '1', pois a primeira posição vem nula.

O Spring sempre nos da sugestão de nomes no console para utilizarmos como placeholders quando a exception é resolvida pelo
`MethodArgumentNotValidException`:

```
[Error in object 'restaurante': codes [ValorZeroIncluiDescricao.restaurante,ValorZeroIncluiDescricao];
```
</details></li>

<li><details>
<summary>Executando processo de validação programaticamente ⭐ ⭐ ⭐</summary>


Como no método `PATCH` do controller de restaurantes não recebemos um Restaurante e sim um Map. Pois queremos apenas uma
atualização parcial de um Restaurante. Se utilizassemos esta classe, as validações existentes não iriam permitir o registro.
barrariam nossa tentativa de registro.

Também não é possível fazer a validação com a anotação `@Valid` sobre o Map.
Por isso criamos o seguinte método para a validação programática das propriedades que recebermos de um Restaurante utilizando
`BeanPropertyBindingResult` e `SmartValidator`:

```
 @Autowired
 private SmartValidator validator;
 
 private void validate(Restaurante restaurante, String objectName) {
     BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(restaurante, objectName);
     validator.validate(restaurante, bindingResult);
     if (bindingResult.hasErrors()) {
         throw new ValidacaoException(bindingResult);
     }
 }
```
Para validar o candidato a restaurante atualizado antes da camada de persistencia.

Também criamos e lançamos a nova exception `ValidacaoException(bindingResult)` que recebe o bindingResult, para evitar
lançar a `MethodArgumentNotValidException` devido à complexidade para instanciá-la, sendo que também poderíamos aproveitá-la 
no nosso ExceptionHandler. 

Desta forma ainda resta o tratamento desta nova exception `ValidacaoException` no ExceptionHandler para manter o 
comportamento como as demais validações. 
</details></li>

<li>Desafio: tratando a exception customizada de validações programáticas ⭐ ⭐ ⭐</li>
</ol>
</details>

<details>
    <summary><i>10. Testes de integração</i> ⭐</summary>
<ol>

<li>Introdução aos Testes de Integração e Testes de APIs</li>
<li>Preparando o projeto para testes de integração</li>
<li><details>
<summary>Criando e rodando um teste de integração com Spring Boot, JUnit e AssertJ ⭐</summary>



Realizamos testes de integração com um caso **positivo e negativo** chamando a classe de serviço de Cozinha. Validando o que
o a aplicação **faz e não faz**. Cada teste deve ser dividido em três partes:

- cenário (preparação de objetos)
- ação (tentar cadadastrar)
- validação (verificar se objeto cadastrado está nulo ou e com o id nulo)

Quanto ao número de validações (asserts), não necessariamente será apenas um por método. Pois para assegurar o estado de 
determinados objetos ao término de um processo, pode ser necessário mais de uma asserção
(`assertThat`, `assertThatThrownBy`, ...). 


_Sobre o JUnit 5
Alterações são necessárias para quem utiliza uma versão do Spring Boot superior a 2.4.0 (3.1.3 no meu caso), a qual
utiliza o JUnit 5 com padrão ao invés do JUnit 4._

_Sobre a classe de testes
Em nossa classe de testes a CadastroCozinhaIntegrationTests, removemos o @Test(expected = ConstraintViolationException),
deixando somente a annotation @Test._

_Fizemos a asserção da ConstraintViolationException via método assertThrows classe Assertions, ficando da seguinte forma:_

Utilizando o JUnit 5 - Jupiter Asserts:
```
 @Test
 public void deveFalhar_QuandoCadastrarCozinhaSemNome_JUnitJupiter() {
     //cenario
     Cozinha novaCozinha = new Cozinha();
     novaCozinha.setNome(null);
     //ação e validação
     ConstraintViolationException erroEsperado =
             Assertions.assertThrows(ConstraintViolationException.class, () -> {
                 cadastroCozinha.salvar(novaCozinha);
             });
     //validação
     Assertions.assertEquals(ConstraintViolationException.class, erroEsperado.getClass());
 }
```

Utilizando o `assertj` Assertions:

```
 @Test
 public void testarCadastroCozinhaSemNome() {
     //cenario
     Cozinha novaCozinha = new Cozinha();
     novaCozinha.setNome(null);
     
     //ação e validação
     assertThatThrownBy(() -> {
         cadastroCozinha.salvar(novaCozinha);
     }).isInstanceOf(ConstraintViolationException.class).isNotNull();
 }
```

Combinado o JUnit 5 - Jupiter Asserts e `assertj` Assertions:

```
 @Test
 public void testarCadastroCozinhaSemNome() {
     //cenario
     Cozinha novaCozinha = new Cozinha();
     novaCozinha.setNome(null);
     //ação e validação
     ConstraintViolationException erroEsperado =
             Assertions.assertThrows(ConstraintViolationException.class, () -> {
                 cadastroCozinha.salvar(novaCozinha);
             });
     //validação
     assertThat(erroEsperado).isNotNull();
 }
```
</details></li>


<li><details>
<summary>Escrevendo bons nomes de testes ⭐ ⭐ ⭐</summary>

Neste ponto a coisa é meio que livre com relação conveção Java de nomenclatura de métodos, podendo conter separadores,
como um opcional, sem seguir completamente o CamelCase, misturando inglês e português em alguns casos. O mais importante
é adotar um padrão e seguí-lo em todo o projeto. Alguns padrões mais utilizados:
- testar, **_testa_**
`testaCadastroCozinhaSemNome()`
- cadastro, exclusão, **_cadastra, exclui_**
`cadastroCozinhaSemNome()`
- given/when/then
`givenJaExisteCozinhaChinesa_WhenCadastroCozinhaChinesa_ThenDeveFalhar()`
- when/then
`whenCadastroCozinhaComDadosCorretos_ThenDeveAtribuirId()`
- quando/então
`quandoCadastroCozinhaComDadosCorretos_EntaoDeveAtribuirId()`
- should/when
`shouldAtribuirId_WhenCadastrarCozinhaComDadosCorretos()`
- deve/quando (utilizaremos estes)
`deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos()`
####
</details></li>

<li><details>
<summary>Desafio: escrevendo testes de integração ⭐ ⭐ ⭐</summary>

Implementados os métodos de testes:
- deveFalhar_QuandoExcluirCozinhaEmUso
- deveFalhar_QuandoExcluirCozinhaInexistente

Incluí exemplos de uso do JUnit e Assertj.

####
</details></li>

<li><details>
<summary>Rodando os testes pelo Maven (Surefire Maven Plugin) ⭐ ⭐ </summary>

O Maven Surefire Plugin só consegue localizar classes de teste que sigam os seguintes padrões:

- `**/Test*.java`
- `**/*Test.java`
- `**/*Tests.java`
- `**/*TestCase.java`

Do contrário, será necessário incluir **_as classes ou sufixos_** nas configurações do plugin no pom:

```    
<plugins>
   <plugin>
     <groupId>org.apache.maven.plugins</groupId>
     <artifactId>maven-surefire-plugin</artifactId>
     <version>${maven.surefire-plugin.version}</version>
     <configuration>
       <includes>
         <include>MeuTeste.java</include>
       </includes>
     </configuration>
   </plugin>
 </plugins>
```

####
</details></li>

<li><details>
<summary>Configurando Maven Failsafe Plugin no projeto ⭐</summary>

Adicionamos o plugin ao pom:

```
<plugins>
   ...
   <plugin>
       <artifactId>maven-failsafe-plugin</artifactId>
   </plugin>
</plugins>
```

Este plugin, por padrão, identifica as classes de teste cujo sufixo é `IT` (Integration Test).

- `CadastroCozinhaIT`

Desta forma os testes de integração serão executados apenas quando for utilizado `./mvnw verify` e `./mvnw install`. Os 
demais comandos como `./mvnw clean`, `./mvnw package` ou até mesmo `./mvnw test` não rodarão os testes de integração.

####
</details></li>

<li><details>
<summary>Implementando Testes de API com REST Assured e validando o código de status HTTP ⭐</summary>

Apagamos todos testes de integração desenvolvidos anteriormente. E seguiremos com testes de API, end-to-end (considerado
por muitos como um teste de integração também), seguindo todo o fluxo, inclusive passando pelos services e persistência 
testados anteriormente.

Primeiramente adicionamos a dependência do **_REST Assured_** ao pom.xml:

```
<dependency>
   <groupId>io.rest-assured</groupId>
   <artifactId>rest-assured</artifactId>
   <scope>test</scope>
</dependency>
```

Desta vez precisamos do contexto web de pé, por isso a anotação `@SpringBootTest` recebe a definição 
`webEnvironment` determinando a configuração de porta durante o teste. E recuperamos o valor da porta com a anotação 
`@LocalServerPort` para utilizar na chamada feita pelo teste `deveRetornarStatus200_QuandoConsultarCozinhas`:

```
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CadastroCozinhaIT {

    @LocalServerPort
    private int port;

    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        given()
                .basePath("/cozinhas")
                .port(port)
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .statusCode(HttpStatus.OK.value());
    }
}
```

Com a chamada do método `RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();` habilitamos a exibição dos 
detalhes do teste que apresentou falha. Detalhes da requisição, do retorno e corpo da resposta. Isso nos ajuda durante o 
desenvolvimento a identificar o motivo da quebra dos testes quando fazemos algo novo no projeto.

Para que o teste pudesse falhar estimulamos o erro alterando o código de retorno no controller de cozinhas.


####
</details></li>

<li><details>
   <summary>Validando o corpo da resposta HTTP ⭐</summary>

Fizemos outro método de testes que vai consultar as 4 cozinhas cadastradas através do afterMigrate.sql.
Utilizamos a biblioteca `hamcrest` para escrever expressões com regras de correspondencia em objetos, e a classe 
`Matchers` com os métodos `hasSize` e `hasItems` entre outros:

```
 @Test
 public void deveConterQuatroCozinhas_QuandoConsultarCozinhas() {

     RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

     given()
             .basePath("/cozinhas")
             .port(port)
             .accept(ContentType.JSON)
     .when()
             .get()
     .then()
             .body("", Matchers.hasSize(4))
             .body("nome", Matchers.hasItems("Brasileira", "Tailandesa"));
 }
```

####
</details></li>


<li><details>
   <summary>Criando um método para fazer setup dos testes ⭐</summary>

Utilizamos a anotação `@BeforeEach` (@Before JUnit 4 e Spring Boot 2.4.0 para trás) para garantir que o método de callback `setup` seja exceutado antes dos demais métodos
da classe de teste. Desta forma podemos centralizar as configurações que desejamos para o contexto dos nossos testes, deixando o código 
mais limpo também. Neste caso configuramos o `RestAssured`:

```
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CadastroCozinhaIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";
    }

    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas() {

        given()
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveConterQuatroCozinhas_QuandoConsultarCozinhas() {

        given()
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .body("", hasSize(4))
                .body("nome", hasItems("Brasileira", "Tailandesa"));
    }
}
```

####
</details></li>


<li><details>
   <summary>Entendendo o problema da ordem de execução dos testes ⭐</summary>

Criamos um teste `deveRetornarStatus201_QuandoCadastrarCozinha`, desta vez enviando um payload com a Cozinha a ser
cadastrada e utilizando o método HTTP post. Foi necessário também incluir o `.contentType(ContentType.JSON)` no 
`RestAssured.given()`. O problema agora é que já tinhamos um teste que verificava a quantidade de cozinhas cadastradas. 
Isso nos faz levantar um ponto importante:

Os testes não devem ter dependência entre si, eles precisam ser independentes!

####
</details></li>


<li><details>
   <summary>Voltando o estado inicial do banco de dados para cada execução de teste com callback do Flyway ⭐ ⭐</summary>

Para garantir o contexto que queremos em que cada teste vai rodar, sem correr o risco de um teste mudar o contexto de outro.
Uma das formas tirarmos proveito da anotação `@BeforeEach`, e deixar o flyway limpar o banco e adicionar os dados que 
queremos antes de **cada teste**, adicionando o `flyway.migrate();` no método de configuração:

```
 @BeforeEach
 public void setup() {
     RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
     RestAssured.port = port;
     RestAssured.basePath = "/cozinhas";

     flyway.migrate();
 }
```

Pode ser uma boa prática deixar um afterMigrate.sql isolado no pacote de testes para não misturarmos o contexto de uso. 
Já que que o afterMigrate.sql do pacote `main\resources` tem como finalidade simular massa real durante o desenvolivmento,
e não servir de massa para testes automatizados de integração/API.

####
</details></li>

<li><details>
   <summary>Configurando um banco de testes e usando @TestPropertySource ⭐ ⭐</summary>

Configuramos uma nova base de dados apenas para testes, desta forma os testes automatizados de integração/API podem rodar
de forma independente dos ambiente de Desenvolvimento, Homologação, Produção. 

Foi criado o arquivo `application-test.properties` no pacote `test\resources`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/algafood_test?createDatabaseIfNotExist=true&serverTimeZone=UTC
spring.datasource.username=xxxxxx
spring.datasource.password=xxxxxx

spring.flyway.locations=classpath:db/migration

spring.datasource.hikari.maximum-pool-size=1

spring.output.ansi.enabled=ALWAYS
```

E na classe de teste adicionamos a anotação `@TestPropertySource("/application-test.properties")`, desta forma será 
utilizado o banco de dados de testes ao invés do principal:

```
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {

    @LocalServerPort
    private int port;

    @Autowired
    Flyway flyway;
...
```


Por enquanto o teste que verifica se existem 4 cozinhas falha, por conta da nova base de dados.

####
</details></li>


<li><details>
   <summary>Limpando e populando o banco de dados de teste ⭐ ⭐</summary>

Primeiramente deixamos de utilizar o flayway na classe de teste, vez que isolamos a base de dados de teste.

O instrutor disponibilizou uma classe de limpeza para a base de dados de teste, se preocupando em limpar apenas bases 
com sufixo `test`, como medida de segurança. Além de evitar a limpeza da tabela de histórico do flyway `"flyway_schema_history"` 
para evitar problemas no processo de recriação da base.

Agora limpamos os dados no setup da classe de teste, chamando o método `databaseCleaner.clearTables();`. E incluímos os dados 
manualmente através do novo método `prepararDados()`. E isso se repetirá antes da execução de cada teste.

####
</details></li>

<li><details>
   <summary>Testando endpoint passando parâmetro de URL ⭐ ⭐</summary>

Utilizamos o RestAssured passando parâmetro de URL utilizando o `.pathParams("cozinhaId", 2)`. Indicamos a passagem dele 
na URL indicando o mesmo nome de variável `.get("/{cozinhaId}")` e validamos o campo do corpo de retorno
com o `.body("nome", equalTo("Brasileira"));` do Matchers da biblioteca `hamcrest`:

```
 @Test
 public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaInexistente() {
     given()
             .pathParams("cozinhaId", 2)
             .accept(ContentType.JSON)
     .when()
             .get("/{cozinhaId}")
     .then()
             .statusCode(HttpStatus.OK.value())
             .body("nome", equalTo("Brasileira"));
 }
```


####
</details></li>

<li><details>
   <summary>Desafio: refatorando o código de testes ⭐ ⭐</summary>

Utilizamos a classe proposta pelo instrutor para leitura de arquivo contendo a nossa massa de teste.

Refatoramos a classe de teste criando constantes, variável de instância para guardar atributos de `cozinhaBrasileira` para
recuperar nome e id nos métodos, consultando a quantidade de cozinhas para deixar de forma dinamica no
método que testa a aquantidade correta de cozinhas.

Criamos um arquivo json contendo o caso sendo testado `cozinha-chinesa.json`.

####
</details></li>

<li><details>
   <summary>Desafio: escrevendo testes de API ⭐ ⭐</summary>

De forma geral devemos testar (teste de integraçao) apenas aquilo que agrega valor. 

Apenas para garantir e preservar o que já foi desenvolvido de mais importante, que não possa quebrar.

Testes para validar que o contrato (definição campos e content negotiation) não vá quebrar.

Deve testar **"caminhos felizes e infelizes"**.

Foram desenvolvidos os testes de integração para consulta (GET) e cadastro (POST) de restaurantes, com arquivos `.json`
simulando o envio de payloads de sucesso e falha para nosso recurso.

####
</details></li>

</ol>
</details>

<details open>
    <summary><i>11. Boas práticas e técnicas para APIs</i> ⭐</summary>
<ol>

<li><details>
   <summary>Analisando e definindo melhor o escopo das transações ⭐ ⭐</summary>

Por boa prática, foi utilizado `@Transactional`, uso é recomendado em qualquer metódo que altere o estado da base de dados, 
principalmente quando o processo é mais complexo e contém ou depende de diversas gravações em banco.

####
</details></li>

<li><details>
   <summary>Refinando o payload de cadastro com @JsonIgnoreProperties ⭐ ⭐</summary>

Ao registrar ou alterar um Restaurante (`/restaurantes`) passando uma propriedade que não existe em Cozinha, recebemos o 
Problem Details correto, apresentando: 
```
{
    "status": 400,
    "type": "https://algafood.com.br/mensagem-incompreensivel",
    "title": "Mensagem incompreensível",
    "detail": "A propriedade 'cozinha.sadfsda' não existe. Corrija ou remova essa propriedade e tente novamente.",
    "userMessage": "Ocorreu um erro interno no sistema. Tente novamente e se o problema persistir, entre em contato com o administrador do sistema",
    "timeStamp": "2023-10-15T01:05:37.8429979"
}
```
Porém, quando passamos uma propriedade cujo nome de fato existe na estrutura do objeto, como `nome`, no caso de Cozinha, 
a API ignora o envio do campo e, incorretamente, permite o registro do recurso. E se tentarmos anotarmos a propriedade 
`nome` dentro de cozinha com `@JsonIgnore`, não consiguiremos utilizar e registro e alteração do recurso `/cozinhas`.

Para corrigir esta situção, anotamos com `@JsonIgnoreProperties(value = "nome")` a propriedade `cozinha` dentro de Restaurante.
Para ter o mesmo comportamento do `@JsonIgnore`, porém **apenas no fluxo de registro e alteração de Restaurante**. 

Agora se eviarmos o campo `nome` da `cozinha` junto no registro ou alteração (`/restaurantes`), temos o mesmo comportamento 
como se o campo não existisse:
```
{
    "status": 400,
    "type": "https://algafood.com.br/mensagem-incompreensivel",
    "title": "Mensagem incompreensível",
    "detail": "A propriedade 'cozinha.nome' não existe. Corrija ou remova essa propriedade e tente novamente.",
    "userMessage": "Ocorreu um erro interno no sistema. Tente novamente e se o problema persistir, entre em contato com o administrador do sistema",
    "timeStamp": "2023-10-15T01:08:56.8923763"
}
```

Entretanto, após realizar as correções anteriores, ao consultarmos um ou mais restaurantes, o campo `nome` da cozinha não 
é mais apresentado: 
```
{
    "id": 1,
    "nome": "Thai Gourmet",
    "taxaFrete": 10.00,
    "cozinha": {
        "id": 1
    }
}
```

Para corrigir este novo problema incluímos `allowGetters = true` na anotação `@JsonIgnoreProperties`, ficando 
`@JsonIgnoreProperties(value = "nome", allowGetters = true)` sobre a propriedade cozinha da classe Restaurante. Que passou
a retornar:
```
{
    "id": 1,
    "nome": "Thai Gourmet",
    "taxaFrete": 10.00,
    "cozinha": {
        "id": 1,
        "nome": "Tailandesa"
    }
}
```

Desta forma na desserialização do JSON (montagem), o Jackson consegue entender que o campo `nome` deve ser considerado, 
devido o `allowGetters = true`. Enquanto na serialização do JSON será ignorado, devido a `@JsonIgnoreProperties`.

####
</details></li>

<li><details>
   <summary>Criando classes de mixin para usar as anotações do Jackson ⭐ ⭐</summary>

As anotações `@JsonIgnoreProperties` e `@JsonIgnore` buscam customizar os Representation Models tanto para serialização,
quanto para desserialização. 

Ficamos na situação em que, caso tenhamos classes que não fazem parte do nosso código para customizar, não será possível 
anotá-las, impossiblitando o uso das últimas abordagens. Ou se queremos separar questões de domínio com comportamento 
de API.

Para superar estes problemas utilizamos classes mixin, serve como um espelho da classe de domínio e centraliza em si 
responsabilidade de ser a representação do modelo de domínio.

Para isso retiramos as anotações Jackson das propriedades da classe Restaurante. E criamos a classe `RestauranteMixin`, que 
espelha apenas estes campos que tinham as anotações:

```
public class RestauranteMixin {

    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Cozinha cozinha;

    @JsonIgnore
    @Embedded
    private Endereco endereco;

    @JsonIgnore
    private LocalDateTime dataCadastro;

    @JsonIgnore
    private LocalDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();
}
```

Criamos a classe de componente `JacksonMixinModel` que estende a `SimpleModule` da Jackson e cria a relação entre as 
Classes:
```
@Component
public class JacksonMixinModel extends SimpleModule {

    public JacksonMixinModel() {
        super.setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
    }
}
```

Agora, ao descomentar as propriedades anotadas com `@JsonIgnore` ou `@JsonIgnoreProperties` na classe mixin, o modelo de 
representação na API será alterado sem a necessidade de alterar a classe de modelo de domínio que ficará mais limpa.

####
</details></li>

<li><details>
   <summary>Desafio: usando @JsonIgnoreProperties e Jackson Mixin ⭐ ⭐</summary>

Corrigindo o recurso de `/cidades`, que aceita o envio do nome do estado no registro e alteração, para deixar de aceitar.

E criar **classes abstratas mixin** para os recursos que utilizam anotações da @Jackson.

####
</details></li>


<li><details>
   <summary>Antes de estudar sobre data/hora: relembrando as aulas de geografia e entendendo os fusos horários ⭐ ⭐</summary>


Com relação a termos:

Time Zone - Fuso horário

Offset - deslocamento/diferença

UTC - Padrão de horário universal (mantido por relógios atômicos)

GMT - Greenwich Mean Time - um fuso horário sem offset com relação a UTC

BRT - Padrão nacional BRT=UTC-3

AMT - Padrão Amazônia AMT=UTC-4

ACT - Padrão do Acre ACT=UTC-5


Horário de verão acrescenta o ST (Summer Time):

BRST = UTC-2
AMST = UTC-3
ACST = UTC-4

Dependendo de quais lugares aderirem à questão

####
</details></li>

<li><details>
   <summary>Boas práticas para trabalhar com data e hora em REST APIs ⭐ ⭐</summary>


Padrões de data dd/mm/aaaa pode gerar confusão devido à diversidade de padrões de formatação e região

Então **para se trabalhar com datas recomenda-se seguir as 5 leis**:

1. Utilize ISO-8601 para formatar data/hora (padrão bem flexível para representar):

   2019-10-12T14:15:38-03:00 _(Corresponde ao fuso horário de Brasília, BRT)_

   2019-10-12T14:15:38Z _(Corresponde ao fuso horário GMT, ou seja, UTC)_
   
   Desta forma é possível calcular a hora a apresentar de acordo com a localização do cliente.

####
2. Aceite qualquer fuso horário na API:

   Ou seja a API deve aceitar e converter para o fuso horário em uso na aplicação.
####
3. Armazene em UTC:

   Sempre armazenar data e hora sem nenhum offset na base de dados. Evita problemas e mudança de horário e localização.
####
4. Retorne em UTC:

   O Consumider precisa ter liberdade para determinar o fuso em que os dados serão apresentados fazendo a conversão com 
base em UTC.
####
5. Não inclua o horário, se não for necessário:

   **_Isso evita que o valor possa ser convertido para outro dia após conversões_**.

   Como este caso em que se refere a mesma data em fusos diferentes:

   2023-10-20T23:59:00Z - UTC Europa

   2323-10-21T04:59:00+05:000 - UTC+5 Rússia

####
</details></li>


<li><details>
   <summary>Configurando e refatorando o projeto para usar UTC ⭐ ⭐</summary>

A aula proprõe modificar o `afterMigration.sql` de utc_timestamp (o correto) para current_timestamp (geralmente utilizado, 
mas incorreto), na intensão de replicar um cenário com problemas.

Sem as alterações o projeto já gravava em UTC na base de dados.

Após a substituição dos tipos acima e retirar `&serverTimeZone=UTC` do application.properties, os dados carregados do 
`afterMigration.sql` ainda são corregados como UTC, ou seja, com horário do PC +3. Porém, ao fazer um novo cadastro de 
restaurante via API, ele já era gravado com o horário do PC, ou seja, sem UTC.


Configuramos o driver jdbc do MySQL para converter data e hora para UTC, ou seja, devolvemos a configuração `&serverTimeZone=UTC`
ao `application.properties` e o tipo `utc_timestamp` aos campos de data do `afterMigration.sql`. Logo, **até mesmo** os 
novos registros no banco de dados foram gravados em UTC, porém uma divergência entre o payload de retorno do registro do 
novo restaurante e a consulta do recurso:

O retorno do cadastro pega a hora do meu fuso horário e um offset(-):

```
{
    "id": 7,
    "nome": "Recanto da Pamonha",
    "taxaFrete": 10,
    "cozinha": {
        "id": 4,
        "nome": "Brasileira"
    },
    "dataCadastro": "2023-10-26T01:02:55.178836-03:00",
    "dataAtualizacao": "2023-10-26T01:02:55.178836-03:00"
}
```

Enquanto a consulta pega o horário UTC (sem fuso horário):

```
{
    "id": 7,
    "nome": "Recanto da Pamonha",
    "taxaFrete": 10.00,
    "cozinha": {
        "id": 4,
        "nome": "Brasileira"
    },
    "dataCadastro": "2023-10-26T04:02:55Z",
    "dataAtualizacao": "2023-10-26T04:02:55Z"
}
```

Para resolver o problema poderíamos mudar o fuso horário da máquina de BRT para UTC, ou, alterar na aplicação. Optamos 
pela alteração na aplicação, assim independente de onde ela rode utilizará UTC, ou seja, três horas à frente do fuso horário
local (BRT). 

Na classe principal da aplicação incluímos a configuração de TimeZone ``TimeZone.setDefault(TimeZone.getTimeZone("UTC"));``:

```
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRespositoryImpl.class)
@SpringBootApplication
public class AlgafoodApiApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(AlgafoodApiApplication.class, args);
	}

}
```


Ficando da seguinte forma no retorno do cadastro onde são ```01:15:31``` da manhã:

```
{
    "id": 8,
    "nome": "Recanto da Pamonha",
    "taxaFrete": 10,
    "cozinha": {
        "id": 4,
        "nome": "Brasileira"
    },
    "dataCadastro": "2023-10-26T04:15:31.42286Z",
    "dataAtualizacao": "2023-10-26T04:15:31.42286Z"
}
```

Na consulta:

```
{
    "id": 8,
    "nome": "Recanto da Pamonha",
    "taxaFrete": 10.00,
    "cozinha": {
        "id": 4,
        "nome": "Brasileira"
    },
    "dataCadastro": "2023-10-26T04:15:31Z",
    "dataAtualizacao": "2023-10-26T04:15:31Z"
}
```

E no Banco de dados já em UTC:

```2023-10-26 04:15:31```

**O ponto principal é _sempre utilizar UTC_. Se considerarmos a implantação em cloud de alta disponibilidade com vários 
datacenters espalhados em vários fusos horários, ou até mesmo nos casos de aplicações de uso exclusivamente nacional, onde 
já são 4 fusos horários diferentes.** 

####
</details></li>

<li>Desafio: refatorando o código para usar OffsetDateTime ⭐ ⭐</li>


<li><details>
   <summary>Isolando o Domain Model do Representation Model com o padrão DTO ⭐ ⭐</summary>

Ao misturar classes de domínio com classes de representação da API (Representation Model), podemos ter problemas na 
manutenção, pois, pode ter a necessidade uma propriedade aparecer num recurso e em outro não. Ou até mesmo alterar o 
domain model a acabar compromentendo o comportamento da API. Já que pode ser necessário criar uma saída customizada no seu 
recurso que tenha mais campos do que o domain.

Seja para omitir propriedades ou para expor alguma, não é uma boa prática acumular a responsabilidade de representação 
no domain model.

Logo é importante separar as responsabilidades, deixando a representação para um DTO que pode acumular a representação de 
uma ou mais classes, de acordo com a necessidade.

Quando utilizar DTOs? Utilizar em todos os casos ou não?

Pelo que observei da opnião do instrutor, é que o ideal é ser consistente. Ou usa em tudo (o que é mais consistente), 
ou não usa (quando em fase de protótipo). 

O mais recomendado é utilizar e evitar expor tudo no retorno da API, podendo isolar as anotações do Jackson. 
É mais trabalhoso, mas tras mais segurança ao fazer a manutenção do projeto, ajuda a assegurar
a integridade da API.

Trata-se de mais uma polêmica na "Bolha Dev". 


####
</details></li>


<li><details>
   <summary>Implementando a conversão de entidade para DTO ⭐ ⭐</summary>

Por enquanto fizemos o parse manualmente dos valores do domínio para o representation model em todos os métodos do controller 
de restaurante.

####
</details></li>

<li><details>
   <summary>Criando DTOs para entrada de dados na API ⭐ ⭐</summary>

Seguindo a mesma motivação da criação do DTO RestauranteModel, criaremos uma representação de entrada. Evitando as anotações
no Jackson no dominio ou classes mixin. Já que nem sempre são iguais os modelos de representação de entrada e saída.

Mas isso é uma questão de abordagem, podendo variar de acordo com o propósito do desenvolvedor.

Inclusive podemos ter diversos modelos de representação de saída para o mesmo recurso.

As validações bean validation agora estão nas classes DTO de entrada. As que ficaram nas classes de domínio serão retiradas.
Para sistemas em que existem outras interfaces de cadasto na aplicação além da web API, por exemplo, o processamento de arquivos, 
então deve-se manter as anotações de bean validation nas classes de domínio também. O ponto negativo é código duplicado, caso decida manter no domínio também.

No nosso caso, vamos remover do domínio.

**_Já presenciei desenvolvedores deixam as anotações
na classe de domínio como forma de "documentar" e deixar explicita a regra de input para outros devs_**

**_Foi o suporte a atualização parcial do controller de Restaurente._**

####
</details></li>

<li><details>
   <summary>Refatorando e criando um assembler de DTO ⭐ ⭐</summary>

Retiramos a classe mixin `RestauranteMixin` pois utilizamos os DTOs customizamos e os campos que temos interesse já estão 
nessas classes, e por isso é desnecessário o uso do `@JsonIgnore` na classe mixin.

Podemos encontrar este padrão com nomenclatura de Assembler, Converter, DTOToEntity e ToEntity. 
No caso utilizaremos o Assembler.

####
</details></li>

<li>Desafio: Refatorando e criando um disassembler do DTO ⭐ ⭐</li>

<li><details>
   <summary>Adicionando e usando o ModelMapper ⭐ ⭐</summary>

O código repetitivo "boiller plate" de gets e sets ao transformar um objeto em outro, como RestauranteInput para a classe de 
domínio Restaurante.

O ModelMapper faz o mapeamento e conversão de objetos. Para utilizar substituimos a implementação dos Assemplers e 
Disassemblers dos DTOs por:
 
toModel:
`return modelMapper.map(restaurante, RestauranteModel.class);`

toDomain:
`return modelMapper.map(restauranteInput, Restaurante.class);`


####
</details></li>

<li><details>
   <summary>Entendendo a estratégia padrão do ModelMapper para correspondência de propriedades ⭐ ⭐ ⭐</summary>

Caso os nomes tenham alguma correspondencia, a passagem de valor para as propriedades de destino ocorrerá automaticamente. 
Este comportamento se estende a propriedades que não são de tipos primitivos também, deste modo, podemos passar dados de 
dentro de **um objeto** diretamente para tipos primitivos, inclusive, podendo passar o mesmo valor para várias propriedades diferentes, 
apenas tirando proveito deste comportamento de correspondencia de nomes. 

ex:
- Origem:
```
@ValorZeroIncluiDescricao(valorField = "taxaFrete", descricaoField = "nome", descricaoObrigatoria = "Frete Grátis")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank
    @Column(nullable = false)
    private String nome;

//    @NotNull
//    @PositiveOrZero
    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

//    @Valid
//    @ConvertGroup(to = Groups.CozinhaId.class)
//    @NotNull
    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false) //"num_idt_cozinha" definindo nome da coluna
    private Cozinha cozinha;

...
```


- Destino:
```
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestauranteModel {

    private Long id;

    private String nome;

    private BigDecimal frete;

    private CozinhaModel cozinha;

    private String idCozinha;

    private String nomeCozinha;
}
```

Indo mais a fundo, todos os tokens das propriedade de destino devem corresponder as propriedades de origem.
Além disso a ordem dos tokens não precisa ter correspondência.
O nome da propriedade de origem deve ter ao **menos um token** de correspondência com a de destino.

Como no exemplo:

RestauranteModel:
```
public class RestauranteModel {

    private Long id;

    private String nome;

    private BigDecimal frete;

    private CozinhaModel cozinha;

    /*
    * É dividido em Tokens
    * Origem: cozinha, nome
    * Destino: nome, cozinha
    *
    */
    private String nomeCozinha;
    private String idCozinha;
}
```

CozinhaModel:
```
public class CozinhaModel {

    /*
     * É dividido em Tokens
     * Origem: cozinha, nome
     * Destino: cozinha, cozinha, nome (dois tokens de cozinhas por estar dentro do RestauranteModel)
     *
     */

    private Long id;
    private String cozinhaNome;
}
```
####
</details></li>

<li><details>
   <summary>Customizando o mapeamento de propriedades com ModelMapper ⭐ ⭐</summary>

Quando temos propriedades cujos nomes não possuem correspondência, precisamos de alguma forma para "forçar" o ModelMapper
a passar o valor de um objeto para outro de forma customizada.

Se alterarmos o nome do `frete` do `RestauranteModel` para `precoFrete` passamos a receber null nesta propriedade
como no exemplo abaixo:
```
{
    "id": 6,
    "nome": "Bar da Maria",
--> "precoFrete": null,
    "cozinha": {
        "id": 4,
        "cozinhaNome": "Brasileira"
    },
    "nomeCozinha": "Brasileira",
    "idCozinha": "4"
}
```

Para solucionar o problema devemos customizar o `ModelMapperConfig` alteramos o bean do `ModelMapper` passando os
métodos que devem ter correspondência:
```
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
                .addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);
        return modelMapper;
    }
}
```

Passando a retornar com o conteúdo:
```
{
    "id": 6,
    "nome": "Bar da Maria",
    "precoFrete": 6.00,
    "cozinha": {
        "id": 4,
        "cozinhaNome": "Brasileira"
    },
    "nomeCozinha": "Brasileira",
    "idCozinha": "4"
}
```
####
</details></li>


<li><details>
   <summary>Mapeando para uma instância destino (e não um tipo) com ModelMapper ⭐ ⭐</summary>

O ModelMapper possui diversas sobrecargas do método `map`, esta que utilizamos é para copiar as propriedades de uma
instância de origem para outra instância de destino e tipo diferente:

```
 public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {
     modelMapper.map(restauranteInput, restaurante);
 }
```
Como a classe de origem só tem propriedades obrigatórias a classe destino não receberá nenhum campo nulo. Diferente de
quando usávamos o `BeanUtils` e o modelo de domínio, onde precisávamos lembrar de especificar quais campos deveriam
ser ignorados ao fazer a cópia:
```
BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro");
```


Com essas mudanças no código, ficamos com um erro ao fazer uma alteração de restaurante ao alterar o `id` da cozinha,
recebemos um código de retorno `500`, e a seguinte exception:
```
org.springframework.orm.jpa.JpaSystemException: identifier of an instance of com.algaworks.algafood.domain.model.Cozinha was altered from 2 to 1
```

Isso ocorre porque tentamos alterar o id de uma entidade que está gerenciada pelo JPA. Para solucionar o problema modificamos
o método para passar uma nova instância de `Cozinha` ao restaurante antes de fazer a cópia pelo ModelMapper:
```
public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {
  restaurante.setCozinha(new Cozinha());           <--
  modelMapper.map(restauranteInput, restaurante);
}
```
####
</details></li>

<li><details>
   <summary>Revisando e ajustando as mensagens de validação com o uso de DTOs ⭐ ⭐</summary>

Por conta da alteração do modelo de entrada, de `Restautante` (que era um modelo de domínio) para `RestauranteInput` (que 
é um modelo de representação) precisamos substituir o `messages.properties`, para que as mensagens de validação fiquem de 
acordo.

Ficando da seguinte forma:

```
NotBlank={0} é obrigatório.
NotNull={0} é obrigatório.
PositiveOrZero={0} deve ser um valor maior ou igual a zero.
Multiplo={0} deve ser um valor múltiplo de {1}.
ValorZeroIncluiDescricao={1} deve conter {2} na descriçção devido {3}.

#Possibilidade de usos:
#jakarta.validation.constraints.PositiveOrZero.message={0} deve ser um número positivo que seja maior ou igual a O.
TaxaFrete.invalida={0} está inválida.


#Cozinha
cozinha.nome=Nome da cozinha
cozinha.id=Código da cozinha

#Restaurante
NotNull.restauranteInput.taxaFrete={0} é obrigatória.
NotNull.restauranteInput.cozinha={0} é obrigatória.
restauranteInput.taxaFrete=Taxa frete do restaurante
restauranteInput.cozinha=Cozinha do restaurante

restauranteInput.nome=Nome do restaurante

#Estado
estado.id=Código do estado
estado.nome=Nome do estado

#Cidade
cidade.nome=Nome da cidade
cidade.estado=Estado da cidade



```
####
</details></li>

<li><details>
<summary>Estratégias de nomes de propriedades: snake case vs lower camel case ⭐ ⭐</summary>

**lowerCamelCase** ou **lower_snake_case**

Podemos configurar o Spring para converter o padrão dos modelos para lower_snake_case através do `application.properties`
com a seguinte configuração:
```
spring.jackson.property-naming-strategy=SNAKE_CASE
```

De qualquer forma, foi definido que será mantido no projeto o padrão **lowerCamelCase**, visto que JSON (JavaScript Object 
Notation) vem do JavaScript e a convenção desta linguagem define este padrão para nomes de propriedades.

####
</details></li>

</ol>
</details>