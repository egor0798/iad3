
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

//тут всё нормально

@ManagedBean
@ApplicationScoped
public class TableBean {
    private ArrayList<Result> list = new ArrayList<>();

    public void listAdd(Result r){
        list.add(r);
    }

    public ArrayList<Result> getList() {
        return list;
    }

    public void setList(ArrayList<Result> list) {
        this.list = list;
    }
}
