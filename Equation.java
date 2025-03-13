import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. bac nhat 1 an");
        System.out.println("2. bac nhat 2 an");
        System.out.println("3. bac hai 1 an");
        System.out.println("lua chon cua ban la: ");
        int choice = scanner.nextInt();
        if(choice == 1){
            bac11an(scanner);
        }
        else if(choice == 2){
            bac12an(scanner);
        }
        else if(choice == 3){
            bac21an(scanner);
        }
        else{
            System.out.println("ko hop le");
        }
        scanner.close();
    }
    private static void bac11an(Scanner scanner) {
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("vo so nghiem");
            } else {
                System.out.println("vo nghiem.");
            }
        } else {
            double x = -b / a;
            System.out.println("x = " + x);
        }
    }

    private static void bac12an(Scanner scanner) {
        System.out.print("a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("a12: ");
        double a22 = scanner.nextDouble();
        System.out.print("b1: ");
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("vo so nghiem");
            } else {
                System.out.println("vo nghiem");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
    }

    private static void bac21an(Scanner scanner) {
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        if (a == 0) {
            System.out.println("error");
            return;
        }
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
        } else {
            System.out.println("vo nghiem");
        }
    }
}
