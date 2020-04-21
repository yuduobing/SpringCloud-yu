package yun520.xyz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yun520.xyz.entities.CommonResult;
import yun520.xyz.entities.Payment;

import javax.annotation.Resource;
import javax.xml.ws.Response;

@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL ="http://localhost:8001";
public static final String PAYMENT_URL ="http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult< Payment > getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL +"/payment/get/" + id, CommonResult.class);
    }
    //使用riboon中的
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult< Payment > getPayment2(@PathVariable("id") Long id) {
         ResponseEntity<CommonResult> entity=restTemplate.getForEntity(PAYMENT_URL +"/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return  new CommonResult<>(444,"操作失败");
        }
    }
}
