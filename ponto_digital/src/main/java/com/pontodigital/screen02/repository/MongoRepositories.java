package com.pontodigital.screen02.repository;

import com.github.leosant.mongoConfig.MongoConfig;
import com.xtech.commons.config.Env;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoRepositories extends MongoConfig {

    public MongoTemplate dateMongo = null;

    public MongoRepositories() {
        String connectioEnv = Env.getEnv("db.key");
        mongoClientCluster(connectioEnv, "pontodigital");
        dateMongo = mongoTemplate();
    }

    public static void mongoClientCluster(String mongoSrv, String database) {
        MongoConfig.mongoClientCluster(mongoSrv, database);
    }
}
