const {gql} = require('apollo-server');

const typeDefs = gql`

type Record {
  id: ID!
  title: String
  description: String
}

type DeleteResponse{
    result: Boolean!
}

input RecordInput {
  title: String
  description: String
}

type Query {
  record(id: ID!): Record
}

type Mutation {
  createRecord(record: RecordInput!): Record!
  deleteRecord(id: ID!): DeleteResponse!
}
`;

module.exports = typeDefs;
