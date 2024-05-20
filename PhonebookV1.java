package homework1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {

        Entry[] entries = FileUtils.readFile("raw_phonebook_data.csv");
        MergeSort.sort(entries);

        FileUtils.writeToFile(entries, "result.csv");

        Scanner input = new Scanner(System.in);
        while(true){

            System.out.println("Enter the searched name, or -1 to exit the program: ");
            String name = input.nextLine();
            if(name.equals("-1")){
                break;
            }
            else{
                int[] indexes = BinarySearch.search(entries, name);
                if(indexes.length==0){
                    System.out.println("No such entry");
                }
                else{
                    for(int i : indexes){
                        System.out.println(entries[i]);
                    }
                }
            }
        }

    }
}
