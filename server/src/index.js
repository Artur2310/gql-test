const { ApolloServer } = require('apollo-server');
const typeDefs = require('./schema');

const RecordAPI = require('./datasources/record');
const AuthorAPI = require('./datasources/author');
const resolvers = require('./datasources/resolvers');

const dataSources = () => ({
  recordAPI: new RecordAPI(),
  authorAPI: new AuthorAPI()
});

const server = new ApolloServer({
  typeDefs,
  resolvers,
  dataSources
});


server.listen().then(({ url }) => {
  console.log(`🚀 Server ready at ${url}`);
});
