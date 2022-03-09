function foo(message: string) {

}

const names = ["abc", "cba", "nba"];
// element根据上下文环境推导出来，这时候可以不添加类型注解
names.forEach(element => {
  console.log(element.length);
});
export {}