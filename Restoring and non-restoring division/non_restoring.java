    import java.util.Scanner;

public class non_restoring {
    private static String toBinary(int decimalNumber, int numberOfBits) {
        String binaryString = Integer.toBinaryString(decimalNumber);

        // Pad the binary string with leading zeros if needed
        int padding = numberOfBits - binaryString.length();
        if (padding > 0) {
            StringBuilder paddedBinary = new StringBuilder();
            for (int i = 0; i < padding; i++) {
                paddedBinary.append("0");
            }
            paddedBinary.append(binaryString);
            return paddedBinary.toString();
        } else {
            return binaryString;
        }
    }
    private static int removeFirstBit(int number) {
        // Perform bitwise AND with a mask to remove the first bit
        int mask = Integer.MAX_VALUE; 
        int result = number & mask;

        return result;
    }
    public static String len(int l,String abinary,int desire){
        if(l<desire){
            int n = desire - l;
            for(int i=0;i<n;i++){
                abinary = "0" + abinary;
            }
            return abinary;
        }
        else{
            int n = l - desire;
             abinary = abinary.substring(n,l);
            return abinary;
        }
    }
    int binaryToDecimal(int n)
    {
        int num = n;
        int dec_value = 0;
        int base = 1;

        int temp = num;
        while (temp>0) {
            int last_digit = temp % 10;
            temp = temp / 10;
            dec_value += last_digit * base;
            base = base * 2;
        }
        return dec_value;
    }
    public void mainfun(){
        //System.out.println("Hi I am nonrestoring division algorithm");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dividend :");
        int q = sc.nextInt();
        System.out.println("Enter Divisor :");
        int m = sc.nextInt();
        int a =0;
        String qbinary = Integer.toBinaryString(q);
        int qbit = qbinary.length();
        String abinary = toBinary(a, qbit+1);
        String mbinary = toBinary(m, qbit+1);
        System.out.println("   M         A         Q   \n");
        System.out.println(mbinary+"         "+abinary+"         "+qbinary);
        System.out.println("______________________________________________________________");

        int n= qbit;
        while(n>0){
            int leftq = qbinary.charAt(0)-48;
            qbinary = qbinary.substring(1, qbinary.length());
            a = a<<1;
            a|= leftq;
            abinary = toBinary(a,qbit+1);
            abinary = len(abinary.length(),abinary,qbit+1);
            System.out.println(mbinary+"       "+abinary+"       "+qbinary+"?");

            if(abinary.charAt(0)=='1'){
                a=a+m;
                abinary = Integer.toBinaryString(a);
            }
            else {
                a= a-m;
                abinary = Integer.toBinaryString(a);
            }
            abinary = len(abinary.length(),abinary,qbit+1);
            System.out.println(mbinary+"       "+abinary+"       "+qbinary+"?");

            if(abinary.charAt(0)=='1'){
                //System.out.println("Add 0 at the last position "+abinary);
                qbinary += "0";
            }
            else if(abinary.charAt(0)=='0'){
                //System.out.println("Add 1 at the last position "+abinary);
                qbinary += "1";
            }

            abinary = toBinary(a,qbit+1);
            System.out.println(mbinary+"       "+len(abinary.length(),
            abinary,qbit+1)+"       "+qbinary);
            n--;
            System.out.println("______________________________________________________________");
        }
        System.out.println("Quotient :  "+Integer.parseInt(qbinary, 2));
        abinary = len(abinary.length(),abinary,qbit+1);
        if(abinary.charAt(0) == '1'){
            a+=m;
            abinary = Integer.toBinaryString(a);
        }
        System.out.println("Remainder :  "+Integer.parseInt(abinary, 2));
    }
}