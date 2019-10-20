### Shiro + JWT + mybatisplus 权限控制模块

##### restful接口

##### 数据库：使用了RBAC模型

user 用户表

| id   | username | password |
| ---- | -------- | -------- |
| 1    | admin    | 123456   |
| 2    | normal   | 123456   |

role 角色表

| id   | name        | permission |
| ---- | ----------- | ---------- |
| 1    | ROLE_NORMAL | view       |
| 2    | ROLE_ADMIN  | view,edit  |

user_roles 用户-角色表

| id   | user_id | role_id |
| ---- | ------- | ------- |
| 1    | 1       | 1       |
| 2    | 1       | 2       |
| 3    | 2       | 1       |

##### 使用了mybatis-plus代码生成器，详见：[mybatis-plus官方文档](<https://mybatis.plus/guide/generator.html>)

##### 实现通过注解控制访问权限