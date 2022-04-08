import java.math.BigInteger;

public class lowRSA {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("3174654383");
        BigInteger e = new BigInteger("65537");
        BigInteger c = new BigInteger("2487688703");

        BigInteger RSAp = null;
        BigInteger RSAq = null;
        BigInteger mul = null;



        for (BigInteger i = new BigInteger("2"); i.compareTo(n) < 0; i=i.add(BigInteger.ONE)) {

            if (n.mod(i).equals(new BigInteger("0"))){
                RSAp=i;
                BigInteger subTract = new BigInteger("1");
                RSAq =  n.divide(RSAp);
                mul = RSAp.subtract(subTract).multiply(RSAq.subtract(subTract));

                break;
            }
        }

        System.out.println(RSAp);
        System.out.println(RSAq);
        System.out.println(mul);

        BigInteger priD = null;
        priD = e.modPow(new BigInteger("-1"),mul);

        System.out.println(priD);

        BigInteger Plain =  new BigInteger(String.valueOf(c.modPow(priD,n)));

        System.out.println(Plain);

        // BigInteger 이거 스트링을 숫자처럼 쓰는건가

        int[] hexArray = new int[1000];
        String convert = String.valueOf(Plain);
        int mayInt = Integer.parseInt(convert);
        String hex;

        int i = 0;
        while (mayInt != 0){
            hexArray[i] = mayInt % 16;
            mayInt = mayInt/16;
            i++;
        }
        for (int j = i-1; j >= 0 ; j--) {
            if (hexArray[j] > 9)
                 System.out.print((char)(55+hexArray[j]));
            else
                System.out.print(hexArray[j]);
        }

    }
}
