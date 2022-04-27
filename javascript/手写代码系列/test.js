function reverseBetween( head ,  m ,  n ) {
  let dummy = new ListNode(-1);
  dummy.next = head;
  let pre = dummy;
  for (let i = 0; i < m - 1; i++) {
    pre = pre.next;
  }
  //pre:前一个节点 cur:当前节点 ,curnext:下一个节点
  let cur = pre.next;
  let curnext;
  for (let i = 0; i < n - m; i++) {
    curnext = cur.next;
    //从后往前连起来
    //pre-->cur-->curnext
    //1----->2--->3----->4
    //2--->4
    cur.next = curnext.next;
    //3-->2
    curnext.next = pre.next;
    //1--->3
    pre.next = curnext;
    //1-->3-->2-->4
  }
  return dummy.next;
}