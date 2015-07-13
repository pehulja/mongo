package com.pehulja.mongo;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pehulja.mongo.model.Item;
import com.pehulja.mongo.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MongoApplication.class)
public class MongoApplicationTests {

	private static final Logger logger = Logger.getLogger(MongoApplicationTests.class);

	@Autowired
	@Qualifier("operations")
	MongoOperations mongo;
	
	@Autowired
	private MongoRepository<Order, String> repo;
	
	@Test
	public void save() {
		Order order = new Order();
		order.setCustomer("Cutomer1");
		order.setType("Pre-order");
		
		Item item = new Item();
		item.setId(1l);
		item.setPrice(12.5);
		item.setProduct("Cola");
		item.setQuntity(5);
		order.setItems(Arrays.asList(item));
		mongo.save(order, "order");
		logger.info("Saved" + order.toString());
	}
	
	@Test
	public void get() {
		List<Order> chucksOrders = mongo.find(Query.query(Criteria.where("client").is("Cutomer1")), Order.class);
		logger.info("FIND BY CLIENT SIZE: " + chucksOrders.size());
	}	
	
	@Test
	public void saveRepo(){
		Order order = new Order();
		order.setCustomer("Cutomer2");
		order.setType("Repo-order");
		
		Item item = new Item();
		item.setId(2l);
		item.setPrice(55);
		item.setProduct("Toy");
		item.setQuntity(5);
		order.setItems(Arrays.asList(item));
		repo.save(Arrays.asList(order));
		logger.info("Saved Repor" + order.toString());

	}
}
