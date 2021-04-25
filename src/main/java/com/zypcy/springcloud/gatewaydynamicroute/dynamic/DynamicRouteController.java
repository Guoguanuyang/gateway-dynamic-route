package com.zypcy.springcloud.gatewaydynamicroute.dynamic;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 查询网关的路由信息
 */
@RestController
@RequestMapping("/route")
public class DynamicRouteController {

    @Autowired
    private RouteDefinitionLocator routeDefinitionLocator;

    @Autowired
    private DynamicRouteService dynamicRouteService;

    //获取网关所有的路由信息
    @RequestMapping("/routes")
    public Flux<RouteDefinition> getRouteDefinitions() {
        return routeDefinitionLocator.getRouteDefinitions();
    }

    @RequestMapping("/test")
    public String test1() {
        return "ok";
    }

    @RequestMapping("/update")
    public String update(@RequestBody RouteDefinition routeDefinition) {
//        String str = "{\"filters\": [{\"name\":\"StringPrefix\",\"args\":{\"_genkey_0\": \"1\"}}],\"id\": \"ggy1\",\"uri\": \"http://localhost:8080/index\",\"order\": 1,\"predicates\":[{\"name\":\"Path\",\"args\":{\"pattern\":\"/test/**\"}}]}";
//        RouteDefinition routeDefinition = JSONObject.parseObject(str, RouteDefinition.class);
        dynamicRouteService.update(routeDefinition);
        return "ok";
    }
}
