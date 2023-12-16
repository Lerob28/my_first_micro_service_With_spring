package org.lerob.customerservice.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.lerob.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
this class is use to check if the micro service have load the config from config server
 */
@RestController
@RefreshScope
public class GetConfigTestController {

    private final GlobalConfig globalConfig;

    @Autowired
    public GetConfigTestController(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    @Value( "${global.params.p1}" )
    private int p1;

    @Value( "${global.params.p2}" )
    private int p2;

    @Value( "${customer.params.x}" )
    private int x;

    @Value( "${customer.params.y}" )
    private int y;

    @GetMapping("/testConfig")
    public Map<String, Integer> configTest() {
        Map<String, Integer> result = new HashMap<>();
        result.put( "p1", p1 );
        result.put( "p2", p2 );
        result.put( "x", x );
        result.put( "y", y );
        return result;
    }

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig() {
        return globalConfig;
    }
}
