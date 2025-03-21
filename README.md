# quarkus-mongodb-crud

Este projeto usa Quarkus, the Supersonic Subatomic Java Framework.

<https://quarkus.io/>.

## Subindo o banco de dados
Utilize o arquivo docker-compose.yml

```shell script
docker-compose up -d
```

## Rodando a aplicação em modo dev

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Testing the API

Create a product:

```shell script
curl -X POST "http://localhost:8080/produtos" -H "Content-Type: application/json" -d '{"nome":"Notebook", "preco": 4500.00}'
```

List products:

```shell script
curl -X GET "http://localhost:8080/produtos"
```

List products:

```shell script
curl -X GET "http://localhost:8080/produtos"
```

Get a product by ID:

```shell script
curl -X GET "http://localhost:8080/produtos/{id}"
```

Update a product:

```shell script
curl -X PUT "http://localhost:8080/produtos/{id}" -H "Content-Type: application/json" -d '{"nome":"Notebook Gamer", "preco": 5500.00}'
```

Delete a product:

```shell script
curl -X DELETE "http://localhost:8080/produtos/{id}"
```
