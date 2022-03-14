import java.util.HashMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 爬楼梯 递归 数学归纳法得出，有n阶台阶那么就是 n - 1 阶台阶和 n - 2 阶台阶爬上楼顶的方法的和。
 * 公式： f(n) = f(n - 1) + f(n - 2) 时间复杂度：O(n) 空间复杂度：O(n)
 */
public class ClimbStairs {
    public static void main(String[] args) {

        int i = climbStairs(22);
        System.out.println(i);

    }

    static HashMap<Integer,Integer> map = new HashMap<>();
    public static int climbStairs(int n){
        // 递归终止条件
        if (n==1) return 1;
        if (n==2) return 2;

        if (map.containsKey(n)) return map.get(n);

        int sum = climbStairs(n-1) + climbStairs(n-2);
        map.put(n,sum);

        return sum;
    }

    // 爬楼梯 动态规划 时间复杂度O(n) 空间复杂度 O(1)
    public static int climbStairs_2(int n){
        int p=0; int q=0; int r=1;
        for (int i = 0; i < n; i++) {
            p=q;
            q=r;
            r=p+q;
        }

        return r;
    }

    // 爬楼梯 直接用斐波那契数列 通项公式
    public static int climbStairs_3(int n){
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1+sqrt5)/2,n+1) - Math.pow((1-sqrt5)/2,n+1);
        return (int) Math.round(fibn/sqrt5);
    }
}
