package com.agoda.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.agoda.booking.service.BookingService;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;

@Configuration
public class BookingConfig {
	
	 @Bean
	    public WebMvcConfigurerAdapter forwardToIndex() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addViewControllers(ViewControllerRegistry registry) {
	                registry.addViewController("/").setViewName(
	                        "forward:/graphiql/index.html");
	            }
	        };
	}
	 
	 @Bean
	 public GraphQL graphQL(@Autowired BookingService bookingService) {
			//Schema generated from query classes
			GraphQLSchema schema = new GraphQLSchemaGenerator()
					
					.withResolverBuilders(
							//Resolve by annotations
							new AnnotatedResolverBuilder(),
							//Resolve public methods inside root package
							new PublicResolverBuilder("com.agoda.booking"))
					.withOperationsFromSingleton(bookingService)
					.withValueMapperFactory(new JacksonValueMapperFactory())
					.generate();
			return GraphQL.newGraphQL(schema).build();

	 }

}
