# KLog
一个 Android 端日志查看工具，能够在手机上将堆栈、线程信息可视化，并且支持输出到文件中

目前已实现输出到控制台,包含如下信息:

1. 可直接打印对象,会转成 Json 输出
2. 打印执行的堆栈信息
3. 打印当前线程信息
4. 当崩溃发生时,自动拷贝崩溃信息到剪切板

以上日志信息只在 isDebug 为 true 时生效

### 依赖

* 项目 Gradle 添加

```css
// Project Root Gradle
repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
```

* 使用的模块中添加

  ```css
  dependencies {
  	        implementation 'com.github.maokai1229:KLog:0.1.0'
  	}
  ```