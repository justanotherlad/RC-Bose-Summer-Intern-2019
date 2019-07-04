public class midori extends spn{

    public midori(int a[][],char s_b[]){
        super(128,128,4, 7, a, 2, s_b,256);
    }
    @Override
    public void encrypt(String e, String Key) {


    }

    @Override
    public void dcrypt(String f, String Key) {

    }

    @Override
    public String round(int n) {
        return null;
    }

    @Override
    public String subBox(String hexadecimalString) {
        return null;
    }


    @Override
    public int[][] ShuffleCell(int a[][]){
        int[][] tmp=new int[4][4];

        tmp[0][0] = a[0][0];
        tmp[1][0] = a[2][2];
        tmp[2][0] = a[1][1];
        tmp[3][0] = a[3][3];
        tmp[0][1] = a[2][3];
        tmp[1][1] = a[0][1];
        tmp[2][1] = a[3][2];
        tmp[3][1] = a[1][0];
        tmp[0][2] = a[1][2];
        tmp[1][2] = a[3][0];
        tmp[2][2] = a[0][3];
        tmp[3][2] = a[2][1];
        tmp[0][3] = a[3][1];
        tmp[1][3] = a[1][3];
        tmp[2][3] = a[2][0];
        tmp[3][3] = a[0][2];

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                a[i][j] = tmp[i][j];
            }
        }
        return a;
    }
    @Override

    public String performPermutation(String string){
        return null;
    }
}
