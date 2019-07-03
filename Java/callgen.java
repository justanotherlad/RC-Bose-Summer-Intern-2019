import java.io.FileNotFoundException;

public class callgen {
    public static void main(String[] args)throws FileNotFoundException {

        generalised ob;
        ob = new generalised(5,4);
        ob.generate_lp();
    }
}
