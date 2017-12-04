import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

@ManagedBean(name = "mainbean")
@ApplicationScoped
public class MainBean implements Serializable {
    //подрубаем фасолину отвечающую за отображение значений в таблице
    @ManagedProperty("#{tableBean}")
    private TableBean res;
    private double x=-3;
    private double y=-3;
    private double r = 1;
    public MainBean(){}
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
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public TableBean getRes() {
        return res;
    }
    public void setRes(TableBean res) {
        this.res = res;
    }
    //Обновление значения кнопки для R, через js не вышло, там какой-то пиздец
    public void actionB(ActionEvent actionEvent){
        if(r==3)
            r=1;
        else
            r=r+0.5;
    }

    //добавление нового значения  в таблицу при нажатии главной кнопки
    public void addButtonAction(ActionEvent actionEvent) {
        res.listAdd(new Result(getX(),getY(),getR()));
    }

}
