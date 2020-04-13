package service;

/**
 * @Author IamZY
 * @create 2020/4/12 16:27
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}

