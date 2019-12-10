package com.taiji.authenticationplatform;

import com.taiji.authenticationplatform.model.Item;
import io.searchbox.client.JestClient;
import io.searchbox.core.Delete;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JestTest {
    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoad() throws IOException {
        Item item = new Item();
        item.setId(1);
        item.setAutor("老张");
        item.setContext("你好啊");
        //构建一个索引功能
        Index index = new Index.Builder(item).index("cesji1").type("news").build();
        jestClient.execute(index);

    }

    @Test
    public void search() throws IOException {
        //查询表达式
        String json = "{\n" +
                "\"query\":{\n" +
                "\"match\":{\n" +
                "\"context\":\"你\"\n" +
                "}\n" +
                "}\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("cesji1").addType("news").build();
        SearchResult result = jestClient.execute(search);
        System.out.println(result.getJsonString());

    }
}
