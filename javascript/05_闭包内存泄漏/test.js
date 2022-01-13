var foo = (num1, num2) => {
  return num1+num2
}

const full = ({ first, last }) => first + ' ' + last;

const person = {first: "tom", last: "jack"};
console.log(full(person))

let [arr1, ...arr2] = [1,2,3,4]
console.log(arr2)
