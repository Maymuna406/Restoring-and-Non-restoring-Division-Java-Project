    import java.util.*;
public class restoring {
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
        int n = desire - l;
        for(int i=0;i<n;i++){
            abinary = "0" + abinary;
        }
        return abinary;
    }
    public void mainfun (){
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
        //System.out.println(m+" "+a+" "+q);
        System.out.println("______________________________________________________________");

        int n = qbit;
        while(n>0){
            //left shift of a and q
            int leftq = qbinary.charAt(0)-48;
            qbinary = qbinary.substring(1, qbinary.length());
            a = a<<1;
            a|= leftq;
            abinary = toBinary(a,qbit+1);
            System.out.println(mbinary+"       "+abinary.substring
            ((abinary.length()-qbit-1),abinary.length())+"       "+qbinary+"?");
            a= a-m;
            abinary = toBinary(a,qbit+1);
            System.out.println(mbinary+"       "+abinary.substring
            ((abinary.length()-qbit-1),abinary.length())+"       "+qbinary+"?");
            if(abinary.charAt(0)=='1'){
                a=a+m;
                abinary = Integer.toBinaryString(a);
                qbinary+="0";
            }
            else qbinary+="1";
            System.out.println(mbinary+"       "+len(abinary.length(),
            abinary,qbit+1)+"       "+qbinary);
            n--;
            System.out.println("______________________________________________________________");

        }

        System.out.println("Quotient :  "+Integer.parseInt(qbinary, 2));
        System.out.println("Remainder :  "+Integer.parseInt(abinary, 2));
    }
}