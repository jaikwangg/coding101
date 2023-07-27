import java.util.ArrayList;
import java.util.stream.Collectors;


public class ProFun14StreamDemoQ3 {
    ArrayList <ProFun14Employee> eList;
		
		ProFun14StreamDemoQ3(){
            
			eList = new ArrayList<>();
            
		}
		void oldKay(){
            
		}
		void streamKay(String deptName){
			int x = eList.stream().collect(Collectors.summingInt(ProFun14Employee::getSalary));
			System.out.printf("%,d%n",x);
		}
		public static void main(String[] agrs){
			ProFun14StreamDemoQ3 demo = new ProFun14StreamDemoQ3();
			demo.streamKay(null);
			demo.oldKay();
            
		}
		class ProFun14Employee{
			String name ;
			String dept ;
			int salary ;
			int yearstart ;
			
			ProFun14Employee(String n ,String d , int sal , int yr){
				name = n;
				dept = d;
				salary = sal;
				yearstart =yr;
			 
			}
            public int getSalary(){
                return salary;
            }
			
			public String toString(){
				return String.format("%s %s(%d) %d",dept,name,yearstart,salary);
			} 
		}
}
