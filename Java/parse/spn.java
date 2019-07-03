package parse;

public abstract class spn extends BlockCipher {
    public int rn;
    public int nr;
    public String sbox[];
    public int permutype;
    public spn(){

    }


    public abstract String round(int n);

    public abstract String performPermutation(String string);
    public abstract String ShuffleCell(int a[][]);

    public abstract String subBox(String hexadecimalString);




}

