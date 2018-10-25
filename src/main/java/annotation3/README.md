spring注解开发

首先通过
@PropertySource(value = {"jdbc.properties","classpath:common.properties", "classpath:abc.properties"})
载入配置文件
然后在通过@Value("${destinationLocation}")却获取实际的键值

关于@PropertySource放置的位置，先是放在主配置文件的类上，所有的容器bean都可以读取到。
后来移到某一个指定的容器bean上，所有的容器bean还是可以读取到。

@Value中的语法
1，
2，
3，
