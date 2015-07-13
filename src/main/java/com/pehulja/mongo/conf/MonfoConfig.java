package com.pehulja.mongo.conf;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@PropertySource("classpath:application.properties")
@EnableMongoRepositories(basePackages = "com.pehulja.mongo")
public class MonfoConfig {
	
    @Resource
    private Environment env;
    
	@Bean
	public MongoFactoryBean mongo(){
		MongoFactoryBean mongoFactoryBean = new MongoFactoryBean();
		mongoFactoryBean.setHost("ds039341.mongolab.com");
		mongoFactoryBean.setPort(39341);
		return mongoFactoryBean;
	}
	
	@Bean(name = "operations")
	public MongoOperations mongoOperations(Mongo mongo){
		UserCredentials userCredentials = new UserCredentials("root", "98979897");
		return new MongoTemplate(mongo, "mongo", userCredentials);
	}
}
