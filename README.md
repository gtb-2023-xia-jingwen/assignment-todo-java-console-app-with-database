# Assignment todo Java Console Application

## 简介

本次 assignment 的目标是实现一个 Java Console Application。

## 需求说明

整体需求跟 Step02 的 `assignment-todo-java-console-app` 完全一样的，请自行参考。 **技术要求有所区别，请务必注意**

结合上一次 assignment review 的大部分结果，**请务必注意**：

1. 程序运行方式请严格遵循 **技术要求** 中第一部分的说明，不要随意修改程序的运行方式；
1. 所有固定地输出内容，如：“命令不存在的提示”、“初始化成功后的提示”，要同需求描述或截图完全一致，否则自动化测试会判其为失败；
1. 需求中对于任何不确定的细节，请及时跟 coach 联系、确认；

## 技术要求

1. 在代码库的根目录下，可以通过以下方式运行你的 Java Console Application：
   1. `./gradlew run --args "init"`
   1. `./gradlew run --args "list"`
   1. `./gradlew run --args "add foobar"`
   1. `./gradlew run --args "add foobar buzz"`
   1. `./gradlew run --args "add 'foo bar'"`
   1. `./gradlew run --args "add 'foo    bar'"`
   1. `./gradlew run --args "add foobar 'foo   bar'"`
1. 如无需传任何参数，请使用以下方式：
   1. `./gradlew run`
1. 不允许修改 build.gradle 文件，如有特殊原因，请先跟 coach 进行沟通；
1. 不允许以任何形式自行添加任何其它第三方依赖或库到代码库中；
1. 如需在磁盘上保存任何数据，请确保符合以下要求：
   1. 请使用 **MySQL数据库** 存储应用所需数据，不可以使用文件等其他方式；
   1. 请使用代码仓库提供的 `start-mysql-from-docker.sh`，`stop-mysql-from-docker.sh` 脚本启停 **MySQL数据库**；
   1. 数据库启停脚本基于 Docker ，使用启停脚本时请确保你的 Docker 应用（软件）是 **运行中** 的
   1. 所需的数据表名字需定义为 **tasks** （请注意此项，否则会影响自动化测试的运行结果），表结构可以自行设计；
   1. 数据库的连接方式可参考 `homework-jdbc-answer` 的实现；
1. 不可以使用任何方式的网络通讯；
1. 数据库连接信息：
   1. **username**: root
   1. **password** : p@ssword
   1. **database** : todoapp
   1. **host** : localhost
   1. **port** : 13306
1. 使用 Git 进行版本管理：
   1. 小步提交；
   1. 使用合理的 commit message；
   1. Commit message 格式需符合 [Conventional Commits](https://www.conventionalcommits.org/) ；
1. 以下使用场景，它们不在目标考查范围内，你无需为它们做特别处理：
   1. 并发的使用场景，换言之，就是无需考虑是否有多个使用者和（/或）多处在同时运行某个 todo command；
   1. 不必为可创建的任务数量的上限做任何处理，即可以支持无限多的任务，直到 系统/机器 挂掉为止；（我们目前不会这样去 使用/测试 它）
   1. 任务标题的长度也无需做任何限制，同上，我们不会变态的去做这样的测试；（但不代表未来真实的项目里没有这种人或这样的情况😁）

## 提交要求

1. 请在 coach 建议的完成时间内提交，提交时请确保录屏也已完成；
2. **注意: 同学录屏时必须安装并开启 IDEA "Presentation Assistant" 插件，确保 Buddy 可以观察到具体快捷键操作**
3. **注意: 快捷键使用刻意练习。本次 Assignment 中需要掌握**
   1. "运行程序" （Mac: ^ + ⇧ + R, Windows: Ctrl + Shift + F10）
   2. "提取方法" （Mac: ⌘ + ⌥ + M, Windows: Ctrl + Alt + M） 的快捷键使用，请确保录屏中包含了该快捷键的使用
4. 通过金数据表单提交 assignment，提交成功后会收到系统通知；
5. 批改 assignment 会使用提交时间点所对应的版本，请务必在确认无误后再进行提交；
6. 获取录屏的具体方式请写在代码仓库的 `RECORDING.md` 文件中，确保 buddy/coach 能够访问；
7. 本次 assignment 录屏时长需在 **45** 分钟以内；

## 我应该学到什么？

Assignment 的目的是学以致用，在运用当前 step 所学的知识和技能合理完成题目要求的前提下，你 应该/可能 会使用（但不限于）以下内容：

1. 使用 CLI git 完成本地的提交管理及与远端的各种同步操作；
2. 使用 SQL 完成如下基础操作：
   1. 数据的增删改查；
   1. 数据表的创建，这里是 [参考](https://www.liaoxuefeng.com/wiki/1177760294764384/1246617774585536) ；
   1. 数据表的数据清理；
3. 使用 JDBC 连接并操作 MySQL 数据库：
   1. 使用 try-with-resource 语法自动释放 JDBC 数据库连接相关资源
   1. 判断表是否存在，这里是 [参考](https://www.baeldung.com/jdbc-check-table-exists) ；
4. 使用 Stream API 完成元素集合的处理
   1. skip、map、collect 等操作符的使用
5. 通过 Gradle 在 console 里运行一个 Java Application；
6.  快捷键 **"运行程序"** 和 **"提取方法"** 的使用

## 评分标准

Buddy 会根据以下指导规则对大家本次的 assignment 进行评级。

**特别提醒：**

本次 assignment 只是为了帮助大家了解自己的学习情况，不是为了考试评级，请大家不要有过多的心理负担。

给出一个明确的评级指导规则，是为了一方面让 buddy 们尽量能够统一标准。另一方面，也让大家能够明确目标。

对于初学者而言，能在学完当前 Step 后：

* 做到 Level-1 👉🏻 不错喽
* 做到 Level-2 👉🏻 很好
* 做到 Level-3 👉🏻 Fantastic!

### 功能实现

主要判断对需求的实现程度，会分为四个级别：

1. Level-0：无法达到 Level-1 时
2. Level-1：
   1. 能跑起来，可以使用最最简单的 1-2 个命令就算“能跑起来”
   2. 录屏中使用了 **"运行程序"** 和 **"提取方法"** 快捷键
3. Level-2：满足所有基本操作，能处理大部分常见的`正常和异常`使用场景
4. Level-3：能够处理全部或绝大部分的异常场景；

级别为递进关系，当前 Level 的所有测试必须全部通过，才能判定为达到该 Level。

### 代码实现

当前学习阶段主要关注以下代码实践，请在观看录屏后进行反馈：

1. 是否掌握了 Java 常用语法（包括但不限于 String、常用数据集合的使用等）；
1. 是否体现了对面向对象编程思想的 **初步** 掌握；
1. 是否正确的使用 JDBC（包括但不限于正确地关闭资源等）；

### 工程实践

当前学习阶段主要关注以下工程实践，请在观看录屏后进行反馈：

1. 录屏中使用了 **"运行程序"** 和 **"提取方法"** 快捷键
2. 根据视频判断是否是自己完成的，不是简单的记忆、模仿；
3. 是否实践了小步提交，且 message 内容合理；
4. 是否主动使用 IDE 的快捷键
5. 要保证 `./gradlew build` 是`干净的`，没有任何 warnings；

**如果你在完成 assignment 后，发现以上的大部分内容都并未涉及（使用）到，请及时联系 coach 进行沟通。**
