const { ApolloServer } = require('apollo-server');
const typeDefs = require('./schema');

const RecordAPI = require('./datasources/record');
const resolvers = require('./datasources/resolvers');

// set up any dataSources our resolvers need
const dataSources = () => ({
  recordAPI: new RecordAPI()
});

const server = new ApolloServer({
  typeDefs,
  resolvers,
  dataSources
});


server.listen().then(({ url }) => {
  console.log(`🚀 Server ready at ${url}`);
});
