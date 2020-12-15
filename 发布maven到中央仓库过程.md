# 发布maven到中央仓库
先注册账号密码
https://issues.sonatype.org


新建issue
项目需要选择
Community Support - Open Source Project Repository Hosting



在issue上根据客服指示建好repo等



安装hpg
https://www.gnupg.org/download/


windows下安装好后会有一个程序叫Kleopatra
打开然后文件->新建密钥队，记住密码，发布到服务器



在setting xml配置
<server>
<id>sonatype_releases</id>
<username>your user name</username>
<password>your password</password>
</server>
<server>
<id>sonatype_snapshots</id>
<username>your user name</username>
<password>your password</password>
</server>


pom里配置，参考这个项目的


然后执行命令
mvn clean javadoc:jar deploy -P release

release要跟id一致



https://oss.sonatype.org/#stagingRepositories
先close 再release



