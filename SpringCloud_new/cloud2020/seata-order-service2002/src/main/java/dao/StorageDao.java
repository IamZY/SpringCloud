package dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Author IamZY
 * @create 2020/4/12 16:53
 */
public interface StorageDao {
    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
