# Jenkins
1. 安装Java环境
2. 安装Jenkins(以war包为例)
   1. 从官网下载对应的war包 wget http://mirrors.jenkins.io/war-stable/2.121.3/jenkins.war
   2. 启动：java -jar jenkins.war & 以后台方式启动
   3. 启动完成后,访问 localhost:8080 进入欢迎页面，输入在启动时控制台打印的密码
   4. 选择插件安装（一般选择推荐安装）
   5. 创建一个用户，开始使用
   6. 停止Jenkins服务：localhost:8080/exit 即可在网页中停止服务
3. 