package src;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.sql.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class GymManagementSystem implements MembershipActions {
    private GymMember[] members = new GymMember[1000];
    private int memberCount = 0;
    private int individualTrainingCount = 0;
    private Connector connector;

    public GymManagementSystem() {
        this.connector = new Connector();
        initializeDatabase();
    }

    private void initializeDatabase() {
        connector.initializeDatabase();
    }



    public void run() {
        Scanner obj = new Scanner(System.in);
        int choice=0;

        System.out.println("Gym Management System");
        System.out.println("1. Enroll Member");
        System.out.println("2. View Members");
        System.out.println("3. View Individual Training Members");
        System.out.println("4. Search Member");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        try {
            choice = obj.nextInt();
            if(choice>5||choice<1){
                choice=Integer.parseInt(obj.nextLine());
            }

        }
        catch (Exception e){
            System.out.println("Invalid Input");
            run();
        }
        switch (choice) {
            case 1:
                createMember(obj);

                confirm();
                break;
            case 2:
                viewMembers();
                confirm();
                break;
            case 3:
                viewIndividualTrainingMembers();
                confirm();
                break;
            case 4:
                searchMember(obj);
                confirm();
                break;
            case 5:
                System.out.println("Exiting the system.");
                connector.closeConnection();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;

        }
    }
    private void confirm(){
        Scanner scan =new Scanner(System.in);
        System.out.print("Do you want to perform another operation? (1: Yes, 0: No): ");
        int continueChoice=0;
        try {
            continueChoice = Integer.parseInt(scan.nextLine());
        }
        catch(Exception e){
            System.out.println("Invalid Input");
            confirm();
        }
        if (continueChoice == 0) {
            exit(0);
        } else if (continueChoice==1) {
            run();

        }
        else {
            System.out.println("Invalid Input");
            confirm();
        }
    }
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }
    private void createMember(Scanner scanner) {
        String name,membershipPlan,paymentOption,trainingType,trainingSlot;
        char gender='M';
        double weight=0.0, height=0.0;
        int id=101,age=0;
        try {
            do {
                System.out.print("Enter member name: ");
                name = scanner.nextLine();

                if (!isValidName(name)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            } while (!isValidName(name));
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            do {
                System.out.print("Enter member name: ");
                name = scanner.nextLine();

                if (!isValidName(name)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            } while (!isValidName(name));
        }
        System.out.print("Enter member ID: ");
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Input");
            id = Integer.parseInt(scanner.nextLine());

        }

        System.out.print("Enter member weight (in kg): ");
        try {
            weight = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Input");
            weight = Double.parseDouble(scanner.nextLine());
        }
        System.out.print("Enter member height (in cm): ");
        try {
            height = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Input");
            height = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Enter membership plan: ");
        try {
            do {
                membershipPlan = scanner.nextLine();
                if (!isValidName(membershipPlan)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(membershipPlan));
        } catch (Exception e) {
            System.out.println("Invalid Input");
            do {
                membershipPlan = scanner.nextLine();
                if (!isValidName(membershipPlan)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(membershipPlan));
        }
        System.out.print("Enter payment option: ");
        try {
            do {
                paymentOption = scanner.nextLine();
                if (!isValidName(paymentOption)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(paymentOption));
        } catch (Exception e) {
            System.out.println("Invalid Input");
            do {
                paymentOption = scanner.nextLine();
                if (!isValidName(paymentOption)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(paymentOption));
        }
        System.out.print("Enter gender: ");
        try{
            gender = scanner.nextLine().charAt(0);
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            gender = scanner.nextLine().charAt(1);
        }
        System.out.print("Enter age: ");
        try {
            do {
                age = Integer.parseInt(scanner.nextLine());
                if(age>60||age<0){
                    System.out.println("Age can't be greater than 60 or less than 0");
                }
            }while (age>60||age<0);
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            age=Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Enter training type (Strength/Endurance): ");
        try {
            do{
                trainingType = scanner.nextLine();
                if (!isValidName(trainingType)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(trainingType));
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            do{
                trainingType = scanner.nextLine();
                if (!isValidName(trainingType)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(trainingType));
        }
        System.out.print("Enter training slot (Morning/Evening): ");
        try {
            do{
                trainingSlot = scanner.nextLine();
                if (!isValidName(trainingSlot)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(trainingSlot));
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            do{
                trainingSlot = scanner.nextLine();
                if (!isValidName(trainingSlot)) {
                    System.out.println("Invalid Input for name. Please enter alphabetic characters only.");
                }
            }while (!isValidName(trainingSlot));
        }
        RegularMember member = new RegularMember(name, id, weight, height, membershipPlan, paymentOption, gender, age, trainingType, trainingSlot);
        enrollMember(member);
    }


    @Override
    public void enrollMember(GymMember member) {
        if (memberCount < members.length) {
            members[memberCount] = member;
            memberCount++;

            if ("Individual".equalsIgnoreCase(member.getMembershipPlan())) {
                individualTrainingCount++;
            }
            connector.insertMemberIntoDatabase(member);

            System.out.println("Member enrolled successfully.");
        } else {
            System.out.println("Maximum member limit reached.");
        }
    }
    //    public void viewMembers() {
//        System.out.println("List of Members:");
//        for (int i = 0; i < memberCount; i++) {
//            members[i].displayInfo();
//        }
//    }
    @Override
    public void viewMembers() {

        System.out.println("List of Members:");

        // Assuming you have a 'members' table with columns: name, id, weight, height, and other attributes
        String query = "SELECT * FROM members";

        try (ResultSet resultSet = dbConnection.st.executeQuery(query))
        {
            // Print table header
            System.out.printf("%-20s%-10s%-10s%-10s%-20s%-20s%-10s%-6s%-20s%-10s\n", "Name", "ID", "Weight", "Height","Membership Plan","Payment Option"," Gender","Age","Training Type","Training Slot");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

            // Print data rows
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                double weight = resultSet.getDouble("weight");
                double height = resultSet.getDouble("height");
                String membershipPlan = resultSet.getString("membership_Plan");
                String paymentOption = resultSet.getString("payment_Option");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String trainingType = resultSet.getString("training_Type");
                String trainingSlot = resultSet.getString("training_Slot");
                // Add other attributes as needed

                // Print data in table format
                System.out.printf("%-20s%-10d%-10.2f%-10.2f%-20s%-20s%-10s%-6d%-20s%-10s\n", name, id, weight, height,membershipPlan,paymentOption,gender,age,trainingType,trainingSlot);
                // Print other attributes as needed
            }
        }

        catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }
    public void viewIndividualTrainingMembers() {
        System.out.println("Individual Training Members:");
        for (int i = 0; i < memberCount; i++) {
            if ("Individual".equalsIgnoreCase(members[i].getMembershipPlan())) {
                members[i].displayInfo();
            }
        }
        System.out.println("Total Individual Training Members: " + individualTrainingCount);
    }

    public void searchMember(Scanner scanner) {
        System.out.print("Enter member ID to search: ");
        try {
            int memberId = scanner.nextInt();
            connector.searchMember(memberId);
        }
        catch (Exception e){
            run();
        }

    }

}
