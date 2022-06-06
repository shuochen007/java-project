# 一、规约

## 1.命名

【强制】类名所有首字母大写
【强制】变量名及方法名命名一般遵循驼峰原则  heathPoint
【强制】所有常量全部大写单词用下划线隔开 INIT_SPEED
【强制】所有命名禁止使用拼音命名以及中文命名
【强制】包名全部使用小写并且点分隔符之间有且只有一个单词
【推荐】枚举类以Enum结尾，枚举成员命名以常量命名为标准
【推荐】抽象类以Abstract开头
【推荐】数组命名，中括号与类型相连 如：String[] strs = .....

## 2.代码风格

【强制】二目运算符左右两边需要加一个空格 如：a = b
【强制】空代码块的花括号不需要换行，如public void nothing(){}
【强制】代码行过长需要换行，换行时尽量使得代码易读
【推荐】保留字如括号之间需要加空格如：while ()
【推荐】不同功能块之间代码使用空行隔开，使得同一功能代码尽量集中，不同功能代码区分明显

## 3.注释

【强制】新建类文件需要在类名上方创建类文档注释，并注明功能
【强制】对于某行代码的注释直接写在该行末尾，对于一个功能块的注释写在该功能块第一行代码的上方
【推荐】复杂的方法需要在方法上方创建方法文档注释（即javaDoc），并注明功能，参数，返回值

附：javaDoc使用说明：

```
/**
 * 格式说明类
 * @ClassName: type 
 * @Description: 格式说明类 
 * @author: lc
 * @CreateDate: 2022年6月6日 下午16：48
 */
```



| 标签          | 描述                                                   | 示例                                                         |
| ------------- | ------------------------------------------------------ | ------------------------------------------------------------ |
| @author       | 标识一个类的作者，一般用于类注释                       | @author description                                          |
| @deprecated   | 指名一个过期的类或成员，表明该类或方法不建议使用       | @deprecated description                                      |
| {@docRoot}    | 指明当前文档根目录的路径                               | Directory Path                                               |
| @exception    | 可能抛出异常的说明，一般用于方法注释                   | @exception exception-name explanation                        |
| {@inheritDoc} | 从直接父类继承的注释                                   | Inherits a comment from the immediate surperclass.           |
| {@link}       | 插入一个到另一个主题的链接                             | {@link name text}                                            |
| {@linkplain}  | 插入一个到另一个主题的链接，但是该链接显示纯文本字体   | Inserts an in-line link to another topic.                    |
| @param        | 说明一个方法的参数，一般用于方法注释                   | @param parameter-name explanation                            |
| @return       | 说明返回值类型，一般用于方法注释，不能出现再构造方法中 | @return explanation                                          |
| @see          | 指定一个到另一个主题的链接                             | @see anchor                                                  |
| @serial       | 说明一个序列化属性                                     | @serial description                                          |
| @serialData   | 说明通过 writeObject() 和 writeExternal() 方法写的数据 | @serialData description                                      |
| @serialField  | 说明一个 ObjectStreamField 组件                        | @serialField name type description                           |
| @since        | 说明从哪个版本起开始有了这个函数                       | @since release                                               |
| @throws       | 和 @exception 标签一样.                                | The @throws tag has the same meaning as the @exception tag.  |
| {@value}      | 显示常量的值，该常量必须是 static 属性。               | Displays the value of a constant, which must be a static field. |
| @version      | 指定类的版本，一般用于类注释                           | @version info                                                |

# 二、包

- frame：包含如开始、游戏中、结束的Frame
- main：包含程序入口和其它游戏控制
- model：
  - model.manager：包含元素管理器、工厂等，用于控制游戏各元素
  - model.vo：各种实体类，包括玩家、棋子等等
- thread：配合游戏一起执行的各种线程，如音乐、键盘监听、游戏控制等
- utils：工具包

# 三、类

#### exec.frame

GameFrame  游戏窗体类
GameJPanel 游戏画板类（用于展示元素管理器中所有元素）

#### exec.thread 

GameThread 游戏进程控制线程

MusicThread 音乐进程

KeyListener 按键监听进程

#### exec.main

GameControl 游戏总控制

GameStart 游戏启动

#### exec.model 

##### exec.model.manager

ElementFactory  棋子工厂（单例模式）
ElementManager   元素管理类

##### exec.model.vo 

SuperElement   顶级元素抽象类
Player 玩家类
Chess 棋子类 

Npc 电脑类

# 四、棋子名称以及属性

英雄属性：

生命 攻击  防御 技能 射程

技能类型（大致）： 流血 易伤 虚弱 治疗 反弹伤害的护盾 中毒 

英雄名称：
