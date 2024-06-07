package qdev4;

public class Ex1
{
    public void example1() throws Exception
    {
        doIt();
    }
    public int doIt() throws Exception
    {
        throw new Exception();
    }    
    
          
    public void doItAgain() throws MyException {
        throw new MyException();
    }
    public void example3() {
        try {
        doItAgain();
        } catch (Exception e) {
        processing();
        }
    }
    private void processing() {
        // TODO Auto-generated method stub
    }

    public int example4() {
        int data = 0;
        try {
        data = getData();
        } catch (NullPointerException e) {e.printStackTrace();}
        return data;
        }
        public int getData() throws NullPointerException {
        throw new NullPointerException();
        }
        
        public void example5() {
            doItFinally();
            }
            public int doItFinally() {
            throw new RuntimeException();
            }
    
            public static void main(String[] args) {
                try {
                    int k = 1/Integer.parseInt(args[0]);
                    System.out.println(k);
                }
                catch(ArrayIndexOutOfBoundsException e) {System.err.println("Index " + e);}
                catch(ArithmeticException e) {System.err.println("Arithmetic " + "");}
                catch(RuntimeException e) {System.err.println("Runtime " + e);}
                }
    
}
