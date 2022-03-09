// message? -> undefined | string
function printMessage(message?: string) {
  // 保证message一定有值 !. 非空类型断言
  console.log(message!.length);
}