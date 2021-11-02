package com.pontodigital.screen02.repository;

import com.github.leosant.mongoConfig.MongoConfig;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoRepositories extends MongoConfig {

    public MongoTemplate dateMongo = null;

    public MongoRepositories() {
        mongoClientCluster("admin:admin@pontodigital.3ysb3.mongodb.net/pontodigital?retryWrites=true&w=majority", "pontodigital");
        dateMongo = mongoTemplate();
    }

    public static void mongoClientCluster(String mongoSrv, String database) {
        MongoConfig.mongoClientCluster(mongoSrv, database);
    }
}
