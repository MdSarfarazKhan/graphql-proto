import { values } from 'lodash';
import { makeExecutableSchema } from 'graphql-tools';
import { GraphQLScalarType, Kind } from 'graphql';

const sampleData = {
  Property: {
    p1: {
      id: 'p1',
      name: 'Super great hotel',
      location: {
        name: 'Helsinki',
      },
    },
    p2: {
      id: 'p2',
      name: 'Another great hotel',
      location: {
        name: 'San Francisco',
      },
    },
    p3: {
      id: 'p3',
      name: 'BedBugs - The Affordable Hostel',
      location: {
        name: 'Helsinki',
      },
    },
  },
};

function coerceString(value) {
  if (Array.isArray(value)) {
    throw new TypeError(
      `String cannot represent an array value: [${String(value)}]`,
    );
  }
  return String(value);
}

const DateTime = new GraphQLScalarType({
  name: 'DateTime',
  description: 'Simple fake datetime',
  serialize: coerceString,
  parseValue: coerceString,
  parseLiteral(ast) {
    return ast.kind === Kind.STRING ? ast.value : null;
  },
});

const addressTypeDef = `
  type Address {
    street: String
    city: String
    state: String
   
  }
`;

const propertyAddressTypeDef = `
  type Property {
    id: ID!
    name: String!
    location: Location
    address: Address
  }
`;

const propertyRootTypeDefs = `
  type Location {
    name: String!
  }

  type Query {
    propertyById(id: ID!): Property
    properties(limit: Int): [Property!]
    contextTest(key: String!): String
    dateTimeTest: DateTime
  }
`;

const propertyAddressTypeDefs = `
  scalar DateTime

  ${addressTypeDef}
  ${propertyAddressTypeDef}
  ${propertyRootTypeDefs}
`;

const propertyResolvers = {
  Query: {
    propertyById(root, { id }) {
      return sampleData.Property[id];
    },

    properties(root, { limit }) {
      const list = values(sampleData.Property);
      if (limit) {
        return list.slice(0, limit);
      } else {
        return list;
      }
    },

    contextTest(root, args, context) {
      return JSON.stringify(context[args.key]);
    },

    dateTimeTest() {
      return '1987-09-25T12:00:00';
    },
  },
  DateTime,
};

export const schema = makeExecutableSchema({
  typeDefs: propertyAddressTypeDefs,
  resolvers: propertyResolvers,
});