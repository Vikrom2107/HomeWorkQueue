import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Queue<Person> queueAttraction = (LinkedList) generateClients(5);
        int number = 1;
        while (!queueAttraction.isEmpty()) {
            Person person = queueAttraction.poll();
            person.ticketDecrease();
            System.out.println(number + ". " +person.getFirstName() + " " + person.getSecondName() +
                    " прокатился(-ась) на аттракционе. Осталось " + person.getTicketsAmount() + " билетов.");
            if (person.getTicketsAmount() > 0) {
                queueAttraction.offer(person);
            }
            number++;
//            for (int i = 0; i < queueAttraction.size(); i++) {
//                System.out.println(queueAttraction.peek().toString());
//            }
            Thread.sleep(1000);
        }
        System.out.println("У всех закончились билеты");

    }
    public static List<Person> generateClients(int numberOfPersons) {
        String[] firstNames = {"Olya", "Petya", "Kolya", "Katya", "Elena", "Sergey"};
        String[] secondNames = {"Kovalenko", "Smirnov", "Ivanov", "Krinovich", "Korjov"};
        int maxTickets = 4;
        LinkedList<Person> persons = new LinkedList<>();
        for (int i = 0; i < numberOfPersons; i++) {
            String firstName = firstNames[(int)(Math.random() * firstNames.length)];
            String secondName = secondNames [(int)(Math.random() * secondNames.length)];
            if (firstName.equals("Olya") || firstName.equals("Katya") || firstName.equals("Elena")) {
                if (secondName.equals("Smirnov") || secondName.equals("Ivanov") || secondName.equals("Korjov")) {
                    secondName += "a";
                }
            }
            int amountTickets = 1 + (int)(Math.random() * maxTickets);
            persons.add(new Person(firstName,secondName,amountTickets));
        }
        return persons;
    }
}