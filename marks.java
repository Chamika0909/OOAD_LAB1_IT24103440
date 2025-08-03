import java.util.Scanner;

public class marks {
    
    static int[][] studentMarks;
    static int num;
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter number of students : ");
         num =sc.nextInt();
        studentMarks= new int[num][3];
        
        while (true) {
            System.out.println("\nCommands:");
            System.out.println("add ");
            System.out.println("update");
            System.out.println("average_sub");
            System.out.println("average_std ");
            System.out.println("total");
            System.out.println("exit");
            
            System.out.print("\nEnter command : ");
            String command=sc.next();
            
            if (command.equals("add")){
                 System.out.print("Enter student number : ");
                 int id=sc.nextInt()-1;
                 if (id >= 0 && id < num) {
                    System.out.print("Enter marks for Mathematics: ");
                    studentMarks[id][0] = sc.nextInt();
                    System.out.print("Enter marks for Chemistry: ");
                    studentMarks[id][1] = sc.nextInt();
                    System.out.print("Enter marks for Physics: ");
                    studentMarks[id][2] = sc.nextInt();
                 }
                else 
                     {System.out.println("Invalid number");
                     break;}
            }
            else if (command.equals("update")){
                System.out.println("Enter student number");
                int id=sc.nextInt()-1;
                System.out.println("Enter subject (Maths:1 , Chem:2 , Physics:3 )");
                int sub=sc.nextInt()-1;
                
                if(id>=0&&id<num && sub>=0 && sub<3){
                    System.out.print("Enter new mark: ");
                    studentMarks[id][sub] = sc.nextInt();
                }
                else {
                    System.out.println("Invalid student number or subject number");
                    break;}
            }
            else if (command.equals("average_sub")){
                System.out.println("Enter subject number");
                int sub=sc.nextInt()-1;
                int sum=0;
                for (int i = 0; i < num; i++) {
                    sum += studentMarks[i][sub];
                }
                System.out.println("Subject average: " + (sum / (double) num));
                
            }
            else if (command.equals("average_std")){
                System.out.println("Enter student number");
                int std=sc.nextInt()-1;
                int sum=0;
                for (int i = 0; i < 3; i++) {
                    sum += studentMarks[std][i];
                }
                System.out.println("Student average: " + (sum / (double)3));
                
            }
             else if (command.equals("total")){
                System.out.println("Enter student number");
                int std=sc.nextInt()-1;
                int sum=0;
                for (int i = 0; i < 3; i++) {
                   sum += studentMarks[std][i];
                }
                System.out.println("Student total: " + sum);
             }
             else if (command.equals("grades")) {
                System.out.println("\nGrades Summary:");
                System.out.printf("%-10s%-12s%-12s%-12s\n", "Student", "Math", "Chemistry", "Physics");

                for (int i = 0; i < num; i++) {
                    System.out.printf("%-10s", "Student " + (i + 1));
                    for (int j = 0; j < 3; j++) {
                        System.out.printf("%-12s", getGrade(studentMarks[i][j]));
                    }
                    System.out.println();
                }
             }

             else if (command.equals("exit"))
             break;
             else {
                System.out.println("Invalid command.");
             
        }
        }
sc.close();

}
public static String getGrade(int mark) {
    if (mark >= 90) return "A";
    else if (mark >= 80) return "B";
    else if (mark >= 70) return "C";
    else if (mark >= 60) return "D";
    else return "Fail";
}

}

   