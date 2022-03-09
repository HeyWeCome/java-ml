const info = {
  name: 'heywecome',
  age: 18
}

info.name = "111";

type Method = 'GET' | 'POST'
function request(url: string, method: Method){}

// type Request = {
//   url: string,
//   method: Method
// }

// const options: Request = {
//   url: "wangzhi",
//   method: "POST"
// }

const options = {
  url: "wangzhi",
  method: "POST"
}

request(options.url, options.method as Method)
export {}