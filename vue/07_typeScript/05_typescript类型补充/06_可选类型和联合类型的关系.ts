// 让参数可选
// 当一个参数是一个可选类型的时候，它类似于表示的该参数是 类型 | undefined的联合类型
function foo(message?: string): void {
  console.log(message)
}

// function foo(message: string | undefined): void {
//   console.log(message)
// }

foo();
foo(undefined);
foo("heywecome");