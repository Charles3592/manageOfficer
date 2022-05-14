/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageofficer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author Van Cao Phu Loc
 */
public class ManagerOfficer {

    private ArrayList<Officer> list;

    public ManagerOfficer() {
        list = new ArrayList<>();
    }

    public void addOfficer() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("------ [Add Officer] ------");
        System.out.println("1. Worker");
        System.out.println("2. Engineer");
        System.out.println("3. Staff");
        boolean isValid = false;
        System.out.print("Enter your choice: ");
        do {
            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.print("Your choice must from 1 to 3! Please enter again: ");
                } else {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.print("Your choice must from 1 to 3! Please enter again: ");
            }
            sc.nextLine();
        } while (isValid == false);

        String name, gender, address;
        int age = 0;

        isValid = false;
        do {
            System.out.print("Enter Officer's name: ");
            name = sc.nextLine().trim();
            if (!name.equals("")) {
                isValid = true;
            } else {
                System.out.println("Officer's name can't be empty!");
            }
        } while (isValid == false);

        isValid = false;
        do {
            try {
                System.out.print("Enter Officer's age: ");
                age = sc.nextInt();
                if (age < 18 || age > 100) {
                    System.out.println("Officer's age must from 1 to 100!");
                } else {
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("Officer's age must from 1 to 100!");
            }
            sc.nextLine();
        } while (isValid == false);

        isValid = false;
        do {
            System.out.print("Enter Officer's gender: ");
            gender = sc.nextLine().trim();
            if (!gender.equals("")) {
                isValid = true;
            } else {
                System.out.println("Officer's gender can't be empty!");
            }
        } while (isValid == false);

        isValid = false;
        do {
            System.out.print("Enter Officer's address: ");
            address = sc.nextLine().trim();
            if (!address.equals("")) {
                isValid = true;
            } else {
                System.out.println("Officer's address can't be empty!");
            }
        } while (isValid == false);

        switch (choice) {
            case 1:
                int level = 0;
                isValid = false;
                do {
                    try {
                        System.out.print("Enter Worker's level: ");
                        level = sc.nextInt();
                        if (level < 1 || level > 10) {
                            System.out.println("Worker's level must from 1 to 10!");
                        } else {
                            isValid = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Worker's level must from 1 to 10!");
                    }
                    sc.nextLine();
                } while (isValid == false);
                this.list.add(new Worker(name, age, gender, address, level));
                break;
            case 2:
                String major;
                isValid = false;
                do {
                    System.out.print("Enter the major: ");
                    major = sc.nextLine().trim();
                    if (!major.equals("")) {
                        isValid = true;
                    } else {
                        System.out.println("The major can't be empty!");
                    }
                } while (isValid == false);
                this.list.add(new Engineer(name, age, gender, address, major));
                break;
            case 3:
                String job;
                isValid = false;
                do {
                    System.out.print("Enter the job: ");
                    job = sc.nextLine().trim();
                    if (!job.equals("")) {
                        isValid = true;
                    } else {
                        System.out.println("The job can't be empty!");
                    }
                } while (isValid == false);
                this.list.add(new Staff(name, age, gender, address, job));
        }
    }

    public void findByName() {
        Scanner sc = new Scanner(System.in);
        String userEnter;
        System.out.println("- - - [SEARCH BY NAME] - - -");
        System.out.println("Please enter you want to search: ");
        userEnter = sc.nextLine();
        ArrayList<Officer> newList = new ArrayList<>();
        for (Officer officer : this.list) {
            if (officer.getName().equalsIgnoreCase(userEnter)) {
                newList.add(officer);
            }
        }
        if (newList.size() > 0) {
            show(newList);
        } else {
            System.out.println("There is no result for this name!");
            for (Officer Officer : this.list) {
                if (Officer.getName().toLowerCase().contains(userEnter.toLowerCase())) {
                    newList.add(Officer);
                }
            }
            if (newList.size() > 0) {
                System.out.println("Maybe you search for:");
                show(newList);
            }
        }
    }

    private void show(ArrayList<Officer> newList) {
        System.out.println("+-----------------------------+--------+-----------+---------------+");
        System.out.println("| Name                        |   Age  |  Gender   |    Address    |");
        System.out.println("+-----------------------------+--------+-----------+---------------+");
        int i = 0;
        for (Officer officer : newList) {
            i++;
            System.out.printf("|%-29s|  %3d   |  %6s   |      %s       |\n", officer.getName(), officer.getAge(), officer.getGender(), officer.getAddress());
        }
        System.out.println("+-----------------------------+--------+-----------+---------------+");
    }

    public static void main(String[] args) {
        ManagerOfficer QLCB = new ManagerOfficer();
        Scanner sc = new Scanner(System.in);
        boolean isLoop = true;
        boolean isValid = false;
        int choice = 0;
        do {
            System.out.println("- - - Menu - - - ");
            System.out.println("1. Add new Officier");
            System.out.println("2. Find by Name");
            System.out.println("3. Show Information Officiers");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            do {
                try {
                    choice = sc.nextInt();
                    if (choice < 1 && choice > 3) {
                        System.out.println("Your choice must from 1 to 4! Enter Again: ");
                    } else {
                        isValid = true;
                    }
                } catch (Exception e) {
                    System.out.println("Your choice must from 1 to 4! Enter Again: ");
                }
                sc.nextLine();
            } while (isValid == false);
            switch (choice) {
                case 1:
                    QLCB.addOfficer();
                    break;
                case 2:
                    QLCB.findByName();
                    break;
                case 3:
                    QLCB.showListInforOfficer();
                    break;
                case 4:
                    isLoop = false;
            }
        } while (isLoop);
    }

    public void showListInforOfficer() {
        show(list);
    }
}
