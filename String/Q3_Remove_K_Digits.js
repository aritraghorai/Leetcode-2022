var removeKdigits = function (num, k) {
  let arr = num.split("");
  let st = [];
  for (n of arr) {
    while (st.length !== 0 && st[0] > n && k > 0) {
      st.shift();
      k--;
    }
    st.unshift(n);
  }
  //*If Is not zero
  while (k > 0) {
    k--;
    st.shift();
  }
  //*If Has Leading Zero
  while (st.length != 0 && st[st.length - 1] == "0") {
    st.pop();
  }
  let s = "";
  while (st.length != 0) {
    s += st.pop();
  }
  return s === "" ? "0" : s;
};
let ans = removeKdigits("1234567890", 9);
console.log(ans);
