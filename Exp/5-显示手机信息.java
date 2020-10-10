class Test {
    public static void main(String[] args) {
        Phone phone = new MobilePhone("HUAWEI", "13899999999", "130111111111111111");
        phone.display();
    }
}

class MobilePhone extends Phone {
    private String brand;
    private String ID;
    public MobilePhone(String b, String c, String I) {
        super(c);
        this.brand = b;
        this.ID = I;
    }
    public void display() {
        super.display();
        System.out.println("Brand="+this.brand+"\nOwnerId="+this.ID);
    }
}