package demo.eu.algorithm;

import java.util.Arrays;

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){return -1;}
        int n = gas.length;
        int[] rest = new int[n];
        for(int i = 0; i < n; i++){
            rest[i] = gas[i] - cost[i];
        }
        int cnt = 0;
        int tag = 0;
        for(int i = 0; i < n; i++){
            cnt += rest[i];
            if(cnt < 0){
                cnt = 0;
                tag = i+1;
            }
        }
        if(tag==n){
            return -1;
        }
        return tag;
    }
}
