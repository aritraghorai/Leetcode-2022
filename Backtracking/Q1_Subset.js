let subsets = function (nums) {
  let answer = [];
  helper(nums, 0, [], answer);
  return answer;
};
let helper = (nums, i, subset, answer) => {
  if (i == nums.length) {
    answer.push([...subset]);
    return;
  }
  subset.push(nums[i]);
  helper(nums, i + 1, subset, answer);
  subset.pop();
  helper(nums, i + 1, subset, answer);
};
