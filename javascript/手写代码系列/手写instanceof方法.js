/**
 * instanceof用于判断构造函数的 prototype 属性是否出现在对象的原型链中的任何位置
 * 首现步骤：
 * 1.首先获取类型的原型；
 * 2.然后获取对象的原型；
 * 3.然后一直循环判断对象的原型是否等于类型的原型，直到对象原型为null，因为原型链最终为null
 * @param {*} left 
 * @param {*} right 
 */
function myInstanceof(left, right) {
  let proto = Object.getPrototypeOf(left); // 获取对象的原型
  let prototype = right.prototype;  // 获取构造函数的 prototype 对象

  // 递归判断构造函数的 prototype 对象是否在对象的原型链上
  while (true) {
    if (!proto) return false;
    if (proto === prototype) return true;

    proto = Object.getPrototypeOf(proto);
  }
}

const myArr = [];
console.log(myInstanceof(myArr, Array));