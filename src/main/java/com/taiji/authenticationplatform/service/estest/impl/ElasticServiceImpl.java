package com.taiji.authenticationplatform.service.estest.impl;

import com.taiji.authenticationplatform.dao.estest.ItemRepository;
import com.taiji.authenticationplatform.model.es.Item;
import com.taiji.authenticationplatform.service.estest.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ElasticServiceImpl implements ElasticService {

    @Autowired(required=false)
    private ElasticsearchRestTemplate elasticsearchTemplate;
//    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ItemRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);

    public void createIndex() {
        elasticsearchTemplate.createIndex(Item.class);
    }

    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    public void save(Item docBean) {
        elasticRepository.save(docBean);
    }

    public void saveAll(List<Item> list) {
        elasticRepository.saveAll(list);
    }

    public Iterator<Item> findAll() {
        return elasticRepository.findAll().iterator();
    }

//    public Page<Item> findByContent(String content) {
//        return elasticRepository.findByContent(content,pageable);
//    }

//    public Page<Item> findByFirstCode(String firstCode) {
//        return elasticRepository.findByFirstCode(firstCode,pageable);
//    }
//
//    public Page<Item> findBySecordCode(String secordCode) {
//        return elasticRepository.findBySecordCode(secordCode,pageable);
//    }
//
//    public Page<Item> query(String key) {
//        return elasticRepository.findByContent(key,pageable);
//    }
}
