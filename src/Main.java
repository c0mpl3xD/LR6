import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("\n№1"); //Неполное заполнение массива
        char[] c = new char[10];
        for (int i=0; i<5; i++) c[i] = (char)(65+i);
        System.out.println(c);

        System.out.println("\n№2"); //Такое же только с числами(плохой вывод)
        int[] array = new int[10];
        for (int i=0; i<5; i++) array[i]=i;
        System.out.println(array);
        
        System.out.println("\n№3"); //Такое же только с числами(хороший вывод)
        int[] array1 = new int[10];
        for (int i=0; i<5; i++) array1[i]=i;
        System.out.print(Arrays.toString(array1));

        System.out.println("\n№4"); //Заполнение от 0 до 100 и добавление в строку
        int[] array2 = new int[10];
        for (int i=0; i<10; i++)
            array2[i]=(int)(Math.random()*100);
        String s="";
        for (int i: array2) {
            s+=Integer.toString(i)+", ";
        }
        System.out.println(s);
        
        System.out.println("\n№5"); //Сумма отрицательных чисел после положительного
        int s1 = 0;

        boolean found = false;
        int[] array3 = { -1, 2, -3, -4, 5 -6};
        for (int i=0; i<array3.length; i++) {
            if (!found && array3[i] > 0) {
                found = true;
                continue;
            } else if (found) {
                if (array3[i] > 0) break;
                s1 += array3[i];
            }
        }
        System.out.println(s1);
        
        System.out.println("\n№6"); //Поиск максимального числа
        int[] array4 = new int[10];
        for (int i=0; i<array4.length; i++)
            array4[i] = (int)(Math.random()*100);
        int x=array4[0];
        for (int i=array4.length-1; i>=0; i--)
            if (x < array4[i]) {
                x=array4[i];
            }
        System.out.println(x);
        
        System.out.println("\n№7");//Разделение строки на элементы
        int i1,j1;
        Scanner scanner1 = new Scanner(System.in);
        String s2 = scanner1.nextLine();
        char[] c1 = new char[0];
        for (i1=0; i1<s2.length(); i1++) {
            for (j1=0; j1<c1.length; j1++) {
                if (s2.charAt(i1) == c1[j1]) break;
            }
            if (j1 == c1.length) {
                char[] c2= new char[c1.length+1];
                for (int k=0; k<c1.length; k++)
                    c2[k] = c1[k];
                c2[c2.length-1] = s2.charAt(i1);
                c1 = c2;
            }
        }
        System.out.println(Arrays.toString(c1));
        
        System.out.println("\n№8");//Заполнение главной диагонали и ее вывод и расчет суммы элементов каждой строки
        int[][] array5 = new int[3][3];
        for (int i=0; i<array5.length; i++)
            array5[i][i] = 1;
        for (int i=0; i<array5.length; i++)
            System.out.println(Arrays.toString(array5[i]));
        
        System.out.println("\n№9");//Заполнение матрицы и ее вывод
        int[][] array6 = new int[3][3];
        for (int i=0; i<array6.length; i++)
            for (int j=0; j<array6[i].length; j++)
                array6[i][j] =
                        (int)(Math.random()*100);
        for (int i=0; i<array6.length; i++)

            System.out.println(Arrays.toString(array6[i]));

        int[] result = new int[array6.length];
        for (int i=0; i<result.length; i++)
            for (int j=0; j<result.length; j++)
                result[i] += array6[i][j];
        System.out.println(Arrays.toString(result));


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