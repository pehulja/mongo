package com.pehulja.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pehulja.mongo.model.Order;

public interface OrdersMongoRepository extends MongoRepository<Order, String>{

}
