package com.kuake.concurrent;

import lombok.Builder;
import lombok.Data;

/**
 * @author liuzihao
 * @create 2020-04-17-10:45
 */
@Data
@Builder
public class Product {
    private String  name;
    private String  desc;
    private int price;

}
