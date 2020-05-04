import java.util.List;

public class ListUtil<T> {

    public void print(List<T> list) {
        list.forEach(x -> System.out.print("" + x.toString() + "  "));
    }
}
