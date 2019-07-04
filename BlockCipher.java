public abstract class BlockCipher {
       public int keysize;
       public String in_buffer;
       public String out_buffer;
       public int block_size;
       public char key[];
       public BlockCipher(int ks, int bs){
              keysize = ks;
              block_size = bs;
              in_buffer = null;
              out_buffer = null;
              key = null;
       }

       public abstract void encrypt(String e, String Key);
       public abstract void dcrypt(String f, String Key);
}

