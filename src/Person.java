public class Person {
    protected String firstName;
    protected String secondName;
    protected int ticketsAmount;

    public Person(String firstName, String secondName, int ticketsAmount ){
        this.firstName = firstName;
        this.secondName = secondName;
        this.ticketsAmount = ticketsAmount;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getTicketsAmount() {
        return ticketsAmount;
    }
    public void ticketDecrease() {
        this.ticketsAmount--;
    }
    public String toString () {
        return firstName + " " + secondName + " " + ticketsAmount;
    }
}
