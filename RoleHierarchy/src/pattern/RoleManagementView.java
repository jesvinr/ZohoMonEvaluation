package pattern;

import java.util.*;

public class RoleManagementView {
    void start(){
        Scanner sc = new Scanner(System.in);
        RoleManagementViewModel viewModel = new RoleManagementViewModel();
        // Question 1 => adding root user
        System.out.println("Enter root role name: ");
        String root = sc.nextLine();
        viewModel.addRoles(root,null);
        while (true) {
            int choice;
            System.out.println("Operations:\n   1. Add sub role.\n" +
                    "   2. Display roles\n   3. Delete role\n   4. Add user\n"+
                    "   5. Display users\n   6. Display user and sub user\n"+
                    "   7. Delete user\n   8. Number of users from top\n"+
                    "   9. Height of role Hierarchy\n   10. Common boss of users\n");
            try {
                System.out.println("Operation to be performed: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                break;
            }
            switch (choice) {
                // Question 2 => add sub role
                case 1: {
                    System.out.println("Enter sub role name: ");
                    String subRole = sc.nextLine();
                    System.out.println("Enter reporting to role name: ");
                    String reportingOfficer = sc.nextLine();
                    viewModel.addRoles(subRole,reportingOfficer);
                    break;
                }
                // Question 3 => display role
                case 2: {
                    viewModel.displayRoles();
                    break;
                }
                // Question 4 => delete role
                case 3: {
                    System.out.println("Enter the role to be deleted: ");
                    String deleteRole = sc.nextLine();
                    System.out.println("Enter the role to be transformed: ");
                    String transformedRole = sc.nextLine();
                    viewModel.deleteRoles(deleteRole,transformedRole);
                    break;
                }
                // Question 5 = Add user and display user
                case 4:{
                    System.out.println("Enter User Name: ");
                    String userName = sc.nextLine();
                    System.out.println("Enter role: ");
                    String role = sc.nextLine();
                    viewModel.addUserNames(userName,role);
                    break;
                }
                case 5:{
                    viewModel.display();
                    break;
                }
                // Question 6 => display users and sub users
                case 6: {
                    viewModel.displayUserAndSubUsers();
                    break;
                }
                case 7: {
                    System.out.println("Enter username to be deleted: ");
                    String userName = sc.nextLine();
                    viewModel.deleteUserName(userName);
                    viewModel.display();
                    break;
                }
                case 8:{
                    System.out.println("Not completed 8th");
                    break;
                }
                case 9:{
                    System.out.println("Not completed 9th");
                    break;
                }
                case 10:{
                    System.out.println("Not completed 10th");
                    break;
                }
                default: {
                    System.out.println("Please enter valid input...");
                }
            }
        }
    }







}
