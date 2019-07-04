public abstract class spn extends BlockCipher {
    public int rn;
    public int nr;
    public char sbox[];
    public int sb_sz;

    public int permutype;
    public int bn;//branch_number
    public int[][] m;//mixed_column_matrix
    int k;//size of matrix

    public spn(int bs, int ks, int dim, int b, int a[][], int rnds, char sb[], int sbsz){
        super(ks, bs);
        k = dim;
        m=new int[k][k];
        for(int i=0; i < k; i++)
            for(int j=0;j<k;j++)
                m[i][j] = a[i][j];
        bn=b;
        nr = rnds;
        sb_sz = sbsz;
        sbox = new char[sb_sz];
        for(int i =0; i < sb_sz; i++)
            sbox[i] = sb[i];
    }




    public abstract String round(int n);

    public abstract String performPermutation(String string);
    public abstract int[][] ShuffleCell(int a[][]);

    public abstract String subBox(String hexadecimalString);





}

