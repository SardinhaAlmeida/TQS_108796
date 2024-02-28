## exercício 2_2

### alínea b)

SuT : AddressResolver
Service to Mock : HttpClient

## exercício 2_3

O comando *mvn test* corre apenas os testes da classe *AddressResolverTest*, sendo por isso mais rápido que o comando *mvn install failsafe:integration-test* que corre todos os testes, incluindo os de integração, demorando por isso mais tempo.

Correndo ambos os comandos sem acesso à internet,ao contrário de anteriormente, os testes passam igualmente quanto ao *mvn test* mas os testes de integração falham quanto ao *mvn install failsafe:integration-test*, pois não conseguem aceder ao serviço de geocoding.