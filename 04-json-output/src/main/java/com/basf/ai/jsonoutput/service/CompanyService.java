package com.basf.ai.jsonoutput.service;

import com.basf.ai.jsonoutput.entity.CompanyInfo;
import com.basf.ai.jsonoutput.entity.CompanyRecommend;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private ChatClient chatClient;


    public CompanyRecommend analyze(String message) {
        return chatClient.prompt()
                .system("""
                            你是食品专业就业顾问。
                            
                            要求：
                            1. 只推荐央企
                            2. 返回3家公司
                            3. 必须包含岗位
                            4. 必须说明匹配原因
                            """)
                .user(message)
                .call()
                .entity(CompanyRecommend.class);
    }
}
