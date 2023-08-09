import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

import java.nio.file.Paths;
import java.io.IOException;
import packExercise.*;


public class Lab10_650776 {
    private static ArrayList<Employee> empList;
    static {
        empList = new ArrayList<>();
        try(Scanner input = new Scanner(Paths.get("names.csv"))){
            input.nextLine();
            while(input.hasNextLine()){
                String row = input.nextLine().trim();
                empList.add(new Employee(row));
            }
            System.out.println("There are " + empList.size() + " employees.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Q6");
        q6(); System.out.println();
        System.out.println("Q7");
        q7(); System.out.println();
        System.out.println("Q8");
        q8(); System.out.println();
        System.out.println("Q9");
        q9(); System.out.println();
        System.out.println("Q10");
        q10(); System.out.println();
        System.out.println("Q11");
        q11(); System.out.println();
        System.out.println("Q12");
        q12(); System.out.println();
        System.out.println("Q13");
        q13(); System.out.println();
        System.out.println("Q14");
        q14(); System.out.println();
        System.out.println("Q15");
        q15(); System.out.println();
    }
    private static void q6(){
        List<Employee> singers1 = new ArrayList<Employee>(Arrays.asList(new Employee("aba"), new Employee("abi")));
        List<Employee> singers2 = new ArrayList<Employee>();
        singers2.add(new Employee("abo"));
        singers2.add(new Employee("abe"));

        List<Employee> join = q6_1(singers1, singers2);

        System.out.println(singers1);
        System.out.println(singers2);
        System.out.println(join);
        singers1.addAll(singers2);
        System.out.println(singers1);
    }
    private static List<Employee> q6_1(List<Employee> l1, List<Employee> l2){
        ArrayList<Employee> Arr6_1 = new ArrayList<Employee>(List.copyOf(l1));
        l2.forEach(e -> Arr6_1.add(e));
        return Arr6_1;
    }
    private static void q7(){
        List<Employee> singers = Arrays.asList(new Employee("aba"), new Employee("abi"));
        System.out.println(singers);
        singers = q7_1(singers);
        System.out.println(singers);
    }
    private static List<Employee> q7_1(List<Employee> list){
        List<Employee> list7_1 = Arrays.asList(list.get(0));
        return list7_1;
    }
    private static void q8(){
        List<Employee> list1 = Arrays.asList(new Employee("yindee"), new Employee("pramote"));
        List<Employee> list2 = Arrays.asList(new Employee("pramote"), new Employee("preeda"));

        Set<Employee> empSet;
        ArrayList<Employee> list8 = new ArrayList<>(list1);
        list8.addAll(list2);
        empSet = new HashSet<>(list8);

        List<Employee> q8_ans =  new ArrayList<>(empSet);
        System.out.println(q8_ans);
    }

    private static void q9(){
        List<Employee> list1 = new ArrayList<>();
        list1.add(new Employee("yindee"));
        list1.add(new Employee("preeda"));
        list1.add(new Employee("pramote"));
        Set<Employee> empSet1 = new HashSet<>(list1);

        List<Employee> list2 = new ArrayList<>();
        list2.add(new Employee("yindee"));
        list2.add(new Employee("pramote"));
        Set<Employee> empSet2 = new HashSet<>(list2);

        empSet1.retainAll(empSet2);

        System.out.println(empSet1);
    }
    private static void q10(){
        List<Employee> list1 = new ArrayList<>();
        list1.add(new Employee("yindee"));
        list1.add(new Employee("preeda"));
        list1.add(new Employee("pramote"));
        Set<Employee> empSet1 = new HashSet<>(list1);

        List<Employee> list2 = new ArrayList<>();
        list2.add(new Employee("yindee"));
        list2.add(new Employee("pramote"));
        Set<Employee> empSet2 = new HashSet<>(list2);

        empSet1.removeAll(empSet2);
        
        System.out.println(empSet1);
    }
    private static void q11(){
        Set<Employee> empSet = new HashSet<>();
        empSet.add(new Employee("yindee"));
        empSet.add(new Employee("pramote"));
        empSet.add(new Employee("preeda"));
        empSet.add(new Employee("pramote"));
        Employee[] q11_ans = new Employee[empSet.size()];

        empSet.toArray(q11_ans);

        for(Employee e : q11_ans) 
            System.out.print(e+" ");
        System.out.println();
    }
    private static void q12(){
        int n = 3;
        Map<String, Employee> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(empList.get(i).getName(), empList.get(i));
        }
        System.out.println(map);
    }
    private static void q13(){
        int n = 3;
        Map<String, Employee> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(empList.get(i).getName(), empList.get(i));
        }
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
    }
    private static void q14(){
        PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        pq.addAll(empList);
        List<Employee> q14_ans = new ArrayList<>();
        for(int i=0; i<5; i++){
            q14_ans.add(pq.remove());
        }
        System.out.println(q14_ans);
    }
    private static void q15(){
        int sum = 0;
        int cnt = 0;

        int size = empList.size();

        Iterator<Employee> it;
        Long pqStart = System.nanoTime();
        sum = 0;
        PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getSalary(), e1.getSalary()));
        pq.addAll(empList);
        it = pq.iterator();
        while(it.hasNext()){
            sum += it.next().getSalary();
            cnt++;
        }
        System.out.println("PQ ( " + sum + " ) takes "+ String.format("%,d", System.nanoTime() - pqStart));

        System.out.println("Avg of PQ : "+sum/size);
        
        Long listStart = System.nanoTime();
        ArrayList<Employee> clone = new ArrayList<>();
        sum=0;
        clone.addAll(empList);

        Collections.sort(clone, (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));

        it = clone.iterator();
        while(it.hasNext()){
            sum += it.next().getSalary();
            cnt--;
        }
        System.out.println("ArrayList ( " + sum +" ) takes " + String.format("%,d", System.nanoTime() - listStart));

        System.out.println("Avg of ArrayList : "+sum/size);

        if(cnt != 0){
            System.out.println("Error no number of element");
        }
    }
}