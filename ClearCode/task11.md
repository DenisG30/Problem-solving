#### 1. Локальные переменные в методе.
```
public class Example {
    public void calculateSum(int a, int b) {
        int sum = a + b; // sum доступна только внутри метода
    }
}
```
___

#### 2. Использование параметров метода, вместо полей класса.
```
public class Calculator {
    public int multiply(int x, int y) {
        return x * y; // x и y доступны только внутри метода 
    }
}
```
___

#### 3. Вложенные классы.
```
public class OuterClass {
    private class InnerClass {
        void display() {
            // код...
        }
    }

    public void createInner() {
        InnerClass inner = new InnerClass(); // InnerClass доступен только внутри OuterClass
        inner.display();
    }
}
```
___

#### 4. Использование private для полей класса.
```
public class User {
    private String name; // name доступно только внутри класса User

    public User(String name) {
        this.name = name;
        // код...
    }

    public String getName() {
        return name; // доступ к имени через метод
    }
}

```
___

#### 5. Использование final для неизменяемых переменных.
```
public class Constants {
    public void printValue() {
        final int value = 42; // value доступно только внутри метода printValue
        // код...
    }
}
```
___

#### 6. Локальная переменная для цикла.
```
public class LoopExample {
    public void printNumbers() {
        for (int i = 0; i < 10; i++) { // i доступна только внутри цикла
            // код...
        }
    }
}

```
___

#### 7. Локальная переменная для метода
```
public class SumCalculator {
    public int calculateSum(int a, int b) {
        int sum = a + b; // sum доступна только внутри метода
        return sum;
    }
}

```
___

#### 8. Приватная переменная класса
```
public class UserProfile {
    private String username; // username доступна только внутри класса UserProfile

    public UserProfile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username; // доступ к username через метод
    }
}
```
___

#### 9. Переменная в пакете.
```
package com.example;

class PackageVariable {
    static String sharedValue = "Доступно в пакете"; // sharedValue доступна всем классам в пакете com.example

    public static void printValue() {
        // код...
    }
}
```
___

#### 10. Глобальная переменная.
```
public class GlobalVariableExample {

    public static String globalValue = "Глобальная переменная"; // доступна из любого места в программе

    public static void printGlobalValue() {
        System.out.println(globalValue);
    }
}

```
___

#### 11. Обращение к переменной локально
```
// public class TemperatureConverter {
    public double convertToFahrenheit(double celsius) {
        double fahrenheit; // Окно уязвимости для переменной fahrenheit минимально
        fahrenheit = (celsius * 9/5) + 32;
        return fahrenheit;
    }
}
```
___

#### 12. Группировка связанных операций
```
public class Account {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            updateBalance(amount); // Обращение к balance происходит в одном месте
        }
    }

    private void updateBalance(double amount) {
        balance += amount; // Обращение к balance происходит в одном месте
    }
}

```
___


#### 13.  Разделение логики методами
```
public class ShoppingCart {
    private double totalPrice;

    public void addItem(double price) {
        if (price > 0) {
            updateTotalPrice(price); // Обращение к totalPrice
        }
    }

    private void updateTotalPrice(double price) {
        totalPrice += price; // Все обращения к totalPrice сгруппированы
    }

    public double getTotalPrice() {
        return totalPrice; // Обращение к totalPrice минимально
    }
}

```
___


#### 14.  Избегание длинного метода
```
public class UserManager {
    private int userCount;

    public void addUser() {
        incrementUserCount(); // Обращение к userCount
        logUserAddition();
    }

    private void incrementUserCount() {
        userCount++; // Обращение к userCount сгруппировано
    }

    private void logUserAddition() {
        // код...
    }
}
```
___

#### 15.  
```
public class GameScore {
    private int score;

    public void addPoints(int points) {
        if (points > 0) {
            updateScore(points); // Обращение к score
        }
    }

    private void updateScore(int points) {
        score += points; // Обращение к score сгруппировано
        displayScore(); // Вызов метода отображения после изменения
    }

    private void displayScore() {
        // код...
        // Минимальное окно уязвимости для score
    }
}

```
___