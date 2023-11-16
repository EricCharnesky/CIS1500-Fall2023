public class Main {
    public static void main(String[] args) {

        // Math.random() gives a random number from 0 up to 1 but not including 1,
        // so if you multiply it by the max number you want and then convert to an integer
        // you'll have a number 0-max not including max
        // then add 1 and you'll have 1-max, including max

        double someNumber = Math.random();

        for( int number = 0; number < 10; number++ ) {
            int randomNumber = (int) (Math.random() * 5) + 1;
            System.out.println(randomNumber);
        }
    }
}