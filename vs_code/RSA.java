import java.math.*;
import java.security.*;

public class RSA {
    BigInteger p, q, n, d, e, ph, t;
    SecureRandom r;

    public RSA() {
        r = new SecureRandom();

        p = BigInteger.probablePrime(512, r);
        q = BigInteger.probablePrime(512, r);
        System.out.println("Prime numbers p and q are " + p.intValue() + ", " + q.intValue());

        n = p.multiply(q);

        ph = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        e = new BigInteger("2");
        while (ph.gcd(e).intValue() > 1 || e.compareTo(ph) >= 0) {
            e = e.add(BigInteger.ONE);
        }

        d = e.modInverse(ph);

        System.out.println("Public key is (" + n.intValue() + "," + e.intValue() + ")");
        System.out.println("Private key is (" + n.intValue() + "," + d.intValue() + ")");

        BigInteger msg = new BigInteger("15");
        System.out.println("\nMessage is: " + msg);

        BigInteger enmsg = encrypt(msg, e, n);
        System.out.println("\nEncrypted Message is: " + enmsg.intValue());

        BigInteger demsg = decrypt(enmsg, d, n);
        System.out.println("\nDecrypted Message is: " + demsg.intValue());
    }

    BigInteger encrypt(BigInteger msg, BigInteger e, BigInteger n) {
        return msg.modPow(e, n);
    }

    BigInteger decrypt(BigInteger msg, BigInteger d, BigInteger n) {
        return msg.modPow(d, n);
    }

    public static void main(String args[]) {
        new RSA();
    }
}
