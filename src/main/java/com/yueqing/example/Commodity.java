package com.yueqing.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dingliming
 * @date 2022/7/20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {

    private Long id;

    private String name;

    private double price;
}
