const { gql } = require('apollo-server');

const typeDefs = gql`

type Record {
  id: ID!
  title: String
  description: String
}


type Query {
  record(id: ID!): Record
}


`;

module.exports = typeDefs;
