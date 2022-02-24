var titleToNumber = function (columnTitle) {
  let ans = 0;
  let n = 1;
  for (let i = columnTitle.length - 1; i >= 0; i--) {
    ans += (columnTitle.charAt(i).charCodeAt(0) - "A".charCodeAt(0) + 1) * n;
    n *= 26;
  }
  return ans;
};
