import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;
import java.util.ArrayList;

class StreamAPI {
    public static void main(String[] args) 
    {

      List<employees> emplist = new ArrayList<employees>();
      //adding employee to our list
      emplist.add(new employees("kundan",24, 50000.00));
      emplist.add(new employees("pankaj",25, 90000.00));
      emplist.add(new employees("akash",23, 70000.00));
      emplist.add(new employees("rohit",20, 40000.00));
      emplist.add(new employees("raj",21, 30000.00));
      emplist.add(new employees("mauli",30, 80000.00));
      

      //printing list
      //Syso ctrl + space
      emplist.forEach(e -> System.out.println(e));


      System.out.println("\n sorted by name =\n");

      //sort the list by name
      List<employees> sortedByName = emplist.stream().sorted((e1,e2)-> e1.name.compareTo(e2.name)).collect(Collectors.toList());

      //print list
      sortedByName.forEach(System.out::println); //method reference
      //of line no 22   
      

      System.out.println("\n sorted by age =\n");


      // 2.sort by age
       
      List<employees> sortByAge = emplist.stream().sorted(Comparator.comparingInt(employees::getAge)).collect(Collectors.toList());
      sortByAge.forEach(e-> System.out.println(e));   //output of sort by age

      System.out.println("\n sorted by salary =\n");

      //3.sorte by salary
      List<employees> sortBySalary = emplist.stream().sorted(Comparator.comparingDouble(employees::getSalary)).collect(Collectors.toList());
      sortBySalary.forEach(e -> System.out.println(e));   //output of sort by salary

      System.out.println("\n Fiirst Filter then Sort =\n");
      //4.apply filter - mostly asked question in interview
      //filter comes un der intermediate operation , it will filter the data and return new string as output 
      
      emplist.stream().filter(e-> e.salary>50000).sorted(Comparator.comparingDouble(employees::getSalary)).forEach(System.out::println); 
      //giving salary greater then 50000 and giving method diffrence

    }
    static class employees{
      private String name;
      private int age;
      private double salary;
      public String getName() {
        return name;
      }
      public void setName(String name) {
        this.name = name;
      }
      public int getAge() {
        return age;
      }
      public void setAge(int age) {
        this.age = age;
      }
      public double getSalary() {
        return salary;
      }
      public void setSalary(double salary) {
        this.salary = salary;
      }
      public employees(String name, int age, double salary) {
        super();cv
        this.name = name;
        this.age = age;
        this.salary = salary;
      }
      @Override
      public String toString() {
        return "employees [name=" + name + ", age=" + age + ", salary=" + salary + "]";
      }

      

    }
}