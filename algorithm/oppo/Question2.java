package algorithm.oppo;

import java.util.HashMap;

/**
 * 输入：
 *  第一行：数字n，代表数组的长度
 *  第二行：n个数字，代表数组[a1, a2, ..., an]
 * 求：
 *  按顺序分别去掉数组中的第i个数字，求剩余数组的最小未出现的非负整数
 * 例：
 *  输入：5
 *       0 1 2 3 3
 *  输出：
 *       0 1 2 4 4
 *       [
 *       i=0: 去掉nums[0]，数组[1,2,3,3]中最小未出现的非负整数为0
 *       i=1: 去掉nums[1]，数组[0,2,3,3]中最小未出现的非负整数为1
 *       i=2: 去掉nums[2]，数组[0,1,3,3]中最小未出现的非负整数为2
 *       i=3: 去掉nums[3]，数组[0,1,2,3]中最小未出现的非负整数为4
 *       i=4: 去掉nums[4]，数组[0,1,2,3]中最小未出现的非负整数为4
 *       ]
 */

// 第一遍遍历：找到数组中最小未出现的非负整数mem, 并且hash_map[nums[i]]+=1
// 第二遍遍历：判断：nums[i]和mem大小比较 以及 hash_map[nums[i]]>1?
// if(nums[i]<mem && hash_map[nums[i]]>1) return mem;
// else if(nums[i]<mem && hash_map[nums[i]]==1) return nums[i];
// else return mem;

public class Question2 {
    public void getMem(int n, int[] nums){
        int mem = 0;
        HashMap<Integer, Integer> Sites = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++){
            Sites.put(nums[i], Sites.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < n; i++){
            if (Sites.containsKey(mem)){ mem++;}
            else{break;}
        }

        for(int i = 0; i < n; i++){
            if(nums[i]<mem){
                if(Sites.get(nums[i])>1){System.out.print(mem);}
                else{System.out.print(nums[i]);}
            }
            else{System.out.print(mem);}
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        int n = 5;
        int[] nums = {0, 1, 2, 3, 3};
        q.getMem(n, nums);
    }
}
