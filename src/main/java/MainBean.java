import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mainbean")
@ApplicationScoped
@Stateless
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

    //private final String PERSISTENCE_UNIT_NAME = "results";
    //private static EntityManagerFactory factory;
    //добавление нового значения  в таблицу при нажатии главной кнопки
    @PostConstruct
    public void download(){
        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("results");
        EntityManager em2 = emf2.createEntityManager();
        Query query = em2.createNativeQuery("SELECT x,y,r,res FROM results;");
        List results = query.getResultList();
        ArrayList results1 = new ArrayList();
        for (int i=0; i<results.size(); i++){
            Object[] res = (Object[]) results.get(i);
            Result result2 = new Result();
            double x = (double) res[0];
            double y = (double) res[1];
            double r = (double) res[2];
            boolean b = (boolean) res[3];
            result2.setX(x);
            result2.setY(y);
            result2.setR(r);
            result2.setRes(b);
            results1.add(result2);
        }
        res.setList(results1);
    }

    public void addButtonAction(ActionEvent actionEvent) {
        Result result = new Result(getX(),getY(),getR());
        res.listAdd(result);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("results");
        EntityManager em = emf.createEntityManager();
        ResultsEntity resultsEntity = new ResultsEntity(result);
        em.getTransaction().begin();
        em.persist(resultsEntity);
        em.getTransaction().commit();
        em.close();
    }

}
