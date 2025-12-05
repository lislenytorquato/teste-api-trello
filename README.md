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

-----------------------------------------------------------------------------------------------------------------------

* Melhoria: Id - CT 13
* Como reproduzir?
  1. criar teste em rest assured
  2. adicionar um idCard inexistente (retirado da documentação)
  3. enviar post na url https://api.trello.com/1/checklists?
* Resultado Esperado: código 404 - not found
* Resultado Obtido: código 401
* Evidências:
  java.lang.AssertionError: 1 expectation failed.
  Expected status code <404> but was <401>.
* Observações: pode ser uma melhoria ou exista uma razão interna da trello para ser bad request
-------------------------------------------------------------------------------------------------------------------------
* Bug: Id - CT 11
* Como reproduzir?
  1. criar teste em rest assured
  2. não adicionar o token
  3. enviar put na url https://api.trello.com/1/checklists?
* Resultado Esperado: passar na validação de schema
* Resultado Obtido: propriedades obrigatórias faltando
* Evidências:
  java.lang.AssertionError: 1 expectation failed.
  Response body doesn't match expectation.
  Expected: The content to match the given JSON schema.
  error: object has missing required properties (["id"])
  level: "error"
  schema: {"loadingURI":"file:/C:/Users/lisleny.silva/Documents/Trello/teste-api-trello/build/resources/test/schema/checklist-schema-id-required.json#","pointer":""}
  instance: {"pointer":""}
  domain: "validation"
  keyword: "required"
  required: ["id"]
  missing: ["id"]

* Observações: a consulta tem o id no basePath, não deveria estar faltando


