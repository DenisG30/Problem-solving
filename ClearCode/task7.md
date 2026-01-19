### 3.1.
```
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Гав!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мурр!");
    }
}

class AnimalFactory {
    public Animal createAnimal() {
        return new Dog();
    }
}
```

```
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
```

```
interface Transport {
    void drive();
}

class Car implements Transport {
    public void drive() {
        System.out.println("Driving a car!");
    }
}

class Motorcycle implements Transport {
    public void drive() {
        System.out.println("Riding a motorcycle!");
    }
}

class TransportFactory {
    public Transport createTransport(String transportType) {
        if (transportType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (transportType.equalsIgnoreCase("MOTORCYCLE")) {
            return new Motorcycle();
        }
        return null;
    }
}
```

### 3.2.
Интерфейс - Transport
Абстрактный класс - Car, Bike, Bus

Интерфейс - UserAction
Абстрактный класс - LoginAction, LogoutAction, RegisterAction

Интерфейс - Pet
Абстрактный класс - Dog, Cat, Bird

