package yun520.xyz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import yun520.xyz.dao.PaymentDao;
import yun520.xyz.entities.Payment;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import yun520.xyz.service.PaymentService;
/**
 * @Author EiletXie
 * @Since 2020/3/9 12:02
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
