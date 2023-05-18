# 数据收集平台服务端

## mqtt payload实例
+ 血氧仪
```json
{
  "SaO2": 98,
  "PR": 76
}
```

## 依赖
+ jdk20(java 17)
+ spring-boot-starter-rocketmq
+ netty-all(include netty/codec/mqtt)