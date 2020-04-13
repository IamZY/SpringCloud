package domain;

import lombok.Data;

/**
 * @Author IamZY
 * @create 2020/4/12 16:52
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}
