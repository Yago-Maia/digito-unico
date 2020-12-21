# Desafio Banco Inter: Como compilar, executar e testar a aplicação Dígito Único

## Clonar o projeto:
Acesse o diretório desejado para alocar o projeto pelo terminal e execute o comando:
```bash
git clone https://gitlab.com/yagogmaia/digito-unico.git
```

## Instalação do Maven:
Acesse o diretório pelo terminal e instale o Maven junto com as dependências necessárias para o projeto.
```bash
mvn install
```

## Executar a aplicação:
Ainda no terminal, executar o comando no diretório raiz do projeto.
```bash
mvn spring-boot:run
```

## Postman:
Segue na raiz do diretório uma coleção chamada 'postman_collection.json' para utilização das API's.
Foram criadas duas pastas no postman, uma para testes locais e outra apontando para a API hospedada na AWS.
Segue nome dos Endpoint's e sua descrição:
```bash
GetUser - Listar usuário por Id.
GetUsers - Listar todos os usuários.
PostUser - Criar usuário.
DeleteUser - Deletar usuário por Id.
PutUser - Alterar usuário por Id.
ListByUser - Listar todos os dígitos únicos inseridos pelo usuário.
ComputeUniqueDigit - Calcular dígito único, de forma opcional a um usuário.
```

## Executar testes unitários:
No terminal, executar o comando no diretório raiz do projeto
```bash
mvn test
```

## Swagger:
Para acessar o Swagger é necessário acessar o link abaixo com o projeto em execução:
```bash
http://localhost:8080/swagger-ui/index.html
http://18.218.43.52:8080/swagger-ui/index.html
```
Os arquivos JSON e YAML do Swagger se encontram no diretório raiz do projeto com os nomes:
```bash
swagger.json
swagger.yaml
```

## Criptografia:
Não foi criado um endpoint específico para envio da chave primária pois, na parte da criptografia, foi informado que as informações do cliente ***devem*** ser criptografadas.
Então foi adicionado nos Endpoints, PostUser e PutUser, o header ***publicKey*** para o envio, criptografando os dados do cliente no momento da adição e edição.

Na pasta raiz foi criado um projeto DesafioInterCriptografia.jar, para que o cliente, caso não possua as chaves Pública e Privada, possa gerar as chaves, descriptografar os dados retornados pela API e criptografar caso necessário. 

### Como utilizar o arquivo DesafioInterCriptografia.jar:
Acesse o diretório raiz do projeto pelo terminal e execute com os comandos:
```bash
java -jar DesafioInterCriptografia.jar -d <textoEncriptado> <chavePrivada>      "Para descriptografar"
java -jar DesafioInterCriptografia.jar -c <texto> <chavePublica>                "Para criptografar"
java -jar DesafioInterCriptografia.jar -g                                       "Para gerar chaves Pública e Privada"
```