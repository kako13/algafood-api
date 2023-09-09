![Readme Card](https://github-readme-stats.vercel.app/api/pin?username=kako13&repo=algafood-api&show_icons=true&theme=codeSTACKr&hide_border=true&bg_color=00000000)
####

<details>
  <summary><i>02 - Spring e Injeção de Dependências</i></summary>

1. Por que aprender e usar Spring?
2. Conhecendo o ecossistema Spring
3. Spring vs Jakarta EE (Java EE)
4. Conhecendo o Spring Boot
5. [Criando um projeto Spring Boot com Spring Initializr](https://start.spring.io)
6. Conhecendo o Maven e o pom.xml de um projeto Spring Boot
7. Criando um controller com Spring MVC (Hello World!)
8. Restart mais rápido da aplicação com DevTools
9. [O que é injeção de dependências?](https://github.com/kako13/exemplo-di)
10. Conhecendo o IoC Container do Spring
11. Definindo beans com @Component
12. Injetando dependências (beans Spring)
13. Usando @Configuration e @Bean para definir beans
14. Conhecendo os pontos de injeção e a anotação @Autowired
15. Dependência opcional com @Autowired
16. Ambiguidade de beans e injeção de lista de beans
17. Desambiguação de beans com @Primary em um dos beans
18. Desambiguação de beans com @Qualifier
19. Desambiguação de beans com anotação customizada ⭐
20. Mudando o comportamento da aplicação com Spring Profiles (de ambiente à seleção implementações) ⭐
<details>
  <summary><i>21. Criando métodos de callback do ciclo de vida dos beans</i></summary>

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
</details>

22. Publicando e consumindo eventos customizados ⭐
23. Configurando projetos Spring Boot com o [application.properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)
24. Substituindo propriedades via linha de comando e variáveis de ambiente
25. Criando e acessando propriedades customizadas com @Value
26. Acessando propriedades com @ConfigurationProperties
27. Alterando a configuração do projeto dependendo do ambiente (com Spring Profiles) ⭐
<details>
    <summary>28. Ativando o Spring Profile por linha de comando e variável de ambiente</summary>

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
</details>
</details>
<details>
  <summary><i>03 - Introdução ao JPA e Hibernate</i></summary>

1. Instalando o MySQL Server e MySQL Workbench (adotei o docker-compose.yaml)
2. O que é JPA e Hibernate
3. Adicionando JPA e configurando o Data Source
4. Mapeando entidades com JPA
5. Criando as tabelas do banco a partir das entidades
6. Mapeando o id da entidade para autoincremento
7. Importando dados de teste com import.sql
8. Consultando objetos do banco de dados
9. Adicionando um objeto no banco de dados
10. Buscando um objeto pelo id no banco de dados
11. Atualizando um objeto no banco de dados
12. Excluindo um objeto do banco de dados
13. Conhecendo o padrão Agregate do DDD
14. Conhecendo e implementando o padrão Repository (por agregate)
15. Conhecendo e usando o Lombok
16. Desafio: Lombok e repositório de restaurantes
17. Mapeando relacionamento com @ManyToOne e Dialeto
18. A anotação @JoinColumn (para nomear coluna de FK)
19. Propriedade nullable de @Column e @JoinColumn
20. Desafio: mapeando entidades (Forma Pagamento, Permissão, Cidade e Estado)
</details>
<details>
  <summary><i>04 - REST com Spring</i></summary>

1. O que é REST?
<details>
    <summary>2. Conhecendo as constraints do REST</summary>

- Cliente-servidor
- Sistema em camadas (desconhecida pelo cliente)
- Stateless
- Cache
- Interface uniforme
- Código sob demanda

</details>

3. Diferença entre REST e RESTful
4. Desenvolvedores de REST APIs puristas e pragmáticos
5. Conhecendo o protocolo HTTP
6. Usando o protocolo HTTP
7. Instalando e testando o Postman
<details>
    <summary>8. Entendendo o que são Recursos REST</summary>

- Singleton Resource
- Collection Resource

</details>

9. Identificando recursos REST
10. Modelando e requisitando um Collection Resource com GET
11. Desafio: collection resource de estados
12. Representações de recursos e content negotiation
13. Implementando content negotiation para retornar JSON e/ou XML
14. Consultando Singleton Resource com GET e @PathVariable
15. Customizando as representações XML e JSON com @JsonIgnore, @JsonProperty e @JsonRootName (Jackson para JSON e XML)
16. Customizando a representação em XML com Wrapper e anotações do Jackson
17. Conhecendo os métodos HTTP
18. Conhecendo os códigos de status HTTP
19. Definindo o status da resposta HTTP com @ResponseStatus
20. Manipulando a resposta HTTP com ResponseEntity
21. Corrigindo o Status HTTP para resource inexistente
22. Status HTTP para collection resource vazia: qual usar?
23. Modelando e implementando a inclusão de recursos com POST
24. Negociando o media type do payload do POST com Content-Type
25. Modelando e implementando a atualização de recursos com PUT
26. Modelando e implementando a exclusão de recursos com DELETE
27. Implementando a camada de domain services (e a importância da linguagem ubíqua)
28. Refatorando a exclusão de cozinhas para usar domain services
29. Desafio: modelando e implementando a consulta de recursos de restaurantes
30. Modelando e implementando a inclusão de recursos de restaurantes
31. Desafio: Modelando e implementando a atualização de recursos de restaurantes
32. Desafio: implementando serviços REST de cidades e estados
33. Analisando solução para atualização parcial de recursos com PATCH
34. Finalizando a atualização parcial com a API de Reflections do Spring
35. Introdução ao Modelo de Maturidade de Richardson (RMM)
36. Conhecendo o nível 0 do RMM (POX - Plain Old XML; podendo ser também em JSON)
37. Conhecendo o nível 1 do RMM (identificação de recursos)
38. Conhecendo o nível 2 do RMM (nível 1 + Verbos e códigos de Status HTTP; é o mais comum no mercado)
39. Conhecendo o nível 3 do RMM (nível 2 + HATEOS)

</details>

<details open>
    <summary>05. Super poderes do Spring Data JPA</summary>

1. Implementando consultas JPQL em repositórios
2. Conhecendo o projeto Spring Data JPA (SDJ)
3. Criando um repositório com Spring Data JPA (SDJ)
4. Refatorando o código do projeto para usar o repositório do SDJ
5. Desafio: refatorando todos os repositórios para usar SDJ
6. Criando consultas com query methods
7. [Usando as keywords para definir critérios de query methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
<details>
<summary>8. Conhecendo os prefixos de query methods</summary>

- prefixos de consulta (find, get, read, stream, query)
- prefixo booleano (exists)
- totalizador (count)
- flags de limite (first, last, top2)

</details>

9. Usando queries JPQL customizadas com @Query
10. Externalizando consultas JPQL para um arquivo XML ⭐


<details>
<summary>11. Implementando um repositório SDJ customizado ⭐</summary>
    
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

</details>

12. Implementando uma consulta dinâmica com JPQL
13. Implementando uma consulta simples com Criteria API
14. Adicionando restrições na cláusula where com Criteria API
15. Tornando a consulta com Criteria API com filtros dinâmicos ⭐
16. Conhecendo o uso do padrão Specifications (DDD) com SDJ ⭐
17. Implementando Specifications com SDJ ⭐
18. Criando uma fábrica de Specifications ⭐

#
###### *Utilizando o Spring na versão 3.1.3 e Java na versão 17, não é possível capturar a exception 'EmptyResultDataAccessException' ao tentar excluir uma entidade inexistente. Ajustes foram necessários.*

</details>

