package com.chnghx;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
 * 
 * Feign是自带断路器的, 基于service-feign工程进行改造，只需要在FeignClient的SchedualServiceHi接口的注解中加上fallback的指定类就行了
 * SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中
*    
* 项目名称：eureka-feign   
* 类名称：SchedualServiceHi   
* 类描述：   
* 创建人：guohaixiang  
* 创建时间：2018年6月1日 上午11:01:32   
* 修改人：Administrator   
* 修改时间：2018年6月1日 上午11:01:32   
* 修改备注：   
* @version 1.0
*
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

	@RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
