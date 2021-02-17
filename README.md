## 基础语法

```text
1. 注释：即 <#-- 和--> ，介于其之间的内容会被freemarker忽略
2. 插值：${..} ，${..}部分，freemarker会用真实值代替${..}
3. FTL指令： 和HTML标签类似，名字前加#予以区分，freemarker会解析标签中的表达式或逻辑
4. 文本： 仅文本信息，这些不是freemarker的注释、插值、FTL指令的内容，会被freemarker忽略解析，直接输出内容。
```
## list指令

```text

```

## 遍历Map数据
```text
遍历map集合中的数据一共有三种方式可以获取
    1、通过存入域中的map['具体的那个Key'].属性
    2、通过key获取具体map的key实现，例:Map.stus.name
    3、遍历map的key来进行实现   使用list标签，第一种方式类型，唯一不同的是拿取到的是Map中的所有Key
        list map?keys as key
        ${map[key].name}
    4、判空使用if或者缺省默认!""
```
## if指令
```html
            <td <#if stu.name=="小红">style="background:red;"</#if>>${stu.name}</td>
```
## 空值处理
> 判断某变量是否存在使用"??"
> 用法：variable??,如果存在，返回true，否则返回false
缺失变量默认值使用"!"
> 使用！可以指定一个默认值，当变量为空时显示默认值。
> 例如：${name!''} ，表示如果name为空，则显示空字符串。
> 如果是嵌套对象则建议使用（）括起来
> 例如：${(stu.bestFriend.name)!'''} ,如果stu或者bestFriend或者name为空，默认显示空字符串。
```html
            <td>
                <#if stu.friends??>
                    <#list stu.friends as friend>
                        ${friend.name!''}
                    </#list>
                </#if>
            </td>
```
## 内置函数
> 语法格式： 变量+?+函数名称

### 1。得到某个集合的大小
> ${集合名?size}

### 2。日期格式化

```java
显示年月日：${today?date}
显示时分秒：${today?time}
显示日期+时间：${today?datetime}
自定义格式化：${today?string("yyyy年MM月")}
```

### 3.内置函数c

> ```
> 内建函数C将整数转换为字符串输出
> 
> 如果变量类型为数字类型，默认会每三位使用逗号分割，使用内置函数c，就会转成字符串显示（不会使用都好每三位分割）
> 例子：${point?c}
> 
> ```

### 4. 将JSON字符串转成对象

使用assign标签，将页面中的 text JSON 字符串，转换成 data对象,然后再在对象中获取对应属性值。

示例：

```
<#assign text="{'bank':'工商银行','account':'62288888899'}" />
<#assign data=text?eval />

开户行:${data.bank} 账户:${data.account}
```



