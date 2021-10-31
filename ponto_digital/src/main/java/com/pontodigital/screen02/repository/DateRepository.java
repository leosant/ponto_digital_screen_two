package com.pontodigital.screen02.repository;

import com.pontodigital.screen02.Model.DateDay;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DateRepository extends MongoRepository<DateDay,String> {
}
