echo off
set JAVA_HOME=C:\work\java\jdk1.8.0_102
set M2_HOME=C:\work\Java\apache-maven-3.0.3
set ANT_HOME=C:\work\Java\apache-ant-1.8.2

set PATHP=%PATH%
set PATH=%PATH%;%M2_HOME%\bin;%ANT_HOME%\bin

mvn clean

set PATH=%PATHP%
