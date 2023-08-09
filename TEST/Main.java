import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static int max = 50;


    public static void logTimeComplexity(String functionName, String timeComplexity) {
        LOGGER.log(Level.INFO, functionName + " has a time complexity of " + timeComplexity);
    }


    public static void function1(int[] arr) {
        // O(n)
        int sum = 0;
        for (int num : arr) {
            sum += num;
            logTimeComplexity("function1", "O(n)");
        }
    }

    public static void function2(int[] arr) {
        // O(n^2)
        int product = 1;
        for(int k=0;k<24;k++){
            product = product*k;
        }
        function1(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for(int l=0;l<arr.length;l++){
                    product *= arr[i] * arr[j];
                    LOGGER.log(Level.INFO, product);
                }
            }
        }
        logTimeComplexity("function2", "O(n^2)");
    }


    public static void function3(int[] arr) {
        // O(nlog n)
        Arrays.sort(arr);
        if(arr.length==0){
            return;
        }
        int[] cpy = Arrays.copyOf(arr,arr.length-1);
        logTimeComplexity("function3", "recursion");
        function3(cpy);
//        int target = 5;
//        int low = 0;
//        int high = arr.length - 1;
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (arr[mid] == target) {
//                break;
//            } else if (arr[mid] < target) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
    }

//    public static int[] readIntArrayFromFile(String fileName) {
//        try{
//            BufferedReader reader = new BufferedReader(new FileReader(fileName)) {
//                String line = reader.readLine();
//          if (line != null) {
//                    line = line.trim();
//                    if (line.startsWith("{") && line.endsWith("}")) {
//                        line = line.substring(1, line.length() - 1).trim();
//                        String[] parts = line.split(",");
//                        int[] array = new int[parts.length];
//                        for (int i = 0; i < parts.length; i++) {
//                            array[i] = Integer.parseInt(parts[i].trim());
//                            logTimeComplexity("function3", "O(nlog n)");
//                        }
//                        return array;
//                    }
//                }
//            }
//        catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
        public static void main(String[] args) {
            LOGGER.log(Level.INFO, "main");
            int[] arr = readIntArrayFromFile("src/array.txt");
            long startTime;
            long endTime;
            long executionTime;
            logTimeComplexity("Demo","trial");
            startTime = System.currentTimeMillis();
            function1(arr);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Execution time function1: " + executionTime + "ms");
            startTime = System.currentTimeMillis();
            function2(arr);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Execution time function2: " + executionTime + "ms");
            startTime = System.currentTimeMillis();
            function3(arr);
            function3(arr);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Execution time function3: " + executionTime + "ms");
        }
    }
