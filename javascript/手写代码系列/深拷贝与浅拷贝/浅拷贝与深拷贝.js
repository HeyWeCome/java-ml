/**
 * 浅拷贝：
 * Object.assign
 * Array.prototype.slice()、Array.prototype.concat()
 * @param {*} obj 
 * @returns 
 */
function shallowClone(obj) {
  const newObj = {};
  for (const prop in obj) {
    if (obj.hasOwnProperty(prop)) {
      newObj[prop] = obj[prop];
    }
  }
  return newObj;
}

let obj = {
  age: 18,
  nature: ['smart', 'good'],
  names: {
    name1: 'he',
    name2: 'kangkang'
  },
  love: function () {
    console.log('i love u');
  }
}

let newObj1 = shallowClone(obj);
// console.log(newObj1);
let newObj2 = Object.assign({}, obj);
// console.log(newObj2);


/**
 * 深度拷贝
 * @param {*} obj 
 * @param {*} hash 
 */
function deepClone(obj, hash = new WeakMap()) {
  if (obj == null || typeof obj !== 'object') return obj; // 如果是null或者undefined或者不是对象，直接返回，这里使用了隐式转换
  if (obj instanceof Date) return new Date(obj);
  if (obj instanceof Set) return new Set([...obj]);
  if (obj instanceof RegExp) return new RegExp(obj);
  if (hash.has(obj)) return hash.get(obj);
  
  let cloneObj = {};
  hash.set(obj, cloneObj);
  for (let key in obj) {
    if (obj.hasOwnProperty(key)) {
      // 实现一个递归拷贝
      cloneObj[key] = deepClone(obj[key], hash);
    }
  }
  return cloneObj;
}

// 测试数据项
var data = {
  age: 18,
  name: "liuruchao",
  education: ["小学", "初中", "高中", "大学", undefined, null],
  likesFood: new Set(["fish", "banana"]),
  friends: [
        { name: "summer",  sex: "woman"},
        { name: "daWen",   sex: "woman"},
        { name: "yang",    sex: "man" }  ], 
  work: { 
          time: "2019", 
          project: { name: "test",obtain: ["css", "html", "js"]} 
        }, 
  play: function() {    console.log("玩滑板");  }
}

const deepCloneObj = deepClone(data);
console.log(deepCloneObj);
