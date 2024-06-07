package qdev4;

public class MyException extends Exception {
    public MyException() {}
    public MyException(String msg) {super(msg);}

    public void example2() throws MyException
    {
        throw new MyException();
    }  
}