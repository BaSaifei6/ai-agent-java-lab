# 01-hello-llm

基于 Spring AI 调用 DeepSeek 大语言模型的第一个示例。

## 技术栈

- Java 17
- Spring Boot 4
- Spring AI 2.0
- DeepSeek API

## 实现功能

通过 Spring AI ChatClient 调用 DeepSeek 模型，实现简单对话。

调用流程：

浏览器
↓
Spring Boot Controller
↓
Spring AI ChatClient
↓
DeepSeek API
↓
返回结果

## 配置说明

创建 application-local.yml：

```yaml
spring:
  ai:
    openai:
      api-key: your-api-key