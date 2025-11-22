package interview150.arrayorstring;

/**
 * num88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为
 * 了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
 * nums2 的长度为 n 。
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 思路：双指针，从后往前遍历，比较两个数组的元素，将较大的元素放入nums1中，
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int length = m + n;
        while (length > 0) {
            if (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[length - 1] = nums1[index1];
                    index1--;
                } else {
                    nums1[length - 1] = nums2[index2];
                    index2--;
                }
                length--;
            } else {
                if (index1 >= 0) {
                    nums1[length - 1] = nums1[index1];
                    index1--;
                    length--;
                }
                if (index2 >= 0) {
                    nums1[length - 1] = nums2[index2];
                    index2--;
                    length--;
                }
            }
        }
    }
}
