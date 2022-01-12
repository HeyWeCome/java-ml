function createFnArray() {
  // 占据的空间为4M * 100 + 其他的内存 = 40M
  var arr = new Array(1024*1024).fill(1);
  return function() {
    console.log(arr.length);
  }
}

var arrayFns = [];
for (let index = 0; index < 100; index++) {
  arrayFns.push(createFnArray());
}

// 这一步主要是释放内存，不然会在浏览器中占用40M的空间
setTimeout(() => {
  arrayFns = null;
}, 2000);