const {gql} = require('apollo-server');

const typeDefs = gql`

type Record {
  id: ID!
  title: String
  description: String
  author: Int
}

type Author {
  id: ID!
  name: String
  age: Int
  records: [Record]
}

type DeleteResponse{
    result: Boolean!
}

input RecordInput {
  title: String
  description: String
  author: Int
}

input AuthorInput {
  name: String
  age: Int
}

type Query {
  record(id: ID!): Record
  records(limit: Int): [Record]
  author(id: ID!): Author
  authors(limit: Int): [Author]
}

type Mutation {
  createRecord(record: RecordInput!): Record!
  updateRecord(record: RecordInput!): Record!
  deleteRecord(id: ID!): DeleteResponse!
  createAuthor(author: AuthorInput!): Author!
  deleteAuthor(id: ID!): DeleteResponse!
}
`;

module.exports = typeDefs;
