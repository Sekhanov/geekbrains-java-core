package main;

import java.util.List;
import java.util.Scanner;

import homewokrLesson1.Cource;
import homewokrLesson1.Obstacle;
import homewokrLesson1.Person;
import homewokrLesson1.Person.Gender;
import homewokrLesson1.Pit;
import homewokrLesson1.Team;
import homewokrLesson1.Wall;
import homeworkLesson2.MyArray;
import homeworkLesson2.MyArrayDataException;
import homeworkLesson2.MyArraySizeException;
import homeworkLesson3.ArrayParser;
import homeworkLesson3.PhoneDirectory;
import homeworkLesson4.ChatWindow;
import homeworkLesson5.ConcurrencyTest;

public class MainClass {

	public static void main(String[] args) {
//		doHomeworkLesson1();
//		doHomeworkLesson2();
//		doHomeworkLesson3();
//		doHomeworkLesson4();
//		doHomeworkLesson5();

	}
	
	
	
	
	private static void doHomeworkLesson5() {
		int arrSise = 10000000;
		ConcurrencyTest concurrencyTest = new ConcurrencyTest();
		
		float[] arr1 = new float[arrSise];
		concurrencyTest.fillFloatArr(arr1);		
		long oneThreadProcessTime = concurrencyTest.processTime(concurrencyTest::oneThreadProcessArray, arr1);
		System.out.println("one thead time: " + oneThreadProcessTime + "ms");
		System.out.println(arr1[9999999]);
		
		float[] arr2 = new float[arrSise];
		concurrencyTest.fillFloatArr(arr2);		
		long twoThreadProcessTime = concurrencyTest.processTime(concurrencyTest::twoThreadProcessArray, arr2);
		System.out.println("two thead time: " + twoThreadProcessTime + "ms");
		System.out.println(arr1[9999999]);
	}

	
	private static void doHomeworkLesson4() {
		new ChatWindow();
	}
	

	private static void doHomeworkLesson3() {
		String[] strings = new String[20];
		strings[0] = "apple";
		strings[1] = "orange";
		strings[2] = "mango";
		strings[3] = "watermelon";
		strings[4] = "melon";
		strings[5] = "apple";
		strings[6] = "fruit";
		strings[7] = "pomegranate";
		strings[8] = "pear";
		strings[9] = "plum";
		strings[10] = "grape";
		strings[11] = "wine";
		strings[12] = "banana";
		strings[13] = "orange";
		strings[14] = "mandarin";
		strings[15] = "apple";
		strings[16] = "coconut";
		strings[17] = "pear";
		strings[18] = "wine";
		strings[19] = "orange";
		
		List<String> uniqueStrings = ArrayParser.findUnique(strings);		
		System.out.println("------------------------------------");
		System.out.println("Unique entries:");
		System.out.println();
		for (int i = 0; i < uniqueStrings.size(); i++) {
			System.out.println(uniqueStrings.get(i));
		}
		System.out.println("------------------------------------");
		
		PhoneDirectory phoneDirectory = new PhoneDirectory();
		phoneDirectory.add("Khanov", "8(910)123-34-33");
		phoneDirectory.add("Ivanov", "8(913)233-32-67");
		phoneDirectory.add("Khanov", "8(910)333-34-33");
		System.out.println("Списки телефонов с запросом по фамилиям:");
		System.out.println("Иванов: " + phoneDirectory.getPhoneNumbers("Ivanov"));
		System.out.println("Ханов: " + phoneDirectory.getPhoneNumbers("Khanov"));
		
		
		
		
		
	}
	
	private static void doHomeworkLesson2() {
		int result = 0;
		MyArray myArray = new MyArray();
		String[][] stringArr;
		int arraySizeDemension1;
		int arraySizeDemension2;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите размер первого измерения массива:");
		arraySizeDemension1 = scanner.nextInt();
		System.out.println("Введите размер второго измерения массива:");
		arraySizeDemension2 = scanner.nextInt();
		stringArr = new String[arraySizeDemension1][arraySizeDemension2];

		for (int i = 0; i < stringArr.length; i++) {
			for (int j = 0; j < stringArr.length; j++) {
				System.out.printf("Введите число для ячейки [%d][%d]", i, j);
				System.out.println();
				stringArr[i][j] = scanner.next();
			}
		}

		while (result == 0) {
			try {
				result = myArray.processArray(stringArr);
			} catch (MyArraySizeException e) {
				e.printStackTrace();
				result = -1;				
			} catch (MyArrayDataException e) {				
				System.out.println(e.getMessage());
				System.out.println("Введите в эту ячейку число от 0 до 9");				
				stringArr[e.getFirsDemensionArrayCell()][e.getSecondDemendionArrayCell()] = scanner.next();
			}
		}
		scanner.close();

		System.out.println("Сумма всех элементов масиива составляет: " + result);
	}

	private static void doHomeworkLesson1() {
		Obstacle[] obstacles = { new Wall("Everest", 140), new Pit("Grand canyon", 200) };
		Cource cource = new Cource(obstacles, "Armageddon");
		Person[] members1 = { new Person("Ivan Petrov", 160, 190, Gender.MALE),
				new Person("Dmitriy Komov", 150, 201, Gender.MALE),
				new Person("Mariya Kramina", 141, 220, Gender.FAMALE),
				new Person("Evgenity Vanin", 150, 215, Gender.MALE) };
		Person[] members2 = { new Person("Vasiliy Dudkin", 120, 170, Gender.MALE),
				new Person("Kristina Vyugina", 150, 210, Gender.FAMALE),
				new Person("Anna Sanina", 130, 220, Gender.FAMALE),
				new Person("Aleksey Krugov", 160, 230, Gender.FAMALE) };
		Team team = new Team("BestTeam", members1);
		Team team2 = new Team("Arrow", members2);
		team.passCource(cource);
		team2.passCource(cource);
		team.showResults();
		team2.showResults();
	}



}
