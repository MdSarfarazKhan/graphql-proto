const { ApolloServer, gql } = require('apollo-server');
const { buildSchema } = require('graphql')
const fs = require('fs')
const path = require('path')


const schemaCode = fs.readFileSync(path.join(__dirname, 'schema', 'props-schema.graphql'), 'utf8')
const schema = buildSchema(schemaCode) 

const server = new ApolloServer({
  schema,
  mocks: true,
});
  
server.listen().then(({ url }) => {
  console.log(` Server ready at ${url}`)
});