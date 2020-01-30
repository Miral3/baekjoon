import java.util.Scanner;

public class SearchA { //10809
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[26];

        String line = sc.next();

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = -1;
        }
        for(int i = 0; i < 26; i++) {
            for (int j = 0; j < line.length(); j++) {
                if ((line.charAt(j) - 97) == i)
                    if(arr[i] == -1)
                        arr[i] = j;
                    else
                        continue;

            }
                System.out.print(arr[i]+" ");
        }


    }
}
