
										对maven的使用和该框架的简单介绍

1.maven

需要安装maven的eclipse插件和maven客户端

替换maven客户端安装目录下的apache-maven-3.0.5\conf\settings.xml

在run configurations下的mavenBuild配置
maven 环境变量
创建MAVEN_HOME
D:\soft\apache-maven-3.0.5
在path环境变量后添加
;%MAVEN_HOME%\bin


eclipse安装maven插件
安装地址：http://download.eclipse.org/technology/m2e/releases
装完需配置eclipse使用maven的默认程序改为本地maven


mvcspring_run 程序运行
Goals=jetty:run
mvcspring_flush flush
eclipse:clean eclipse:eclipse
mvcspring_war 编译打包
clean compile war:war

2.框架简单介绍

1.文件夹介绍
  src/test/java文件夹 保存测试案例的java类
  src/test/resource文件夹 保存测试需要的配置文件
  src/main/java文件夹 保存开发代码
  src/main/resource文件夹 保存开发需要的配置文件
  Logs文件夹 保存日志文件
  target 文件夹 保存运行产生的文件或生成的war包
  src/main/webapp 文件夹 保存前端相关文件
  以下文件夹下保存的文件需要进行分类：
  src/main/webapp/css 文件夹 保存css文件
  src/main/webapp/plugins 文件夹 保存一些插件
  src/main/webapp/js 文件夹 保存js文件
  src/main/webapp/images 文件夹 保存图片文件
  src/main/webapp/pages 文件夹 保存jsp页面
  src/main/webapp/pages/common 文件夹 保存公用的jsp页面
  src/main/webapp/pages/login 文件夹 保存登录相关的JSP页面(其他需自建)
2.java文件包目录作用介绍
common 保存一些公用的类
controller 控制器
entity   实体类
mapper mybatis接口(SQL操作)与配置文件对应
service 服务层接口
service.impl 服务层实现类
util 工具类
src/main/resource下的 X.X.mapper 下保存mybatis配置文件
2.开发中需要写那些文件
1.后端
  只需要编写对应的controller、service、mapper以及mybatis配置文件即可
2.前端
只需要像其他VIEW层框架一样编写即可，提交URL必须与controller中方法上注解的URL匹配

