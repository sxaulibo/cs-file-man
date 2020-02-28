# CS-FLY
本次需求涉及的系统：*cs-file-man*，需求编号：**CS-FLY**

## 所属
公司/组织：*www.sxau.com*

部门/业务线：*cloud system*

小组/模块：*file management*

## 需求

需求1：文件管理
- `ls`：查询当前目录下的文件
- `cd`：进入到指定目录
- `mkdir`：创建文件夹
- `pwd`：查询当前目录全路径

需求2：用户相关
- `login` 
- `logout`
- `get`

## 系统设计

### 前后端交互接口设计
- 当前目录由前端存储
- 使用token，来识别用户身份

### 数据关系模型设计
实体：文件、用户、token
关系：文件-文件、文件-用户、token-用户

### 注意事项
- 同一个文件夹下不能有重名文件或文件夹 mkdir
- 文件不能新建 mkdir
- 文件不能 ls
- 校验是否存在文件夹匹配、不能文件名 cd
- 查询

### 组件框架:
- web：spring boot
- JDBC: mybatis
- package management：maven
- db: mysql
- build: jdk 1.8
- deploy: tomcat