let sortEvenOdd = function (nums) {
  let odd = [],
    even = [],
    res = [];
  nums.forEach((n, i) => {
    i % 2 == 0 ? even.push(n) : odd.push(n);
  });
  odd.sort((a, b) => b - a);
  even.sort((a, b) => a - b);
  let i = 0,
    j = 0;
  for (let i = 0; i < nums.length; i++) {
    i % 2 == 0 ? res.push(odd[i++]) : res.push(even[j]);
  }
  return res;
};
