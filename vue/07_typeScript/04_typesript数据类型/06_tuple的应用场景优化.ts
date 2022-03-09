// 优化内容：根据传入的参数定下来类型
// 使用泛型，我的java啊！
function useState<T>(state: T) {
  let currentState = state;

  const changeState = (newState: T) => {
    currentState = newState;
  }

  // 使用元组，传入参数类型使用泛型
  // (newState: T) => void 表示函数的返回类型
  const arr: [T, (newState: T) => void] = [currentState, changeState];
  return arr;
}

const [counter, setCounter] = useState(10);
console.log(counter);

const [title, setTitle] = useState("abc");

const [flag, setFlag] = useState(true);

export {}