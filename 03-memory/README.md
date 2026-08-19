# day03-memory

## 学习目标
理解LLM无状态， 通过ChatMemory实现多轮对话

## 核心流程
用户输入 -> conversationId → ChatMemory获取历史消息 -> ChatClient组装上下文 -> 调用LLM -> 保存新的消息

## 核心组件
- ChatClient
- ChatMemory
- MessageChatMemoryAdvisor
- ConversationId