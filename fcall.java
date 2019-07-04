public class fcall {

    public static void main (String[] args){
        char s_b[] = new char[256];
        int a[][] = {{0,1,1,1},{1,0,1,1},{1,1,0,1},{1,1,1,0}};
        midori kk = new midori(a,s_b);
        parse bb = new parse(kk);
        try{
            bb.generate_lp();
        } catch (Exception e)
        {
            System.err.println("Some kind of error!!");
        }
    }
}
