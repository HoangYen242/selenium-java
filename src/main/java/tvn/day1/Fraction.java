package tvn.day1;

public class Fraction {
    int tu;
    int mau;
    public Fraction (int tu, int mau){
        if(mau == 0) {
            throw new IllegalArgumentException("Mau should be different with 0!");
        }
        this.tu = tu;
        this.mau = mau;
    }

    public int getTu() {
        return tu;
    }

    public int getMau() {
        return mau;
    }

    public Fraction add(Fraction f){
        int tu = this.getTu()*f.getMau() + f.getTu()*this.getMau();
        int mau = this.getMau()*f.getMau();
        return new Fraction(tu, mau);
    }

    public void compare(Fraction f){
        if (this.tu * f.getMau() == this.mau* f.getTu()){
            System.out.println("equal");
        }else if (this.tu * f.getMau() > this.mau* f.getTu()){
            System.out.println("greater than");
        }else {
            System.out.println("less than");
        }
    }

    public void info(){
        System.out.println(this.tu);
        System.out.println(this.mau);
    }
}
