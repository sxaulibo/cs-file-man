import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo_001 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int a = 0; a < 3; a++) {
            list.add(a + 1);
        }

        printList(list);
        printList(filter(list));
        printList(java8Filter(list));
        printList(java8Filter1(list));
        java8PrintList(list);
        test();
    }

    //foreach
    private static void printList(List<Integer> list) {
        for (Integer a : list) {
            System.out.print(a + "  ");
        }
        System.out.println();
    }

    private static void java8PrintList(List<Integer> list) {
        new ListUtil<Integer>().print(list);
        System.out.println();
    }

    ;

    private static List<Integer> filter(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer a : list) {
            if (a > 1) newList.add(a);
        }
        return newList;
    }

    private static List<Integer> java8Filter(List<Integer> list) {
        //f(x)=
        Function<Integer, Boolean> function = (g) -> {
            return g > 1;
        };

        Supplier<String> function2 = () -> {
            return "s";
        };
        Consumer<String> function3 = (s) -> System.out.print(s);

        Predicate<Integer> function4 = (x) -> x > 1;

        return list.stream().filter(function4).collect(Collectors.toList());
    }

    private static List<Integer> java8Filter1(List<Integer> list) {
        return list.stream().map(x -> x + 1).collect(Collectors.toList());
    }

//    function家族/@FunctionalInterface    x     y
//    Consumer<T>                       有 T    无
//    Function<T,R>                     有 T    有 R
//    Predicate<T>                      有 T    有 boolean
//    Supplier<T>                         无    有<T>

    public static void test() {
        List<List<Integer>> maxtri = new ArrayList<>();
        maxtri.add(Lists.newArrayList(1, 2, 3));
        maxtri.add(Lists.newArrayList(4, 5, 6));
        maxtri.add(Lists.newArrayList(7, 8, 9));
        new ListUtil<List<Integer>>().print(maxtri);
        System.out.print('\n');

        Function<List<Integer>, Stream<Integer>> function = (x) -> {
            return x.stream();
        };
        List<Integer> list = maxtri.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        new ListUtil<Integer>().print(list);
    }

    @Test
    public void testCamera() {
        List<Camera> cameraList = Lists.newArrayList(new Camera(1, "C_001"),
                new Camera(2, "C_002"),
                new Camera(3, "C_003"));
        new ListUtil<Camera>().print(cameraList);
        cameraList.stream().filter(x -> x.getCameraId() > 1).forEach(x -> System.out.print(x.getCameraName() + "  "));
        new ListUtil<String>().print(cameraList.stream().filter(x -> x != null).filter(x -> x.getCameraId() > 1).map(x -> x.getCameraName()).collect(Collectors.toList()));
        System.out.println("============");
        Function<List<Camera>, List<String>> function = list ->
                list.stream().filter(x -> x.getCameraId() > 1).map(x -> x.getCameraName()).collect(Collectors.toList());

        Optional<List<String>> cameraListOptional = Optional.ofNullable(cameraList).filter(x -> x.size() > 100).map(function);
        //对箱子里的东西  消费
        cameraListOptional.ifPresent(x -> new ListUtil<String>().print(x));

        //对箱子里的东西  收集（非null,就供应出原有的东西，否则 使用后面定义供应 ）
        cameraListOptional.get();
        cameraListOptional.orElse(new ArrayList<>());
        cameraListOptional.orElseGet(() -> {
            System.out.println("error!");
            return new ArrayList<>();
        });


        //对箱子里的东西  加工
        cameraListOptional.map(x->x.add("C_004")).get();

    }


}
