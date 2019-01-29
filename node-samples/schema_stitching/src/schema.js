import {
  makeRemoteExecutableSchema,
  introspectSchema,
  mergeSchemas,
} from 'graphql-tools';
import fetch from 'node-fetch';
import { HttpLink } from 'apollo-link-http';
import 'apollo-link';

async function makeMergedSchema() {
  const result = await fetch('http://localhost:3000/graphql',  {
    method: 'POST', 
    headers: {accept: '*/*', 'content-type': 'application/json'},
    body: JSON.stringify({query: '{ propertyById(id: "p1") { id }}'})}
  );
  console.log(await result.text());
  const PropertyLink = new HttpLink({ 
    uri: 'http://localhost:3000/graphql',
    fetch,
  });
  const PropertySchema = makeRemoteExecutableSchema({
    schema: await introspectSchema(PropertyLink),
    link: PropertyLink,
  });

  const BookingLink = new HttpLink({
    uri: 'http://localhost:3002/graphql',
    fetch,
  })
  const BookingSchema = makeRemoteExecutableSchema({
    schema: await introspectSchema(BookingLink),
    link: BookingLink,
  });

  // A small string schema extensions to add links between schemas
  const LinkSchema = `
    extend type Booking {
      property: Property
    }

    extend type Property {
      bookings(limit: Int): [Booking]
    }
  `;

  // merge actual schema
  const mergedSchema = mergeSchemas({
    schemas: [PropertySchema, BookingSchema, LinkSchema],
    // Define resolvers manually for links
    resolvers: mergeInfo => ({
      Property: {
        bookings: {
          fragment: 'fragment PropertyFragment on Property { id }',
          resolve(parent, args, context, info) {
            return mergeInfo.delegate(
              'query',
              'bookingsByPropertyId',
              {
                propertyId: parent.id,
                limit: args.limit ? args.limit : null,
              },
              context,
              info,
            );
          },
        },
      },
      Booking: {
        property: {
          fragment: 'fragment BookingFragment on Booking { propertyId }',
          resolve(parent, args, context, info) {
            return mergeInfo.delegate(
              'query',
              'propertyById',
              {
                id: parent.propertyId,
              },
              context,
              info,
            );
          },
        },
      },
    }),
  });

  return mergedSchema;
};

export const schema = makeMergedSchema();

export const context = () => ({});
