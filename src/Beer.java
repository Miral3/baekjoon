import java.util.Scanner;

public class Beer {
    public static void main(String[] args){
        int Beers;
        int n = 0;

        Scanner scanner = new Scanner(System.in);


        Beers = scanner.nextInt();

        n = Beers;
        while(Beers >= 0)
        {
            if(Beers > 1) {
                System.out.println(Beers + " bottles of beer on the wall, " + Beers + " bottles of beer.");
                System.out.println("Take ont down and pass it around, " + (Beers - 1) + " bottles of beer on the wall.");
            }
            else if(Beers == 1){
                System.out.println(Beers + " bottle of beer on the wall, " + Beers + " bottle of beer.");
                System.out.println("Take ont down and pass it around, no more bottles of beer on the wall.");
            }
            else if(Beers == 0){
                System.out.println("No more bottle of beer on the wall, no more bottle of beer.");
                System.out.println("Go to the store and buy some more, "+n +" bottles of beer on the wall.");
            }
            Beers--;
        }
    }
}
