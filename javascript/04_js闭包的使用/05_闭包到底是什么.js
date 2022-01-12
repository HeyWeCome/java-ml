function foo() {
  var name = "foo"

  function bar() {
    console.log("bar", name)
  }

  return bar
}

var fn = foo()
fn()

/**
 * 一个普通的函数function，如果它可以访问外层作用域的自由变量，那么这个函数就是一个闭包；
 * 从广义的角度来说：JavaScript中的函数都是闭包；
 * 从狭义的角度来说：JavaScript中一个函数，如果访问了外层作用域的变量，那么它就是一个闭包。（面试用这个回答，当然上面的也可以说，一起说）
 */