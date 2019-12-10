package com.taiji.authenticationplatform.controller;

import com.alibaba.fastjson.JSON;
import com.taiji.authenticationplatform.dao.estest.ItemRepository;
import com.taiji.authenticationplatform.model.es.Commodity;
import com.taiji.authenticationplatform.model.es.Item;
import com.taiji.authenticationplatform.service.estest.impl.ElasticServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping("es")
public class TemplateController {
    @Autowired(required = false)
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ElasticServiceImpl elasticServiceImpl;

    /**
     *创建索引
     */
    @RequestMapping("/create")
    public void testCreateIndex() {
        elasticsearchTemplate.createIndex(Item.class);
    }
    /**
     *创建索引
     */
    @RequestMapping("/create1")
    public void testCreate1Index() {
        elasticsearchTemplate.createIndex(Commodity.class);
    }

    /**
     * 删除索引
     */
    @RequestMapping("/delete")
    public void testDeleteIndex() {
        elasticsearchTemplate.deleteIndex(Item.class);
    }

    /**
     * 增加数据
     */
    @RequestMapping("/add")
    public void testAddDataIndex() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("关键字1");
        list.add("关键字2");
        elasticServiceImpl.save(new Item(1L,"标题","分类",list.toString(),"品牌",30D,"图片路径","内容"));
        elasticServiceImpl.save(new Item(1L,"标题1","分类1",list.toString(),"品牌1",30D,"图片路径","内容"));
    }
    /**
     * 查询数据
     */
    @RequestMapping(value = "/search/{token}", method = RequestMethod.POST)
    @ResponseBody
    public Iterator<Item> testSearchDataIndex(@PathVariable(value = "token", required = true) String token) {
        Iterator<Item> items = elasticServiceImpl.findAll();

        return items;
    }
}
