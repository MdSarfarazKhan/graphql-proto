package com.agoda.content.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.agoda.content.service.ReviewService;
import com.agoda.content.service.RoomService;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;

@Configuration
public class ContentConfig {
	
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
	 public GraphQL graphQL(@Autowired RoomService Roomservice,@Autowired ReviewService reviewService) {
			//Schema generated from query classes
			GraphQLSchema schema = new GraphQLSchemaGenerator()
					.withResolverBuilders(
							//Resolve by annotations
							new AnnotatedResolverBuilder(),
							//Resolve public methods inside root package
							new PublicResolverBuilder("com.agoda.content"))
					.withOperationsFromSingleton(Roomservice)
					//.withOperationsFromSingleton(reviewService)
					.withValueMapperFactory(new JacksonValueMapperFactory())
					.generate();
			return GraphQL.newGraphQL(schema).build();

	 }

}
