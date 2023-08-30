# algafood-api
Repositório destinado ao conteúdo desenvolvido durante o curso Algaworks - Especialista Spring Rest

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
</details>

