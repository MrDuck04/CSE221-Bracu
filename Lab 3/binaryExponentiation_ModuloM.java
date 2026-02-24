//task3
import java.util.*;
import java.io.*;
public class binaryExponentiation_ModuloM {
    public static long mod = 107;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long base = Long.parseLong(st.nextToken());
        long power = Long.parseLong(st.nextToken());
        System.out.println(power(base,power));
    }
    public static long power(long base, long power){
        long result = 1;
        while (power > 0) {
            if((power & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            power >>= 1;
        }
        return result;
    }
}
