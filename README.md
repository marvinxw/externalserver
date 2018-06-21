# externalserver

### Oracle 驱动配置

1. https://jar-download.com/

    下载ojdbc7 12.1.0.2

2. mvn (https://maven.apache.org/download.cgi)

    下载二进制的包 （apache-maven-3.5.3-bin.tar.gz 或 	apache-maven-3.5.3-bin.zip）

3. 解压 2. 下载的包
    
    ```text
       1> 
       apache-maven-3.5.3/bin/mvn install:install-file -Dfile=ojdbc7-12.1.0.2.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar
       
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
