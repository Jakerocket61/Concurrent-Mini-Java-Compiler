class test1 {

    public static void main(String[] arguments) {

        int a = 1;
        int b;
        b = a;
        a = a + b;
        Xinu.printInt(a);
        Xinu.printint(b);
    }
}
