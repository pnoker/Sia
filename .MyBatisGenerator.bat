@echo off
echo==========mybatis��ʼ���ɴ���================
java -jar src/main/webapp/WEB-INF/lib/mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite
pause
