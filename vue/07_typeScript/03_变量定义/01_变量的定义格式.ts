// 1.类型注解
var name: string = "heywcome";
let age: number = 23;
const height: number = 1.88;

// string: 表示 TS 中的字符串类型
// String: JS中的字符串包装类的类型
const message: string = "你好";

// foo 没有添加类型注解，但是TS自身有类型推导，会根据赋值推测出当前变量的类型
let foo = "foo";

export {}