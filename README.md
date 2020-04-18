# gql-test
1) Запустить example-rest
2) cd server -> npm install -> cd src -> npm start

Тестирование REST запросов http://localhost:8080/swagger-ui.html

Тестирование GQL интерфейса http://localhost:4000/

Примеры:
1) Поиск документа по id

```gql
query{
  record(id : 1){
    id
    title
    description
  }
}
```

2) Выбрать все документы (либо ограничить выборку)

```gql
query{
  records(limit : 2){
    id
    title
    description
  }
}
```

3) Добавить документ

```gql
mutation{
  createRecord(record : {title: "Test", description: "Test"}){
    id
    title
    description
  }
}
```

4) Удалить документ

```gql
mutation{
  deleteRecord(id: 1){
    result
  }
}
```
