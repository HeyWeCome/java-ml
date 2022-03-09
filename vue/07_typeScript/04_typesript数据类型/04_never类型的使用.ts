//never 表示永远不会有返回值
function foo(): never {
  // 死循环
  while (true) {
    
  }
}

function bar(): never {
  throw new Error();
}

// 应用场景，封装一个核心函数
// 如果想改成handleMessage(message: string | number | boolean)，就会报错，让使用者完善这个方法
function handleMessage(message: string | number){
  switch (typeof message) {
    case 'string':
      console.log("string的处理方式");
      break;
    case 'number':
      console.log('number的处理方式');
      break;
    default:
      const check: never = message;
      break;
  }
}