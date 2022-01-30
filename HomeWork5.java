package HW5;

public class HomeWork5 {
            public static void main(String[] args) {
            Employee[] empCorp = new Employee[5];
            empCorp[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mail.com", "8123001122",90000,45);
            empCorp[1] = new Employee("Petrov Petr", "Pilot", "petrov@mail.com", "8123002233",55000,32);
            empCorp[2] = new Employee("Sidorov Sidr", "Teacher", "sidorov@mail.com", "8123003399",40000,48);
            empCorp[3] = new Employee("Pupkin Vasiliy", "driver", "pupkin@mail.com", "8123004498",25000,20);
            empCorp[4] = new Employee("Ivanova Mariya", "doctor", "ivanova@mail.com", "812300559966",70000,30);
            for (Employee employee : empCorp)
                if (employee.getAge()>40)
                    System.out.println(employee);

        }
    }
    class Employee {
        private String name;
        private String position;
        private String email;
        private String phone;
        private int salary;
        private int age;

        public Employee(String name, String position, String email, String phone, int salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }
        public int getAge() {
            return age;
        }
        @Override
        public String toString(){
            return(name+ "\n-"
                    +position+ "\n-"
                    +email+ "\n-"
                    +phone+ "\n-"
                    +salary+ "\n-"
                    +age);
        }
    }









