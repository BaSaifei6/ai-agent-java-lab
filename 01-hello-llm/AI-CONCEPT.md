# Spring AI概念：
   Spring AI 是 Spring 官方推出的 AI 应用开发框架，它统一封装了不同大模型的调用方式，
   并提供 Prompt、Memory、Tool Calling、RAG 等能力，让开发者可以像使用 Spring 生态一样开发 AI 应用。

dependencyManagement 负责"规定版本"，不会自动引入依赖；dependencies 才是真正把依赖加入项目。

# ChatClient是什么？
Spring AI 提供的调用聊天模型的客户端。

# DeepSeek为什么能用 OpenAI Starter？
因为 DeepSeek 提供兼容 OpenAI API 的接口。