import java.util.*;


// import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class markssoft {
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);

        char op;

        String roll;
        String nm;
        String cls;
        String sec;
        int phy;
        int chem;
        int math;
        int cs;
        int eng;
        // int tot;
        // Float pct;

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/software", "root",
                "@rishi1234shukla4321@");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>. WELCOME .<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("=>=>=>=>=>=>=>=>=>=>. How Can I Help You .=<=<=<=<=<=<=<=<=<=< ");

        System.out.println("1.Data Insert");
        System.out.println("2.data Update");
        System.out.println("3.Delet Data");
        System.out.println("4.Search Student");
        System.out.println("5.Retrieve Data");
        System.out.print(">>>>>>>>>>>>>>>Enter Your Choise :-");
        op = sc.next().charAt(0);

        if (op == '1') 
        {
            System.out.print("Enter Your Roll Number :-");
            roll = sc.next();

            System.out.print("Enter Your Name :-");
            nm = sc.next();
            // sc.nextLine();

            System.out.print("Enter Your Class :-");
            cls = sc.next();
            // sc.nextLine();

            System.out.print("Enter Your Section :-");
            sec = sc.next();
            // sc.nextLine();

            System.out.print("Enter Your Physics Mark :-");
            phy = sc.nextInt();

            System.out.print("Enter Your Chemistry Marks :-");
            chem = sc.nextInt();

            System.out.print("Enter Your Maths Marks :-");
            math = sc.nextInt();

            System.out.print("Enter Your Computer Marks :-");
            cs = sc.nextInt();

            System.out.print("Enter Your English Marks :-");
            eng = sc.nextInt();

            int plus = phy + chem + math + cs + eng;

            float per = (plus / 500.0f) * 100;
            String gd;

            if (per >= 90) {
                gd = "A+";
            }

            else if (per >= 80) {
                gd = "A";
            }

            else if (per >= 70) {
                gd = "B";
            }

            else if (per >= 60) {
                gd = "C";
            }

            else if (per >= 50) {
                gd = "D";
            }

            else if (per >= 40) {
                gd = "E";
            }

            else {
                gd = "Fail";
            }

            System.out.println("Total Marks :-" + plus);

            System.out.println("Percentage :- " + per + "%");

            System.out.println("Grade :- " + gd);

            PreparedStatement ps = con.prepareStatement("insert user_info2 values(?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, roll);
            ps.setString(2, nm);
            ps.setString(3, cls);
            ps.setString(4, sec);
            ps.setInt(5, phy);
            ps.setInt(6, chem);
            ps.setInt(7, math);
            ps.setInt(8, cs);
            ps.setInt(9, eng);
            ps.setInt(10, plus);
            ps.setFloat(11, per);
            ps.setString(12, gd);

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Data Insrted ");
            }
            else
            {
                System.out.println("Fail to Insert ");
            }
        }

        if (op == '2') 
        {
            System.out.println("))))))))))))))).WHAT YOU WANT TO UPDATE.(((((((((((((((");

            System.out.println("1.Roll Number");
            System.out.println("2.Name");
            System.out.println("3.Class");
            System.out.println("4.Section");
            System.out.println("5.Update Physics Marks");
            System.out.println("6.Update Chemistry  Marks");
            System.out.println("7.Update Maths  Marks");
            System.out.println("8.Update Computer Marks");
            System.out.println("9.Update English  Marks");
            System.out.print("Enter Your Choise Here :-");
            op = sc.next().charAt(0);

            if (op == '1') 
            {
                System.out.print("Enter Your Name :-");
                roll = sc.next();
                
                System.out.print("Enter Your New Roll Number :-");
                nm = sc.next();
                
                PreparedStatement ps = con.prepareStatement("update user_info2 set Roll_no= ? where Name= ? ");
        

                ps.setString(2, roll);
                ps.setString(1, nm);

                int i = ps.executeUpdate();

                if (i>0) {
                    System.out.println("Roll Number Change Successfully ");
                }
                else
                {
                    System.out.println("Fail to Change Roll Number");
                }
            }

            if (op == '2') {

                System.out.print("Enter Your Roll Number :- ");
                roll = sc.next();

                System.out.print("Enter Your New Name :- ");
                nm = sc.next();

                PreparedStatement ps = con.prepareStatement("update user_info2 set Name= ? where Roll_no= ? ");
                ps.setString(2, roll);
                ps.setString(1, nm);

                int i = ps.executeUpdate();

                if (i>0) 
                {
                    System.out.println("Name Change Successful");
                }
                else
                {
                    System.out.println("Fail to Change");

                }
                
            }

            if (op == '3') 
            {
                System.out.print("Enter Your Roll Number :-");
                roll = sc.next();

                System.out.print("Enter Your New Class :-");
                cls = sc.next();

                PreparedStatement ps = con.prepareStatement("update user_info2 set Class= ? where Roll_no= ?");
                ps.setString(2, roll);
                ps.setString(1, cls);

                int i = ps.executeUpdate();

                if (i > 0) 
                {
                    System.out.println("Class Changed Successfully ");
                }
                else
                {
                    System.out.println("Fail to Chage Class ");
                }
                
            }

            if (op == '4') 
            {
                System.out.print("Enter Your Roll Number :-");
                roll = sc.next();

                System.out.print("Enter New Section :-");
                sec = sc.next();

                PreparedStatement ps = con.prepareStatement("update user_info2 set Section=? Where Roll_no=?");
                ps.setString(2, roll);
                ps.setString(1, sec);

                int i = ps.executeUpdate();

                if (i > 0) 
                {
                    System.out.println("Your Section Update Successfully");
                }
                else
                {
                    System.out.println("Fail to Update Section ");
                }
                
            }

            if (op == '5') 
            {
                System.out.print("Enter Your Roll Number :- ");
                roll = sc.next();
                
                System.out.print("Enter Your New Physics Marks :-");
                phy = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("update user_info2 set Physics=? Where Roll_no =?");
                ps.setString(2, roll);
                ps.setInt(1, phy);
            
                int i = ps.executeUpdate();

                if (i > 0) 
                {
                    System.out.println("Physics Marks Update Successfully");
                }
                else
                {
                    System.out.println("Fail to Update Marks");
                }

            }

            if (op == '6') 
            {
             System.out.print("Enter Your Roll Number :-");
             roll = sc.next();
             
             System.out.print("Enter New Chemistry :-");
             chem = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("update user_info2 set Chemistry=? where Roll_no=?");
            ps.setString(2, roll);
            ps.setInt(1, chem);

            int i = ps.executeUpdate();
            if (i > 0) 
            {
             System.out.println("Chemistry Marks Chaged Successfully ");   
            }
            else
            {
                System.out.println("Fail to Update Chemisrty Makrs");
            }
            }
                    

            if (op == '7') 
            {
                System.out.print("Enter Your Roll Number :-");
                roll = sc.next();
                
                System.out.print("Enter New Maths Marks :-");
                math = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("update uer_info2 set Maths=? , Where Roll_no=?");
                ps.setString(2, roll);
                ps.setInt(1, math);

                int i = ps.executeUpdate();
                if (i>0) 
                {
                    System.out.println("Your Maths Marks Updated Successfully");
                }
                else
                {
                    System.out.println("Fail to Update Maths Marks");
                }
                
            }

            if (op == '8') 
            {
                System.out.print("Enter Your Roll Number :-");
                roll = sc.next();

                System.out.println("Enter Your New Computer Science Marks :-");
                cs = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("update user_info2 set Computer=? , where Roll_no=? ");
                ps.setString(2, roll);
                ps.setInt(1, cs);

                int i = ps.executeUpdate();
                if (i > 0) 
                {
                    System.out.println("Your Computer Marks Updated Succesfully ");
                }
                else
                {
                    System.out.println("Fail To Update Computer Marks ");
                }
                
            }

            if (op == '9') 
            {
                System.out.print("Enter Your Roll Number :-");
                roll = sc.next();

                System.out.print("Enter Your New English Marks :-");
                eng = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("update user_info2 set English=? , Where Roll_no=?");
                ps.setString(2, roll);
                ps.setInt(1, eng);

                int i = ps.executeUpdate();
                if (i > 0) 
                {
                    System.out.println("Your English Marks Updated successfully");
                }
                else
                {
                    System.out.println("Fail to Update Your English Marks ");
                }
            }
            
        }

        if (op == '3') 
        {
            System.out.println("xxxxxxxxxxxxxx.DELETE DATA.xxxxxxxxxxxxxx");

            System.out.print("Enter Your Roll Number To Delet Data :-");
            roll = sc.next();

            // Connectoin con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "@rishi1234shukla4321@");

            PreparedStatement ps = con.prepareStatement("delete from user_info2 where Roll_no=?");
            ps.setString(1, roll);

            int i = ps.executeUpdate();

            if (i > 0 ) 
            {
                System.out.println("Data Deleted Successfully");
            }
            else
            {
                System.out.println("Fail To Delet Data ");

            }
            
        }

        if (op == '4') 
        {
            System.out.println("====================.SEARCH.====================");

            System.out.print("Enter Your Roll Number To Get Inforamation :-");
            roll = sc.next();

            PreparedStatement ps = con.prepareStatement("select * from user_info2 where Roll_no=?");
            ps.setString(1, roll);

            ResultSet i = ps.executeQuery();

            while (i.next()) 
            {
                String RollNum = i.getString("Roll_no");
                System.out.println("Roll Number :-"+  RollNum);
                
                String naam = i.getString("Name");
                System.out.println("Name :-"+ naam);

                String clas = i.getString("Class");
                System.out.println("Class :-"+ clas);
                
                String Sect = i.getString("Section");
                System.out.println("Section :-"+ Sect);

                int phys = i.getInt("Physics");
                System.out.println("Physics :-"+ phys);

                int chemi = i.getInt("Chemistry");
                System.out.println("Chemisrty :-"+ chemi);

                int mat = i.getInt("Maths");
                System.out.println("Maths :-"+ mat);

                int CompSc = i.getInt("Computer");
                System.out.println("Computer :-"+ CompSc);

                int engl = i.getInt("English");
                System.out.println("English :-"+ engl);

                int tota = i.getInt("Total");
                System.out.println("Total :-"+ tota);

                float pert = i.getFloat("Percentage");
                System.out.println("Percentage :-"+ pert);

                String gd = i.getString("Grade");
                System.out.println("Grade :-"+ gd);

                System.out.println("---------------------------------------------------");

                
            }
        }

        if (op == '5') 
        {
            System.out.println("^.^ , ^.^ , ^.^ , ^.^ , RETRIEVE DATA ^.^ , ^.^ , ^.^ , ^.^");

            PreparedStatement ps = con.prepareStatement("select * from user_info2");
            ResultSet i = ps.executeQuery();

            while (i.next()) 
            {
                String RollNum = i.getString("Roll_no");
                System.out.println("Roll Number :-"+  RollNum);
                
                String naam = i.getString("Name");
                System.out.println("Name :-"+ naam);

                String clas = i.getString("Class");
                System.out.println("Class :-"+ clas);
                
                String Sect = i.getString("Section");
                System.out.println("Section :-"+ Sect);

                int phys = i.getInt("Physics");
                System.out.println("Physics :-"+ phys);

                int chemi = i.getInt("Chemistry");
                System.out.println("Chemisrty :-"+ chemi);

                int mat = i.getInt("Maths");
                System.out.println("Maths :-"+ mat);

                int CompSc = i.getInt("Computer");
                System.out.println("Computer :-"+ CompSc);

                int engl = i.getInt("English");
                System.out.println("English :-"+ engl);

                int tota = i.getInt("Total");
                System.out.println("Total :-"+ tota);

                float pert = i.getFloat("Percentage");
                System.out.println("Percentage :-"+ pert);

                String gd = i.getString("Grade");
                System.out.println("Grade :-"+ gd);

                System.out.println("---------------------------------------------------");
                
            }
        }
        sc.close();
    }
}