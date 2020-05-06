一、使用/code/generator/{moduleName}/{tableName}/{author} 接口，get请求方式，可以自动生成增删改查代码，
生成的代码路径在com.groundwater.support.modules下
    参数意义：
        1、moduleName 包名
        2、tableName 表名
        3、author 作者
    例子：/code/generator/test1/test/zws
二、modules.common目录中类说明
    共通的消息写在MsgUtil中，共通的常量类写在Constant中
三、增删改查的例子可以参照modules.user