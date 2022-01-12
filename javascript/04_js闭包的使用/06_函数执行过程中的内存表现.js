function foo() {
  var name = "foo"

  function bar() {
    console.log("bar", name)
  }

  return bar
}

var fn = foo()
fn()

// 当foo执行结束之后，由于bar引用到了foo()，所以它的AO一直不会释放，这也就是内存泄漏问题
// 我们可以手动释放该内存
fn = null