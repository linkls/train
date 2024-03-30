package com.yaowz.train.batch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "business", fallback = BusinessFeignFallback.class)
@FeignClient(name = "business", url = "http://127.0.0.1:8002")
public interface BusinessFeign {
    @GetMapping("/business/hello")
    String hello();
}
