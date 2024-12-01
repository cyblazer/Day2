// import java.io.BufferedReader;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.StringBufferInputStream;
// import java.io.StringReader;
// import java.net.URI;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.time.Duration;
// import java.util.stream.Stream;

// public class App {
//     public static void main(String[] args) throws Exception {
//         HttpClient client = HttpClient.newHttpClient();
//         HttpRequest request = HttpRequest.newBuilder(new URI("https://adventofcode.com/2024/day/1/input"))
//             .timeout(Duration.ofSeconds(10))
//             .GET() 
//             .build();
        
//         HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

//                 // Read the InputStream as a stream of lines
//         try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body()))) {
//             Stream<String> lines = reader.lines();

//             // Print each line (or process as needed)
//             lines.forEach(System.out::println);
//         }
//         catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class App{
    // public static void main(String[] args) throws IOException{
    //     BufferedReader f = new BufferedReader(new FileReader("input.txt"));

    //     int[] left = new int[1000];
    //     int[] right = new int[1000];

    //     for (int i = 0; i < 1000; i++){
    //         String line = f.readLine();
    //         String[] numbers = line.split("   ");

    //         left[i] = Integer.parseInt(numbers[0]);
    //         right[i] = Integer.parseInt(numbers[1]);
    //     }

    //     Arrays.sort(left);
    //     Arrays.sort(right);

    //     double sum = 0; 
    //     for (int i = 0; i < 1000; i++){
    //         sum += Math.max(left[i], right[i]) - Math.min(left[i], right[i]);
    //     }

    //     System.out.println(sum);
    // }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("input.txt"));

        int[] left = new int[1000];
        int[] right = new int[1000];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < 1000; i++){
            String line = f.readLine();
            String[] numbers = line.split("   ");

            left[i] = Integer.parseInt(numbers[0]);
            right[i] = Integer.parseInt(numbers[1]);
            if (map.containsKey(right[i])){
                map.put(right[i], map.get(right[i])+1);
            }
            else{
                map.put(right[i], 1);
            }
        }


        long score = 0;
        for (var num : left){
            if (map.containsKey(num)){
                score += map.get(num) * num;
            }
            else{
                continue;
            }
        }


        System.out.println(score);
    }
}
