//package parse;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintStream;
//
//public class parser{
//    static int i, j, r;
//    static int ROUNDS = 5; /* number of rounds */
//    static int next = 0;         /* next unused state variable index */
//    static int dummy = 0;        /* next unused dummy variable index */
//    static int[][] a = new int[4][4];
////    midori bn;
////
////    public parser(midori b){
////         bn = b;
////    }
//    //    void ShuffleCell(int a[][]) {
////        int[][] tmp=new int[4][4];
////
////        tmp[0][0] = a[0][0];
////        tmp[1][0] = a[2][2];
////        tmp[2][0] = a[1][1];
////        tmp[3][0] = a[3][3];
////        tmp[0][1] = a[2][3];
////        tmp[1][1] = a[0][1];
////        tmp[2][1] = a[3][2];
////        tmp[3][1] = a[1][0];
////        tmp[0][2] = a[1][2];
////        tmp[1][2] = a[3][0];
////        tmp[2][2] = a[0][3];
////        tmp[3][2] = a[2][1];
////        tmp[0][3] = a[3][1];
////        tmp[1][3] = a[1][3];
////        tmp[2][3] = a[2][0];
////        tmp[3][3] = a[0][2];
////
////        for (int j = 0; j < 4; j++) {
////            for (int i = 0; i < 4; i++) {
////                a[i][j] = tmp[i][j];
////            }
////        }
////    }
//
//    public void mixeqs(int a[][]) {
//
//        for (j = 0; j < 4; j++) {
//            for (i = 0; i < 4; i++) System.out.print("x" + a[i][j] + " + ");
//            for (i = 0; i < 3; i++) System.out.print("x" + (next + i) + " + ");
//            System.out.println("x" + (next + 3) + " - 4 d" + dummy + " >= 0");
//
////            for (i = 0; i < 4; i++) System.out.println("d%i - x%i >= 0", dummy, a[i][j]);
//            for (i = 0; i < 4; i++) System.out.println("d" + dummy + " - x" + a[i][j] + " >= 0");
//
////            for (i = 0; i < 4; i++) System.out.println("d%i - x%i >= 0", dummy, a[i][j] = next++);
//            for (i = 0; i < 4; i++) System.out.println("d" + dummy + " - x" + (a[i][j] = next++) + " >= 0");
//            dummy++;
//        }
//    }
//
//    public void generate_lp() throws FileNotFoundException{
//
//        PrintStream o = new PrintStream(new File("mno.lp"));
//        PrintStream console = System.out;
//        System.setOut(o);
//
//        for (i = 0; i < 4; i++)
//            for (j = 0; j < 4; j++) a[i][j] = next++;
//
//        System.out.println("Minimize");
//        for (i = 0; i < ROUNDS * 16 - 1; i++) System.out.print("x"+i+" + ");
//        System.out.println("x"+(ROUNDS * 16 - 1));
//        System.out.println();
////        parser ob = new parser();
//
//        System.out.println("Subject To"); /* round function constraints */
//        for (r = 0; r < ROUNDS; r++) {
//            ShuffleCell(a);
//            mixeqs(a);
//            /* at least one S-box must be active */
//            for (i = r * 16; i < r * 16 + 15; i++) System.out.print("x"+i+" +");
//            System.out.println("x"+(r * 16 + 15)+" >= 1");
//            System.out.println();
//        }
//        System.out.println("Binary"); /* binary constraints */
//        for (i = 0; i < 16; i++) System.out.println("x"+i);
//        for (i = 0; i < dummy; i++) System.out.println("d"+i);
//        System.out.println("End");
//    }
//}
//
