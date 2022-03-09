function foo() {
  return "abc";
}

function bar() {
  return 123
}

let flag = true;
let result: unknown; // unknown类型只能赋值给any和unknown类型
// any可以赋值给任意类型

if (flag) {
  result = foo();
} else {
  result = bar();
}

// unknown类型只能赋值给any和unknown类型，下面就会报错，主要是怕操作者拿到之后乱用
// let messgae: string = result;
// let num: number = result;

export {}