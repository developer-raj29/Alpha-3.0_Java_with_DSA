
public class _01OOPS {
    public static void main(String[] args) {
        Pen p1 = new Pen(); // created a pen object called p1

        // setters

        // p1.setcolor("Blue");
        // System.out.println(p1.color);

        // p1.settip(5);
        // System.out.println(p1.tip);

        // p1.color = "yellow";
        // System.out.println(p1.color);

        // p1.tip = 3;
        // System.out.println(p1.tip);

        // getters

        p1.setcolor("Blue");
        System.out.println(p1.getcolor());

        p1.settip(5);
        System.out.println(p1.gettip());

        p1.setcolor("Yellow");
        System.out.println(p1.getcolor());

        // BankAccount myAcc = new BankAccount();
        // myAcc.UserName = "Rajyadav";
        // myAcc.setpassword = ("abcd");
    }
}

class BankAccount {
    public String UserName;
    // private String password;

    // default void setpassword(String Pwd) {
    // password = Pwd;
    // }
}

class Pen {
    private String color;
    private int tip;

    // getters
    String getcolor() {
        return this.color;
    }

    int gettip() {
        return this.tip;
    }

    // setters
    void setcolor(String newcolor) {
        color = newcolor;
    }

    void settip(int newtip) {
        tip = newtip;
    }
}
