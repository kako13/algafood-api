![Readme Card](https://github-readme-stats.vercel.app/api/pin?username=kako13&repo=algafood-api&show_icons=true&theme=codeSTACKr&hide_border=true&bg_color=00000000)
####

<details>
  <summary><i>02 - Spring e Injeção de Dependências</i></summary>
<ol>

<li>Por que aprender e usar Spring?</li>
<li>Conhecendo o ecossistema Spring</li>
<li>Spring vs Jakarta EE (Java EE)</li>
<li>Conhecendo o Spring Boot</li>
<li>[Criando um projeto Spring Boot com Spring Initializr](https://start.spring.io)</li>
<li>Conhecendo o Maven e o pom.xml de um projeto Spring Boot</li>
<li>Criando um controller com Spring MVC (Hello World!)</li>
<li>Restart mais rápido da aplicação com DevTools</li>
<li>[O que é injeção de dependências?](https://github.com/kako13/exemplo-di)</li>
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
<li>Configurando projetos Spring Boot com o [application.properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)</li>
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
<li>[Usando as keywords para definir critérios de query methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)</li>
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
<li>Mapeando propriedades com @CreationTimestamp e @UpdateTimestamp</li>
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

As consultas dos relacionamentos são carregos conforme o uso, ou seja, sob demanda.

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
<li>Configurando o pool de conexões do Hikari</li>
<li>Schema generation em produção não é uma boa prática</li>
<li>Flyway: ferramenta de versionamento de schemas de banco de dados (incremental)</li>
<li>Adicionando o Flyway no projeto e criando a primeira migração</li>


</ol>
</details>

