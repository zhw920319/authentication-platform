//package com.taiji.authenticationplatform;
//
//import com.taiji.authenticationplatform.dao.estest.ItemRepository;
//import com.taiji.authenticationplatform.model.es.Item;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class AuthenticationPlatformApplicationTests {
//        @Autowired
//        private ElasticsearchRestTemplate elasticsearchTemplate;
//        @Autowired
//        private ItemRepository itemRepository;
//
//        /**
//         * 新建/删除索引
//         */
//        void test() {
//            elasticsearchTemplate.createIndex(Item.class);
//            //elasticsearchTemplate.deleteIndex(Item.class);
//        }
//
//        /**
//         * 新增或修改文档
//         */
//        public void insert() {
////		Item item = new Item(1L, "小米手机7", " 手机", "小米", 3499.00, "http://image.baidu.com/13123.jpg");
//            Item item = new Item(1L,"标题1","分类1","品牌",30D,"/src/image/prid.png","内容1");
//            itemRepository.save(item);
//        }
//
//        /**
//         * 查询Item索引下所有文档.
//         * 此处需要注意，如果Item实体中有含参构造函数而缺少了无参构造函数，itemRepository.findAll查询会报映射实体失败的错误
//         */
//        @Test
//        public void query() {
//            Iterable<Item> list = itemRepository.findAll(Sort.by("price").ascending());
//            for(Item item : list) {
//                System.out.println(item.toString());
//            }
//        }
//    }
