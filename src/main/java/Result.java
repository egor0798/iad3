import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Result {
    private double x;
    private double y;
    private double r;
    private boolean res;

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }
    public boolean isRes() {
        return res;
    }
    public void setRes(boolean res) {
        this.res = res;
    }
    public Result(){}
    Result(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = compRes();
    }

    private boolean compRes(){
        //Здесь будут вычисления результата
        // лёха, запили тут вычисления
        return true;
    }
}
