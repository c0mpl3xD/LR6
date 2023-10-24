import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Task 1
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


    }
}