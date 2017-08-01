package NiuKe;

/**
 * Created by FYG on 17/7/31.
 */

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return helper(sequence, 0, sequence.length - 1);
    }

    public boolean helper(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int e = end;
        while (e > start && sequence[e - 1] > sequence[end]) {
            e--;
        }
        for (int i = e - 1; i >= start; i--) {
            if (sequence[i] > sequence[end]) {
                return false;
            }
        }
        return helper(sequence, start, e - 1) && helper(sequence, e, end - 1);
    }
}
