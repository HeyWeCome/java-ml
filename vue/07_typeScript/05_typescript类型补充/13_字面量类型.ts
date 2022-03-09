// Hello World也是可以作为类型的，叫做字面量类型
const message = "Hello World";

export {}

// 字面量类型的意义，就是必须结合联合类型
let Alignment: 'left' | 'right' | 'center' = 'left';
let align = Alignment = 'left';
