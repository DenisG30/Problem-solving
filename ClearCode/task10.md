#### 1. Присвоение допустимых значений.
```
// До
String status = "active";
// ...
status = null; // Неочевидно

// После
String status = "active";
// ... 
status = "inactive"; // Явное завершение работы с переменной
```
___

#### 2. Инициализация переменных.
```
// До
int result;
// ... 
result = bank * percent;

// После
int result = bank * percent; // Инициализация сразу при объявлении
```
___

#### 3. Инициализация переменных в циклах.
```
// До
int sum = 0;
for (int i = 0; i < 10; i++) {
    sum += i;
}
// ... sum

// После 
for (int i = 0; i < 10; i++) {
    int currentValue = i; // Инициализация внутри цикла
    sum += currentValue;
}
```
___

#### 4. Использование final для параметров метода
```
// До
void calculateArea(double length, double width) {
    length = length * width; // Изменение параметра

// После 
void calculateArea(final double length, final double width) {
    double area = length * width; // Параметры не изменяются
}

```
___

#### 5. Избегание глобальных переменных
```
// До
static int counter;

// После
private int counter; // Ограничение видимости переменной

```
___

#### 6. Указание типов в коллекции
```
// До
List list = new ArrayList(); // Неявное указание

// После
List<String> list = new ArrayList<>(); // Явное

```
___

#### 7. Использование final для параметров метода
```
// До
void updateProfile(String name, String email) {
    name = "New Name"; // Изменение параметра

// После
void updateProfile(final String name, final String email) {
}

```
___

#### 8. Явное указание типов в коллекциях
```
// До
Map map = new HashMap(); // Неявный

// После
Map<String, Integer> map = new HashMap<>(); // Явный тип

```
___

#### 9. Проверка инвариантов
```
// До
double balance = getBalance();
// ...
if (balance < 0) {
    System.out.println("Отрицательный баланс!");
}

// После
double balance = getBalance();
assert balance >= 0 : "Баланс не может быть отрицательным"; // Проверка инварианта

```
___

#### 10. Присвоение недопустимых значений
```
// До
String color = "red";
// ...
color = null; // Неочевидно, что переменная больше не используется

// После
String color = "red";
// ...
color = "blue"; // Явное завершение работы с переменной, 

```
___

#### 11. Избегание повторяющегося кода с помощью методов
```
// До
double area1 = length1 * width1;
double area2 = length2 * width2;

// После
double calculateArea(double length, double width) {
    return length * width;
}
double area1 = calculateArea(length1, width1);
double area2 = calculateArea(length2, width2);

```
___

#### 12. Проверка инвариантов
```
// До
int quantity = getQuantity();
// ... 
if (quantity < 0) {
    System.out.println("Некорректное количество!");
}

// После
int quantity = getQuantity();
assert quantity >= 0 : "Количество не может быть отрицательным"; // Проверка инварианта

```
___

#### 13.  Использование StringBuilder для конкатенации строк в цикле
```
// До
String result = "";
for (String str : strings) {
    result += str; // Неэффективная конкатенация 
}

// После
StringBuilder result = new StringBuilder();
for (String str : strings) {
    result.append(str); // Эффективная конкатенация 
}

```
___

#### 14.  Избегание магических чисел в коде
```
// До
if (value > 100) { // Магическое число

// После
final int MAX_VALUE = 100;
if (value > MAX_VALUE) { // Явно объявленная константа

```
___

#### 15.  Вынесение логики в метод
```
// До
int sum = 0;
for (int i = 0; i < 5; i++) {
    sum += getValue(i); 
}

// После
int sum = calculateSum(5);

private int calculateSum(int count) {
    int sum = 0;
    for (int i = 0; i < count; i++) {
        sum += getValue(i);
    }
    return sum;
}

```
___