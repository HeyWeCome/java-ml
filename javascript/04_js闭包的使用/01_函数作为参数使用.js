/**
 * 实例一：将函数作为另外一个函数的参数传递进去
 * @param {*} someFunction 
 */
function foo(someFunction) {
  someFunction()
}

function bar() {
  console.log("bar")
}

foo(bar)

/**
 * 案例：计算器，传递两个参数和一个function来决定操作内容
 * @param {*} num1 
 * @param {*} num2 
 * @param {*} calcFn 
 */
function calc(num1, num2, calcFn) {
  console.log(calcFn(num1, num2))
}

function add(num1, num2) {
  return num1 + num2
}

function sub(num1, num2) {
  return num1 - num2
}

var m = 20
var n = 30
calc(m, n, add)
calc(m, n, sub)