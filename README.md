# a weather forecast app
能看到各个主流城市的天气等情况
api使用示例参考http://v1.yiketianqi.com/api?unescape=1&version=v9&appid=74551559&appsecret=vbZzd6yh
![Uploading image.png…]()

 写的第一个正式一点的APP，很多看似很简单的功能，使用差不多的命名经常搞混代码，导致功能错误，中途更换过一次api接口，因为代码写的不整齐，bean中的接收数据没有对照好api接口，导致json解析失败，查看了log日志才发现问题，还有就是（在Android P(9.0) 以上系统，默认是禁止使用“http”明文网络传输的，会强制让应用都使用“https”。）这个问题卡了很久，最后查了很多才找到问题。还有就是中途Android Studio更新一次后崩了一次，在学长的指导下解决的问题。
有些想找的图片不好找，格式和尺寸转化不熟悉，导致界面有些功能没有做好，在未来熟悉后可能会回来完善。
