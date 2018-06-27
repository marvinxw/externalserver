# externalserver

### Oracle 驱动配置

[http://blog.leanote.com/post/438123371@qq.com/SpringBoot%E8%BF%9E%E6%8E%A5Oracle%E6%95%B0%E6%8D%AE%E5%BA%9311g](http://blog.leanote.com/post/438123371@qq.com/SpringBoot%E8%BF%9E%E6%8E%A5Oracle%E6%95%B0%E6%8D%AE%E5%BA%9311g)

1. https://jar-download.com/

    下载ojdbc7 12.1.0.2

2. mvn (https://maven.apache.org/download.cgi)

    下载二进制的包 （apache-maven-3.5.3-bin.tar.gz 或 	apache-maven-3.5.3-bin.zip）

3. 解压 2. 下载的包
    
    ```text
       1> 
       apache-maven-3.5.3/bin/mvn install:install-file -Dfile=ojdbc7-12.1.0.2.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar
       
       /Users/xiaowen.ma/NustoreFiles/Coding/mvn/apache-maven-3.5.3/bin/mvn install:install-file -Dfile=ojdbc14-10.2.0.1.0.jar -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.1.0 -Dpackaging=jar
    
       2>
		repositories {  
		    mavenCentral()  
		    mavenLocal()  
		}
		
		3>
		dependencies {  
		    compile ("com.oracle:ojdbc7:12.1.0.1")  
		}
    ```
