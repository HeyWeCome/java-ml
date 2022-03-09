// 类型断言
const el = document.getElementById("heywecome") as HTMLImageElement

el.src = "url地址";


// 第二个例子，通过断言将 Person 转化为 Student
class Person {

}

class Student extends Person {
  studying() {

  }
}

function sayHello(p: Person) {
  (p as Student).studying()
}

const stu = new Student();
sayHello(stu);