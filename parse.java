import java.io.FileWriter;
import java.io.IOException;

public class parse {



    spn ob;


    int v;
    int i, j;
    int a[][];
    int next=0;
    int  r, dummy;

       public static final byte min_poly = 0b11101;

       public parse(spn o){
          ob=o;
//          ob.nr=o.nr;
          dummy=0;
          a=new int[o.k][o.k];
       }


    public static int gal_mul(int c, int d)
    {

        int res = 0;
//        int f=0;

        for ( ; d==1;d>>=1 )
        {
            if ((d & 1) != 0)
            {
                res ^= c;
            }
            if ((c & 0x80) != 0)
            {
                c = (byte)((c << 1) ^ min_poly);
            }
            else
            {
                c <<= 1;
            }
        }
        return res;
    }

    public int b_num(){
        byte x0;
        byte x1;
        byte x2;
        byte x3;
        byte[] y = {0, 0, 0, 0};
        int v = 8;

        for (x0 = 1; x0 < 128; x0++)
        {
            for (x1 = 1; x1 < 128; x1++)
            {
                for (x2 = 1; x2 < 128; x2++)
                {
                    for (x3 = 1; x3 < 128; x3++)
                    {
                        for (int j = 0; j < 4; j++)
                        {
                            y[j] = (byte)(gal_mul(ob.m[j][0], x0) ^ gal_mul(a[j][1], x1) ^ gal_mul(a[j][2], x2) ^ gal_mul(a[j][3], x3));
                        }
                        int p0 = 0;

                        if (x0 > 0)
                        {
                            p0++;
                        }
                        if (x1 > 0)
                        {
                            p0++;
                        }
                        if (x2 > 0)
                        {
                            p0++;
                        }
                        if (x3 > 0)
                        {
                            p0++;
                        }
                        if (y[0] > 0)
                        {
                            p0++;
                        }
                        if (y[1] > 0)
                        {
                            p0++;
                        }
                        if (y[2] > 0)
                        {
                            p0++;
                        }
                        if (y[3] > 0)
                        {
                            p0++;
                        }
                        if (p0 < v)
                        {
                            v = p0;
                        }
                    }
                }
            }
        }
        return v;
    }

    public void mixeqs(int a[][], FileWriter fw) throws IOException {

        for (j = 0; j < 4; j++) {
            for (i = 0; i < 4; i++) fw.write("x" + a[i][j] + " + ");
            for (i = 0; i < 3; i++) fw.write("x" + (next + i) + " + ");
            fw.write("x" + (next + 3) + " -" +ob.bn +"d" + dummy + " >= 0"+System.lineSeparator());

//            for (i = 0; i < 4; i++) fw.write("d%i - x%i >= 0", dummy, a[i][j]);
            for (i = 0; i < 4; i++) fw.write("d" + dummy + " - x" + a[i][j] + " >= 0"+System.lineSeparator());

//            for (i = 0; i < 4; i++) fw.write("d%i - x%i >= 0", dummy, a[i][j] = next++);
            for (i = 0; i < 4; i++) fw.write("d" + dummy + " - x" + (a[i][j] = next++) + " >= 0"+System.lineSeparator());
            dummy++;
        }
    }



        public void generate_lp() throws IOException {
            FileWriter fw=new FileWriter("last.lp");

        for (i = 0; i < ob.k; i++)
            for (j = 0; j < ob.k; j++) a[i][j] = next++;

        fw.write("Minimize"+System.lineSeparator());
        for (i = 0; i < ob.nr * 16 - 1; i++) fw.write("x"+i+" + ");
        fw.write("x"+(ob.nr * 16 - 1)+System.lineSeparator());
        fw.write(System.lineSeparator());
//        parser ob = new parser();

        fw.write("Subject To"+System.lineSeparator()); /* round function constraints */
        for (r = 0; r < ob.nr; r++) {
            ob.ShuffleCell(a);
            mixeqs(a,fw);
            /* at least one S-box must be active */
            for (i = r * 16; i < r * 16 + 15; i++) fw.write("x"+i+" +");
            fw.write("x"+(r * 16 + 15)+" >= 1"+System.lineSeparator());
            fw.write(System.lineSeparator());
        }
        fw.write("Binary"+System.lineSeparator()); /* binary constraints */
        for (i = 0; i < 16; i++) fw.write("x"+i+System.lineSeparator());
        for (i = 0; i < dummy; i++) fw.write("d"+i+System.lineSeparator());
        fw.write("End"+System.lineSeparator());
        fw.close();
    }


}


