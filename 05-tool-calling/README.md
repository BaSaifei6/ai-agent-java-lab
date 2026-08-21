# 工具调用

用户提问问题 LLM发现需要调用工具 就会调用工具拿到结果 LLM总结自然语言回答 返回给用户
Spring AI通过给程序传入对象，利用反射拿到方法描述，LLM去分析使用哪一个工具进而程序去调用。

开发者定义Tool对象

↓

Spring AI接收到Tool对象

↓

通过反射读取：

- 方法名
- description
- 参数
- 参数描述

↓

生成Tool Schema

↓

发送给LLM

↓

LLM根据用户问题选择Tool

↓

Spring AI根据LLM返回的Tool Call

↓

反射调用对应Java方法