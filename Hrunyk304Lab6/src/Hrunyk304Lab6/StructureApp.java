package Hrunyk304Lab6;

public class StructureApp {
    public static void main(String[] args) {
        StructureContainer<Building> buildingContainer = new StructureContainer<>();
        StructureContainer<Bridge> bridgeContainer = new StructureContainer<>();

        // Додавання будівель
        buildingContainer.addElement(new Building("Empire State Building", 381));
        buildingContainer.addElement(new Building("Burj Khalifa", 828));

        // Додавання мостів
        bridgeContainer.addElement(new Bridge("Golden Gate", 2737, 1));
        bridgeContainer.addElement(new Bridge("Brooklyn Bridge", 1834, 2));
        bridgeContainer.addElement(new Bridge("Brooklyn Bridge", 1834, 3));

        // Пошук максимальних елементів
        System.out.println("Найвища будівля: " + buildingContainer.findMaxElement().getName());
        System.out.println("Найдовший міст: " + bridgeContainer.findMaxElement().getName());

        // Виведення всіх елементів
        System.out.println("Усі будівлі: " + buildingContainer.getAllElements());
        System.out.println("Усі мости: " + bridgeContainer.getAllElements());
        System.out.println("Кількість мостів: " + Bridge.getCount() + "  " + "Кількість будівель: " + Building.getCount());

    }
}
