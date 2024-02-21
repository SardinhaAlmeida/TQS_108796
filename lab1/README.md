# Alguns apontamentos sobre os exercícios

## ex1

Este exercício mostra que o importante não é apenas escrever testes e que estes passem à primeira, é importante numa fase inicial ter código que não funcione para verificar se os testes de facto falham e depois sim corrigir o código para que os testes passem e verificar se estes são suficientes para cobrir todos os casos.

## ex2

### alínea c)

Ao analisar o report gerado pelo Jacoco, verificamos inicialmente que as classes inseridas na pasta 'euromillions' têm uma coverage muito maior que as classes inseridas na pasta 'sets', pois existem testes para as classes *Dip* e *EuromillionsDraw* ainda que sem coverage total, enquanto que para classe *BoundedSetOfNaturals* apesar de existirem alguns testes estes estão para já bastante incompletos, o que explica a coverage de apenas 50%.

Dito isto para a classe **BoundedSetOfNaturals** foi necessário adicionar alguns casos (como a adição de duplicados) no teste *add()*, bem como adicionar testes para os métodos *intersects()*, *equals()* e *hashcode()*

### alínea d)
Como dito anteriormente, a classe *BoundedSetOfNaturals* tinha uma coverage de 50%, sendo que não cobria todos os casos nem branches.
Depois de adicionar os testes já referidos com o objetivo de atingir o máximo de coverage, a classe passou a ter 100% de coverage. 