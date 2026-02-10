
####Максимально раннее связывание 
(жестко закодированные значения)

```
public class Example1 {
    private String defaultGreeting;

    public Example1() {
        defaultGreeting = "Hello, World!"; // Жестко закодированное значение
    }

    public void greet() {
        if (defaultGreeting != null) {
            //код...
        } else {
            //код...
        }
    }

    public void changeGreeting(String newGreeting) {
        defaultGreeting = newGreeting;
    }
}
```

Строка приветствия задается при создании объекта. Это жестко закодированное значение. Изменение текста приветствия требует изменения кода и его повторной компиляции. Нет возможности настроить приветствие без изменения кода. Подходит для простых приложений или прототипов, где нет необходимости в изменяемых значениях.

---

####Связывание при компиляции 
(константы)

```
public class Example2 {
    private static final String DEFAULT_USERNAME = "Guest";
    private String username;

    public Example2(String username) {
        this.username = (username != null && !username.isEmpty()) ? username : DEFAULT_USERNAME;
    }

    public void resetUsername() {
        username = DEFAULT_USERNAME;
    }
}
```

Используется константа DEFAULT_USERNAME, что позволяет избежать жесткого кодирования. Все еще требует компиляции при изменении значения константы. Необходимо перезапускать приложение для применения изменений. Подходит для случаев, когда значения не должны изменяться динамически, но их нужно легко настраивать.

---

####Связывание во время выполнения 
(чтение из пользовательского ввода)

```
import java.util.Scanner;

public class Example3 {
    private String userInput;

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        // код...

        userInput = scanner.nextLine(); // Чтение имени пользователя во время выполнения
    }

    public void greetUser() {
        //код...
    }
}
```

Запрос имени у пользователя во время выполнения. Это пример наиболее позднего связывания. Подходит для интерактивных приложений, где требуется высокая степень взаимодействия с пользователем и возможность динамического ввода данных.

---