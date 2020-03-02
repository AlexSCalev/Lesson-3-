package Source;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class csv_parsing {

    protected void showReturn(String[][] returnMethods) {
        for (int i = 0; i < returnMethods.length; i++) {
            System.out.print("Str:" + "[" + i + "] ");
            for (int j = 0; j < returnMethods[i].length; j++) {
                System.out.print(" " + returnMethods[i][j]);
            }
            System.out.println();
        }
    }

    //    Create two demension array for provides text in format string[string number] and [wordNumber];
    private void getParsing_2Demens(ArrayList<String> listDate) {
        String[][] allDate = new String[listDate.size()][];
        for (int i = 0; i < allDate.length; i++) {
            String[] temp = listDate.get(i).split(",");
            allDate[i] = new String[temp.length];
            allDate[i] = temp;
        }
        showReturn(allDate);
    }

    public void splitParsing(String awayToFile) {
        BufferedReader br = null;
        String line = "";
        ArrayList<String> saveDate = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(awayToFile));
            while ((line = br.readLine()) != null) {
                for (String value : line.split("\n")) { // Replace /n to \n
                    saveDate.add(value);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getParsing_2Demens(saveDate);
    }

    public void ScannerParsing(String awayToFile) {
        ArrayList<String> saveDate = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(awayToFile));
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String temp = scanner.next();
                saveDate.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }
        getParsing_2Demens(saveDate);
    }
}
