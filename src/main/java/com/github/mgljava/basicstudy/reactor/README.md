## reactor http://blog.51cto.com/liukang/2090163
#### 在一个.ssh文件下生产多个邮箱的公钥：ssh-keygen -t rsa -C "youremail@email.com" -f ~/.ssh/second
#### 概念：响应式编程（reactive programming）是一种基于数据流（data stream）和变化传递（propagation of change）的声明式（declarative）的编程范式。
#### 网址：https://projectreactor.io/

### Flux与Mono
#### Reactor中的发布者（Publisher）由Flux和Mono两个类定义，它们都提供了丰富的操作符（operator）。一个Flux对象代表一个包含0..N个元素的响应式序列，而一个Mono对象代表一个包含零/一个（0..1）元素的结果。Flux和Mono都可以发出三种“数据信号”：元素值、错误信号、完成信号，错误信号和完成信号都是终止信号，完成信号用于告知下游订阅者该数据流正常结束，错误信号终止数据流的同时将错误传递给下游订阅者。
#### 5
