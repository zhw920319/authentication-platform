package com.taiji.authenticationplatform.dao.estest;

import com.taiji.authenticationplatform.model.es.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

}
