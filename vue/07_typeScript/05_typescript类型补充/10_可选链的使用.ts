type Person = {
  name: string
  friend?: {
    name: string
    age?: number
  }
}

const info: Person = {
  name: "heywecome",
  friend: {
    name: "kangkang"
  }
}

console.log(info.friend?.age);
export {}