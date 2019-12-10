package com.taiji.authenticationplatform.service.estest;

import com.taiji.authenticationplatform.dao.estest.ItemRepository;
import com.taiji.authenticationplatform.model.es.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.Iterator;
import java.util.List;

public interface ElasticService {
        public void createIndex();

        public void deleteIndex(String index);

        public void save(Item docBean);

        public void saveAll(List<Item> list);

        public Iterator<Item> findAll();

//        public Page<Item> findByContent(String content);

//        public Page<Item> findByFirstCode(String firstCode);
//
//        public Page<Item> findBySecordCode(String secordCode);
//
//        public Page<Item> query(String key) ;
}
