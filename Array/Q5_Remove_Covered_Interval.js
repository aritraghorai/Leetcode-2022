var removeCoveredIntervals = function (intervals) {
  intervals.sort((a, b) => (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
  let end = 0,
    count = 0;
  intervals.forEach((element) => {
    if (element[1] > end) {
      count++;
      end = element[1];
    }
  });
  return count;
};
