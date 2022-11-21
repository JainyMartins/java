public class MeuObj {

    public MeuObj(Integer num) {
        this.num = num;
    }

    Integer num;
    public void setNum(Integer num){
        this.num = num;
    }

    @Override
    public String toString() {
        return this.num.toString();
    }
}
