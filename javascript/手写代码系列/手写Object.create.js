function create(obj) {
  function F() {};
  F.prototype = obj;
  return new F();
}

var a = [1,2,3];
console.log(create(a));