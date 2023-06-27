 class Human{
    String gender;
    int age;
    String name;

    Human(String gender,int age,String name){
        this.gender=gender;
        this.age=age;
        this.name=name;
    }
    public void display(){
        
        System.out.println("Human Displayed");
        System.out.println(this);
    }
}

 class Student extends Human{
    int roll_no;
    int grad_year;

    Student(String gender,int age,String name,int roll_no,int grad_year){
        super(gender,age, name);
        this.roll_no=roll_no;
        this.grad_year=grad_year;

    }
    public void display(){

        
        System.out.println("Student Displayed");
        System.out.println(this);
    }

}

public class Hello{
    public static void main(String[] args) {
        Student s1=new Student("Male", 22, "raj", 22, 2023);
        ((Human)s1).display();
        
    }
}