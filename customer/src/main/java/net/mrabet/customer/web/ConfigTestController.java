package net.mrabet.customer.web;

import net.mrabet.customer.config.GloblaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.param.p1}")
    private int p1 ;
    @Value("${global.param.p2}")
    private int p2 ;
    @Value("${customer.params.x}")
    private int x  ;
    @Value("${customer.params.x}")
    private int y  ;
    @Autowired
    private GloblaConfig globlaConfig;

@GetMapping("/testConfig")
    public Map<String, Integer> configTest() {
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
    @GetMapping("/globalConfig")
    public GloblaConfig getGloblaConfig() {
    return globlaConfig;
    }
}
