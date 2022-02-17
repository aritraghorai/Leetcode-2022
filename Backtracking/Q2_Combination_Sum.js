var combinationSum = function (candidates, target) {
  let res = [];
  helper(candidates, target, [], res, 0);
  return res;
};
let helper = (nums, target, li, res, i) => {
  if (target === 0) {
    res.push([...li]);
    return;
  }
  if (target < 0 || i == nums.length) {
    return;
  }
  li.push(nums[i]);
  helper(nums, target - nums[i], li, res, i);
  li.pop();
  helper(nums, target, li, res, i + 1);
};
console.log(combinationSum([2, 3, 6, 7], 7));
