import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProFun13Q1_ReadCSV650776 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(Paths.get("C:/Users/jaikwang/Desktop/Profun/employee.csv"))) {
            Employee[] empList = new Employee[20];
            int num = 0;
            int i = 0;
            while (sc.hasNextLine()) {
                try {
                    num++;
                    String line = sc.nextLine();
                    String[] lineSplit = line.split(",");
                    int id = Integer.parseInt(lineSplit[0]);
                    String firstName = lineSplit[1];
                    String lastName = lineSplit[2];
                    double salary = Double.parseDouble(lineSplit[3]);
                    Employee emp = new Employee(id, firstName, lastName, salary);
                    empList[i] = emp;
                    i++;
                } catch (NumberFormatException e) {
                    System.out.println("Data format error at line: "+ num + "; " + e.getClass().getName() + ": " +e.getMessage());
                }
            }
            printAllEmployee(empList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static void printAllEmployee(Employee[] empList) {
        System.out.println("Emp Id First Name Last Name Salary");
        for (Employee emp : empList) {
            if (emp != null) {
                System.out.println(emp.getEmployeeInfo());
            }
        }
    }
}