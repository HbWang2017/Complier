package semantic_ana;
public class colorClass {
    private String color;
    private int no;

    public colorClass(int a,String string){
        color = string;
        no = a;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public String getColor() {
        return color;
    }
}
