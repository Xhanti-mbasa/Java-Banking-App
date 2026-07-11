
package operations.ai;

import java.util.Scanner;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class Myzar {
    private Myzar() {
    }

    public static void askAi() {
        String question = "";
        try (Scanner scanner = new Scanner(System.in)) {
            while (question.isEmpty()) {
                System.out.println("What would you like to know?");
                question = scanner.nextLine();
            }
        }

        try (Client client = Client.builder()
                .apiKey(System.getenv("API_KEY"))
                .build()) {

            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.0-flash",
                    question,
                    null
            );

            System.out.println(response.text());
        } catch (Exception e) {
            System.out.println("Error communicating with MYZAR: " + e.getMessage());
        }
    }
}
 