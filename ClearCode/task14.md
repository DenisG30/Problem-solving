#### 3.1

```
// Метод для внесения денег на счет
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Увеличиваем баланс на сумму депозита
        } else {
            throw new IllegalArgumentException("Сумма депозита должна быть положительной.");
        }
    }
```
___

```
    // Метод для снятия денег со счета
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Уменьшаем баланс на сумму снятия
        } else {
            throw new IllegalArgumentException("Недостаточно средств или некорректная сумма снятия.");
        }
    }
```
___

```
    // Метод для добавления книги в библиотеку
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        } else {
            throw new IllegalArgumentException("Книга не может быть пустой.");
        }
    }
```
___

```
    // Метод для получения номера телефона по имени контакта
    public String getPhoneNumber(String name) {
        return contacts.get(name);
    }
```
___

```
    // Метод для вычисления расстояния до другой точки
    public double distanceTo(Point other) {
        if (other == null) {
            throw new IllegalArgumentException("Другая точка не может быть пустой.");
        }
        return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
    }
}
```
___
```
    // Метод для обновления пробега автомобиля
    public void updateMileage(double newMileage) {
        if (newMileage > mileage) {
            mileage = newMileage; // Обновляем пробег только если он увеличивается
        } else {
            throw new IllegalArgumentException("Новый пробег должен быть больше текущего.");
        }
    }
```
___

```
    // Метод для отображения информации об автомобиле
    public String displayInfo() {
        return "Автомобиль: " + make + " " + model + ", Год: " + year + ", Пробег: " + mileage + " км";
    }
}
```



    