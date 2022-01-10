function foo() {
  var a = b = 100

  // 转成下面两行代码
  // var a = 10
  // b = 10
}

foo()

console.log(a)
console.log(b)

/**
 * 未定义报错
 */