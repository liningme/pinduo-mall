package com.pd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/*
"id": "635908",
"brand": "联想",
"title": "联想（Lenovo）小新310经典版",
"sell_point": "清仓！仅北京，武汉仓有货！",
"price": "5592.0",
"barcode": "null",
"image": "/images/server/images/portal/310/collect.jpg",
"cid": "163",
"status": "1",
"created": "2017-01-11 13:10:07",
"updated": "2017-01-11 13:09:32"
 */

//Item 实体类
@Document(indexName = "pditems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    private Long id;
    private String brand;
    private String title;
    @Field(name = "sell_point")
    private String sellPoint;
    private String price;
    private String barcode;
    private String image;
    private Long cid;
    private Integer status;
    private String created;
    private String updated;
}
