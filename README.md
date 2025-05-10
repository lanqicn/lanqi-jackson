# README

## lanqi-jackson是什么
lanqi-jackson是基于jackson的扩展工具，在jackson原有功能的基础上，对日常开发中经常使用的配置、工具进行封装维护

## 主要功能
1. 将Long或Collection<Long>进行序列化时，转为对应的String类型，避免前端的精度丢失
```
DTO类：

    public class UserDTO {
    
        @JsonSerialize(using = LongToStringSerializer.class)
        private Long id;
    
        @JsonSerialize(using = CollectionLongToCollectionStringSerializer.class)
        private Collection<Long> roles;
            
        private String name;
    }
    
序列化后：   
 
    {
        "id": "54324456786544567865",
        "roles": ["54324456786544567834", "54324456786544567823"],
        "name": "demoUser"
    }
```
2. JsonUtil，提供了一些常用的json操作方法