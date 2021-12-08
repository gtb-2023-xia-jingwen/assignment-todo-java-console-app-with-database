# Assignment todo Java Console Application

## 简介

本次 assignment 的目标是实现一个 Java Console Application。

## 需求说明

整体需求跟 Step02 的 `assignment-todo-java-console-app` 的完全一样的，请自行参考。 **技术要求有所区别，请务必注意**

结合上一次 assignment review 的大部分结果，**请务必注意**：

1. 程序运行方式请严格遵循 **技术要求** 中第一部分的说明，不要随意修改程序的运行方式。
2. 所有固定地输出内容，如：“命令不存在的提示”、“初始化成功后的提示”，要同需求描述或截图完全一致，否则自动化测试会判其为失败；
3. 需求中对于任何不确定的细节，请及时跟 coach 联系、确认；

## 技术要求

1. 在代码库的根目录下，可以通过以下方式运行你的 Java Console Application： 
   1. `./gradlew run --args "init"`
   1. `./gradlew run --args "list"`
   1. `./gradlew run --args "add foo bar"`
1. 不允许修改 build.gradle 文件，如有特殊原因，请先跟 coach 进行沟通；
1. 不允许以任何形式自行添加任何其它第三方依赖或库到代码库中；
1. 如需在磁盘上保存任何数据，请确保符合以下要求：
   1. 请使用 **MySQL数据库** 存储应用所需数据，不可以使用文件等其他方式；
   1. 所需的数据库表结构，请自行设计及创建；
   1. 数据库的连接方式可参考 `homework-jdbc-answer` 的实现；
1. 不可以使用任何方式的网络通讯；

1. 使用 Git 进行版本管理：
   1. 小步提交；
   2. 使用合理的 commit message；
   3. Commit message 格式需符合 [Conventional Commits](https://www.conventionalcommits.org/) ；
1. 以下使用场景，它们不在目标考查范围内，你无需为它们做特别处理：
   1. 并发的使用场景，换言之，就是无需考虑是否有多个使用者和（/或）多处在同时运行某个 todo command；
   1. 不必为可创建的任务数量的上限做任何处理，即可以支持无限多的任务，直到 系统/机器 挂掉为止；（我们目前不会这样去 使用/测试 它）
   1. 任务标题的长度也无需做任何限制，同上，我们不会变态的去做这样的测试；（但不代表未来真实的项目里没有这种人或这样的情况😁）

## 提交要求

1. 请在 coach 建议的完成时间内提交，提交时请确保录屏也已完成；
2. 通过金数据表单提交 assignment，提交成功后会收到系统通知；
3. 批改 assignment 会使用提交时间点所对应的版本，请务必在确认无误后再进行提交；
5. 获取录屏的具体方式请写在 RECORDING.md 文件中，确保 buddy/coach 能够访问；
6. 本次 assignment 录屏时长需在 **45** 分钟以内；

## 我应该学到什么？

Assignment 的目的是学以致用，在运用当前 step 所学的知识和技能合理完成题目要求的前提下，你 应该/可能 会使用（但不限于）以下内容：

1. 使用 CLI git 完成本地的提交管理及与远端的各种同步操作；
1. 在 Java 中如何获取用户的 $HOME 目录位置；
1. Java 的基础语法
   1. if/for 等控制语句
   1. 创建文件夹及文件
   1. 文件读写（推荐使用 BufferedReader 和 BufferedWriter，这里是一个 [参考](https://www.youtube.com/watch?v=hgF21imQ_Is) ）
1. 通过 Gradle 在 console 里运行一个 Java Application；

**如果你在完成 assignment 后，发现以上的大部分内容都并未涉及（使用）到，请及时联系 coach 进行沟通。**
