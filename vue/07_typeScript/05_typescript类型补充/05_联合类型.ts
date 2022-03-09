function printID(id: number | string) {
  // 使用联合类型的值要小心
  if (typeof id === 'string'){
    console.log(id.toUpperCase());
  } else {
    console.log(id);
  }
}

printID(123);
printID("heywecome");