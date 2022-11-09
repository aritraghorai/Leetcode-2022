package Design_DS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:09/11/2022
 ?Program Details:901. Online Stock Span
*https://leetcode.com/problems/online-stock-span/ 
   */
public class Q10_Online_Stock_Span {

}

class StockSpanner {
    private List<Integer> arr;
    private LinkedList<Integer> stack;

    public StockSpanner() {
        arr = new ArrayList<>();
        stack = new LinkedList<>();
    }

    public int next(int price) {
        arr.add(price);
        while (!stack.isEmpty() && arr.get(stack.peek()) <= price) {
            stack.pop();
        }
        int res = stack.isEmpty() ? arr.size() : arr.size() - stack.peek() - 1;
        stack.push(arr.size() - 1);
        return res;
    }

}
