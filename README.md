# Testes para api Trello

Teste da api rest da Trello

## Tecnologias
  * Java 24
  * Rest Assured
  * Gradle
  * Github Actions
  * Dotenv
  * Json Schema Validator - Rest Assured

## Como executar?
Para executar localmente, 
* Os testes:
<code> ./gradlew clean test </code>
* o relatório:
  <code> ./gradlew jacocoTestReport </code>

Na pipeline, o relatório pode ser baixado.
 1. Vá na aba actions do repository
2. Em All Workflows, clique na mais recente e bem-sucedida(verde)
3. Clique no job test
4. Clique no step Upload Jacoco Html Report
5. Clique no link gerado
6. Vai baixar um arquivo zipado


## O escopo: Crud do Checklists

1. Create a Checklist 
2. Get a Checklist 
3. Update a Checklist 
4. Delete a Checklist

https://developer.atlassian.com/cloud/trello/rest/api-group-checklists/

### Estratégia de Teste:
Os testes foram separados por status code. Foram feitos mais testes para o código 401, pois é o mais crítico.

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

* Melhoria: Id - CT 21
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
* Bug: Id - CT 15
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
  schema: {"loadingURI":"file:.../teste-api-trello/build/resources/test/schema/checklist-schema-id-required.json#","pointer":""}
  instance: {"pointer":""}
  domain: "validation"
  keyword: "required"
  required: ["id"]
  missing: ["id"]

* Observações: a consulta tem o id no basePath, não deveria estar faltando

-------------------------------------------------------------------------------------------------------------------------------
* Bug: Id - CT 17
* Como reproduzir?
  1. criar teste em rest assured
  2. não adicionar nem token nem key 
  3. enviar put na url https://api.trello.com/1/checklists?
* Resultado Esperado: passar na validação de schema
* Resultado Obtido: propriedades obrigatórias faltando
* Evidências:
  java.lang.AssertionError: 1 expectation failed.
  Response body doesn't match expectation.
  Expected: The content to match the given JSON schema.
  error: object has missing required properties (["id"])
  level: "error"
  schema: {"loadingURI":"file:/.../teste-api-trello/build/resources/test/schema/checklist-schema-id-required.json#","pointer":""}
  instance: {"pointer":""}
  domain: "validation"
  keyword: "required"
  required: ["id"]
  missing: ["id"]

* Observações: a consulta tem o id no basePath, não deveria estar faltando

--------------------------------------------------------------------------------------------------------------------------------

* Melhoria: Id - CT 11
* Como reproduzir?
  1. criar teste em rest assured
  2. remover o token e o key do queryParam
  3. enviar post na url https://api.trello.com/1/checklists?
* Resultado Esperado: código 401 - unauthorized
* Resultado Obtido: código 400
* Evidências:
  java.lang.AssertionError: 1 expectation failed.
  Expected status code <401> but was <400>.
* Observações: pode ser uma melhoria ou exista uma razão interna da trello para ser bad request

----------------------------------------------------------------------------------------------------------------------------

* Bug: Id - CT 12
* Como reproduzir?
  1. criar teste em rest assured
  2. não adicionar token 
  3. enviar get na url https://api.trello.com/1/checklists?
* Resultado Esperado: passar na validação de schema
* Resultado Obtido: propriedades obrigatórias faltando
* Evidências:
  java.lang.AssertionError: 1 expectation failed.
  Response body doesn't match expectation.
  Expected: The content to match the given JSON schema.
  error: object has missing required properties (["id"])
  level: "error"
  schema: {"loadingURI":"file:.../teste-api-trello/build/resources/test/schema/checklist-schema-id-required.json#","pointer":""}
  instance: {"pointer":""}
  domain: "validation"
  keyword: "required"
  required: ["id"]
  missing: ["id"]

* Observações: a consulta tem o id no basePath, não deveria estar faltando


