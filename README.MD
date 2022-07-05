这是一个简单的脱敏工程

简单支持Jackson后续会陆续扩展并且支持fastjson，gson等

对象类注释
```java
// 身份证号
@ExcludeSensitive(handler = IdCardHandler.class)
private String idCard;
```

已实现：
1. 脱敏开启关闭
2. 按照不同注解配置动态匹配脱敏规则
3. 按照注解动态过滤某些接口某个字段不脱敏

