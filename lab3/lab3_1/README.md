## lab3_1

### a) Identify a couple of examples that use AssertJ expressive methods chaining.

Podemos observar o uso do AssertJ, por exemplo, na classe **E_EmployeeRestControllerTemplateIT**, no caso do código abaixo, no método *givenEmployees_whenGetEmployees_thenStatus200()*:
    
``` java
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");
```

### b) Identify an example in which you mock the behavior of the repository (and avoid involving a database).

Podemos observar esta utilização do Mockito na classe **B_EmployeeService_UnitTest**, no método inicial *setUp()*:
    
``` java
@Mock( lenient = true)
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {

        //these expectations provide an alternative to the use of the repository
        Employee john = new Employee("john", "john@deti.com");
        john.setId(111L);

        Employee bob = new Employee("bob", "bob@deti.com");
        Employee alex = new Employee("alex", "alex@deti.com");

        List<Employee> allEmployees = Arrays.asList(john, bob, alex);

        Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);
        Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
        Mockito.when(employeeRepository.findByName("wrong_name")).thenReturn(null);
        Mockito.when(employeeRepository.findById(john.getId())).thenReturn(Optional.of(john));
        Mockito.when(employeeRepository.findAll()).thenReturn(allEmployees);
        Mockito.when(employeeRepository.findById(-99L)).thenReturn(Optional.empty());
    }
``` 

### c) What is the difference between standard @Mock and @MockBean?

Ambas são anotações usadas para testes, mas a *@Mock* pertence ao Mockito e a *@MockBean* pertence ao Spring Boot. 
**@Mock** é a anotação para *Mockito.Mock()* e permite-nos criar objetos simulados para testar o comportamento de classes ou interfaces. Já a **@MockBean** é usada quando queremos criar um mock de um objeto inserido no contexto do Spring Boot, sendo que se existir um bean, este será substituído pelo mock.

-> Basicamente, o **@Mock** é principalmente usado para testes unitários quando queremos criar um mock de um objeto, enquanto o **@MockBean** é usado para testes de integração quando queremos criar um mock de um objeto ou substituir um bean que está no contexto do Spring Boot.

### d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

Este ficheiro é usado para definir as propriedades que serão usadas nos testes de integração, neste caso, de uma base de dados a ser usada durante os testes para que não tenhamos de usar a base de dados persistente de produção, mas sim uma que corre em memória, não interferindo com a base de dados real.

### e) the sample project demonstrates three test strategies to assess an API (C, D and E) developed with SpringBoot. Which are the main/key differences? 


