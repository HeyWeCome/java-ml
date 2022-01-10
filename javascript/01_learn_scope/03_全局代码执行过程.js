// var name = "kang"

// function test() {
//   var name = "test"
//   console.log(name)
// }
// console.log(name)
// console.log(num1)
// var num1 = 20
// var num2 = 30
// var result = num1 + num2
// console.log(window)

var message = "Hello Global"

function bar() {
  var message = "Hello Bar"
  foo()

  function foo() {
    console.log(message)
  }
}

bar()

/**
 * 1. 代码被解析时，v8引擎内部会帮助我们创建一个对象(GlobalObject -> go)；
 * 2. 运行代码：
 *    2.1 v8为了运行代码，v8引擎内部会有一个执行上下文栈(Execution Context， ECStack)(函数调用栈)
 *    2.2 因为我们执行的是全局代码，为了全局代码能够正常执行，需要创建全局执行上下文(Global Execution Context)(全局代码需要被执行时才创建)
 */