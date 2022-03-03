import { ref, watch } from 'vue';

// 传进来一个值就是取值；传进来两个值就是保存值
export default function(key, value) {
  const data = ref(value);

  if (value) {
    window.localStorage.setItem(key, JSON.stringify(value));
  } else {
    JSON.parse(window.localStorage.getItem(key));
  }

  watch(data, (newValue) => {
    window.localStorage.setItem(key, JSON.stringify(newValue));
  })

  return data;
}

// 一个参数：取值
// const data = useLocalStorage("name");

// // 两个参数：保存值
// const data = useLocalStorage("name", "heywcome");