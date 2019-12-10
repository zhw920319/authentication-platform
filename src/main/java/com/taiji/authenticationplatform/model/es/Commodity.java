package com.taiji.authenticationplatform.model.es;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "commodity", type = "doc", shards = 1, replicas = 0)
//最好先手工创建好mapping，然后再写入数据
public class Commodity {

    @Id
    private Long cid;
    //    @Field(type = FieldType.Keyword, analyzer = "ik_max_word")
//    private String all; // 所有需要被搜索的信息，包含标题，分类，甚至品牌, analyzer = "ik_max_word"
    @Field(index = true, type = FieldType.Text, analyzer = "ik_max_word")
    private String title; //标题

    @Field(type = FieldType.Keyword)
    private String category;// 分类

    @Field(type = FieldType.Keyword)
    private List<String> keywords;// 关键字

//    private GeoPoint location; // 坐标

    @Field(type = FieldType.Keyword)
    private String brand; // 品牌

;
    @Field(type = FieldType.Double)
    private Double price; // 价格

    @Field(index = false, type = FieldType.Keyword)
    private String images; // 图片地址
    //
    @Field(index = true, type = FieldType.Text, analyzer = "ik_max_word")
    private  String content;


//    @Field(type = FieldType.Date)
//    private String date;
}