# Testes para api Trello

Teste da api rest da Trello

## Tecnologias
  * Java 24
  * Rest Assured
  * Gradle
  * Github Actions
  * Dotenv

## O escopo: Checklists

https://developer.atlassian.com/cloud/trello/rest/api-group-checklists/

### Estratégia de Teste:

### Relatório de bugs e melhorias:

* Melhoria: Id - CT 09
* Como reproduzir?
  1. criar teste em rest assured
  2. remover o token do queryParam
  3. enviar post na url https://api.trello.com/1/checklists?
* Resultado Esperado: código 401 - unauthorized
* Resultado Obtido: código 400
* Evidências: 
java.lang.AssertionError: 1 expectation failed.
  Expected status code <401> but was <400>.
* Observações: pode ser uma melhoria ou exista uma razão interna da trello para ser bad request

