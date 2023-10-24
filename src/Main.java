import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Task 2
        int[] intArray;
        int sumIndex = 0;
        int countNegative = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть розмір масиву:");
        int arrLenght = scanner.nextInt();
        intArray = new int[arrLenght];
        System.out.println("Як ви хочете заповнити масив?\n1 - Ввести з клавіатури\n2 - Рандомні числа від -10 до 10");
        int statInp = scanner.nextInt();
        for (int i = 0; i < intArray.length; i++){
            if (statInp == 1){
                System.out.println("Введіть " + ( i + 1 ) + " число:");
                intArray[i] = scanner.nextInt();
            } else if (statInp == 2) {
                //d1 = (Math.random() * (1000 - 100)) + 100;
                intArray[i] = (int) (Math.random() * (10 + 10)) - 10;
                //System.out.println("intArray[" + i + "]=" + intArray[i]);
            }
            else {
                System.out.println("Помилка ви ввели неправильне число!!!");
                break;
            }
            if (intArray[i] >= 0){
                sumIndex += i;
            }
            if (intArray[i] < 0 && intArray[i] % 2 != 0){
                countNegative++;
            }
        }
        System.out.println("Сума індексів додатних елементів: " + sumIndex);
        System.out.println("Кількість непарних від'ємних елементів масиву: " + countNegative);

        //Task 3
        System.out.print("Введіть кількість точок: ");
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Введіть координати x для точки " + (i + 1) + ": ");
            points[i][0] = scanner.nextInt();

            System.out.print("Введіть координати y для точки " + (i + 1) + ": ");
            points[i][1] = scanner.nextInt();
        }
        int maxDistance = 0;
        int point1Index = 0, point2Index = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = calculateDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    point1Index = i;
                    point2Index = j;
                }
            }
        }
        System.out.println("Максимальна відстань між точками: " + maxDistance);
        System.out.println("Пара точок: (" + points[point1Index][0] + ", " + points[point1Index][1] + ") і ("
                + points[point2Index][0] + ", " + points[point2Index][1] + ")");
    }
    private static int calculateDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}