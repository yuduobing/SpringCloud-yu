package yun520.xyz.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yun520.xyz.entities.Payment;

/**
 *@Mapper注解的的作用
 *
 * 1:为了把mapper这个DAO交給Spring管理 http://412887952-qq-com.iteye.com/blog/2392672
 *
 * 2:为了不再写mapper映射文件 https://blog.csdn.net/weixin_39666581/article/details/103899495
 *
 * 3:为了给mapper接口 自动根据一个添加@Mapper注解的接口生成一个实现类 http://www.tianshouzhi.com/api/tutorials/mapstruct/292
 * ————————————————
 * 版权声明：本文为CSDN博主「洛城铁匠」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_39666581/article/details/81057385
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
