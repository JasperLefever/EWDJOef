package domein;


public class GreetingServiceImpl implements GreetingService {

    private String greeting;

    @Override
    public String sayGreeting() {
        return greeting;
    }

    //SETTER INJECTION
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}