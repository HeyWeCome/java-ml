/**
 * 函数与方法的区别：
 *   函数：function，独立的function，那就称之为函数
 *   方法：method，当我们的一个函数属于某个对象时，我们称这个函数式这个对象的方法
 */

var nums = [10, 5, 11, 100, 55];

// filter：过滤，必须返回一个布尔值
// 遍历的时候有三个参数：item, index, arr
// item：当前的元素
// index：当前元素的下标
// arr：操作的数组
var newNums = nums.filter((item, index, arr) => {
  return item % 2 === 0; // 偶数的时候就返回
})

console.log(newNums);

// map：映射，对数组中每个元素进行操作
var newNums2 = nums.map((item, index, arr) => {
  return item*10;
})
console.log(newNums2)

// forEach：迭代
nums.forEach((item, index, arr) => {
  console.log(item);
})

// find/findIndex：找到某一个元素。用的很多
var item = nums.find((item) => {
  return item === 11
})

// reduce：对数组中的元素累加
// 这里初始化preValue为0，然后不断地累加，返回的值会给第二次的preValue
var addResult = nums.reduce( (preValue, currentValue, currentIndex, arr) => {
  return preValue + currentValue;
}, 0)
console.log("reduce累加结果为:", addResult);