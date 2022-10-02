package com.ntq.springlearn.configurationproperties;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component  // là 1 spring bean
//@PropertySource("classpath:loda.yml") // Đánh dấu để lấy các config từ trong file loda.yml
@ConfigurationProperties(prefix = "loda") // chỉ lấy các config có tiền tố là "loda"

public class AppProperties {
    private  String email;
    private  String googleAnalyticsId;
    private List<String> authors;
    private Map<String, String> exampleMap;
}
