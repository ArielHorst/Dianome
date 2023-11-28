### API para gerenciamento simplificado de uma empresa de entregas/transportadora (Dianome Express)

## Instruções para colocar a API em funcionamento

# Requisitos Mínimos
- Java 17
- MySQL
    - Database: dianome
    - Username: MySQL
    - Password: MySQL

# Instalação
- Clone este projeto
- Importe para sua IDE de preferência (IntelliJ, Eclipse, VScode, entre outras..)
- Atualize as bibliotecas com o gerenciador Maven
- Inicialize a API:
  - Procure pelo arquivo.java do seguinte caminho(Path): 
    "src/main/java/com/dianome/app/DianomeAppApplication.java"

# Acesso
- Abra um gerenciador de API (Postman,SoapUI,Katalon Studio, entre outros...)
- Recomenda-se o gerenciador Postman!

# Utilização

Para incluir um Entregador/Pacote/Reclamação

      - URI: http://localhost:8080/entregador/cadastrar
      - URI: http://localhost:8080/pacote/cadastrar
      - URI: http://localhost:8080/reclamacao/cadastrar
	
      - Método: POST
	
      - Formulário JSON (entregador): 
          {
          "nome":"Insira os dados dentro das aspas",
          "idade":"",
          "cnhRegistro":"",
          "cnhRenach":"",
          "numeroCelular":"",
          "carteiraTrabalho":"",
          "cpf":""
          }

      - Formulário JSON (pacote):
        - O campo "status" só aceita 3 possíveis 
            valores:"ESTOQUE","TRANSITO","ENTREGUE".
        - O campo ""dataRecebimento" aceita formato ISO 8601
          (exemplo: 2023-10-20T03:14:03.436)

          {
          "codigoRastreamento":"",
          "entregador":{
              "id":""
          },
          "status":"",
          "dataRecebimento":""    
          }

      - Formulário JSON (reclamações):
          {   
          "pacote":{
          "id":""
          },
          "nomeReclamante":"",
          "telefone":"",
          "descricaoReclamacao":"",
          "descricaoSolucao":""
          }


Para listar todos os Entregadores/Pacotes/Reclamações

	- URI: http://localhost:8080/entregadores
	- URI: http://localhost:8080/pacotes
	- URI: http://localhost:8080/reclamacoes
	
	- Método: GET

Para mostrar apenas um Entregador/Pacote/Reclamação

    - OBS: deve-se substituir "{id}" pelo id do entregador ou pacote ou reclamação !
          Exemplo: http://localhost:8080/entregadores/1

	- URI: http://localhost:8080/entregadores/{id}
	- URI: http://localhost:8080/pacotes/{id}
	- URI: http://localhost:8080/reclamacoes/{id}
	
	- Método: GET

Para excluir um Entregador/Pacote/Reclamação

	- URI: http://localhost:8080/entregadores/delete/{id}
	- URI: http://localhost:8080/pacotes/delete/{id}
	- URI: http://localhost:8080/reclamacoes/delete/{id}
	
	- Método: DELETE

Para alterar um Entregador/Pacote/Reclamação

    - OBS: deve-se substituir os valores dos campos que se deseja alterar!

	- URI: http://localhost:8080/entregadores/{id}
	- URI: http://localhost:8080/pacotes/{id}
	- URI: http://localhost:8080/reclamacoes/{id}
	
	- Método: PUT
	
      - Formulário JSON (entregador): 
          {
          "nome":"Insira os dados dentro das aspas",
          "idade":"",
          "cnhRegistro":"",
          "cnhRenach":"",
          "numeroCelular":"",
          "carteiraTrabalho":"",
          "cpf":""
          }

      - Formulário JSON (pacote):
        - O campo "status" só aceita 3 possíveis 
            valores:"ESTOQUE","TRANSITO","ENTREGUE".
        - O campo ""dataRecebimento" aceita formato ISO 8601
          (exemplo: 2023-10-20T03:14:03.436)

          {
          "codigoRastreamento":"",
          "entregador":{
              "id":""
          },
          "status":"",
          "dataRecebimento":""    
          }

      - Formulário JSON (reclamações):
          {   
          "pacote":{
          "id":""
          },
          "nomeReclamante":"",
          "telefone":"",
          "descricaoReclamacao":"",
          "descricaoSolucao":""
          }