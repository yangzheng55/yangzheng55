package com.example.feign;

import com.netflix.hystrix.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class HystrixTest extends HystrixCommand<String> {

    private FeignServer newFeignServer;

    @Autowired
    RestTemplate restTemplate;


    public HystrixTest(FeignServer newFeignServer) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("newFeignServer"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("hello1"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)//至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
                        .Setter().withCoreSize(10)));
        this.newFeignServer = newFeignServer;
    }
    @Override
    protected String run() throws Exception {
//        return new RestTemplate().getForObject("http://service-hi/hello",String.class);
//    return "正确";
        Thread.sleep(10000);
       return newFeignServer.hello();
    }


//    @Override
//    protected String getFallback(){
//        return "错误";
//    }
}
