import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        System.out.println(tiling(n));
    }

    public static int tiling(int num) {
        // Bottom-Up 방식
        // A[n] = 2*n 직사각형을 타일로 채우는 방법의 수
        // 점화식 : A[n] = A[n-1] + A[n-2] (세로로 하나 놓았을 때 + 가로로 2개 놓았을 때)
        if (num < 2) {
            return memo[num];
        }
        for (int i=2;i<num+1;i++) {
            memo[i] = memo[i-1] + memo[i-2];
            memo[i] %= 10007;
        }
        return memo[num];
    }
}
