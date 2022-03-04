import dayjs from "dayjs";

export default function registerFormatTime(app) {
  app.directive("format-time", {
    mounted(el, bindings) {
      // 传入用户自己想要的格式
      let formatString = bindings.value;

      formatString ? {} : formatString = "YYYY-MM-DD HH:mm:ss";

      const textContent = el.textContent;
      let timestamp = parseInt(textContent);
      if (textContent.length === 10) {
        timestamp = timestamp * 1000;
      }
      el.textContent = dayjs(timestamp).format(formatString);
    },
  })
}