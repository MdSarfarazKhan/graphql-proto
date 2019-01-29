
import {
    addMockFunctionsToSchema,
} from 'graphql-tools';
import { graphql } from 'graphql';

const { buildSchema } = require('graphql')
const fs = require('fs')
const path = require('path')


const schemaCode = fs.readFileSync(path.join(__dirname, 'schema', 'props-schema.graphql'), 'utf8')
const schema = buildSchema(schemaCode) 
addMockFunctionsToSchema({ schema });

//Sample query
const query = `
query tasksForProp {
    propertyById(id: "p1")  { id, name }
}
`;

graphql(schema, query).then((result) => console.log('Got result', result));
