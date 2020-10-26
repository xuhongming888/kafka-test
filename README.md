## 命令行执行jar包

##### 一、如果java定义了jar包的main class入口，则使用如下命令
```shell
$ java -jar myjar.jar
```

注：若带有参数(作为args，传给main函数) </br>
```
$ java -jar myjar.jar param1 param2
```

##### 二、如果Java没有定义jar的main class入口，则使用如下命令
```
$ java -cp myjar.jar com.example.MainClass
```

注：若带有参数(作为args，传给main函数) </br>
```
$ java -cp myjar.jar com.example.MainClass param1 param2
```

