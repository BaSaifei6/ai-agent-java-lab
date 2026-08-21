package com.basf.ai.toolcalling.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CommonTools {
    @Autowired
    private RestClient restClient;
    @Tool(description = "获取当前位置天气")
    public String getWeather(@ToolParam(description = "城市名称") String city) {
        String result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("uapis.cn")
                        .path("/api/v1/misc/weather")
                        .queryParam("city", city)
                        .build())
                .retrieve()
                .body(String.class);


        return result;

    }
}
