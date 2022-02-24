var majorityElement = function (nums) {
  let ansI = 0,
    count = 0;
  for (let i = 1; i < nums.length; i++) {
    nums[i] === nums[ansI] ? count++ : count--;
    if (count < 0) {
      count = 0;
      ansI = i;
    }
  }
  return nums[ansI];
};
