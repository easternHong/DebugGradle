```
//linux/Unix环境下
//1.
export GRADLE_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
//2.
gradle :app:clean -Dorg.gradle.debug=true  --no-daemon
gradle clean(**重点说明**) -Dorg.gradle.daemon=false -Dorg.gradle.debug=true
//3.edit Configration->创建remote
然后Run->Debug remote创建一个server
再次Run->Debug remote ，即可看到debug效果。
```

重点说明：'gradle-task'名字 : build ,clean ,assembleDebug ,

task对应关系
