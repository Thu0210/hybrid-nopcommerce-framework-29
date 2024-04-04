package commons;

import java.util.Random;

public class BaseTest {
    protected int generateRandomNumber(){
        return new Random().nextInt(9999);
    }
    protected void SleepInSecond() throws InterruptedException {
        Thread.sleep(5000);
    }
}
