// 传入一个对象类型, z可传可不传
function printPoint(point: {x: number, y: number, z?: number}) {
  console.log(point.x);
  console.log(point.y);
  console.log(point.z);
}

printPoint({x: 123, y: 321});
printPoint({x: 123, y: 321, z: 666});

export {}