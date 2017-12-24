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

    Result(double x, double y, double r, boolean res){
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
    }

    public boolean compRes(){
        boolean res;
        if ((y<=-x+r && y>=0 && y<=r && x>=0 && x<=r)||(x*x+y*y<=(r/2)*(r/2) && x<=0 && y>=0)||(x<=0 && x>=-1*r && y<=0 && y>=-1*r)) res=true;
        else res=false;
        return res;
    }
}
