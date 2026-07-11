
package operations.ai;

import java.util.Scanner;
import operations.client.Client;
import com.google.ai.generativelanguage.v1beta2.GenerateContentResponse;


public class Myzar {
    public static void askAi() {
        String question = "";
        Scanner scanner = new Scanner(System.in);

        while (question.isEmpty()) {
            System.out.println("What would you like to know?");
            question = scanner.nextLine();
        }

        try (Client client = Client.builder()
                .apiKey(System.getenv("API_KEY"))
                .build()) {

            GenerateContentResponse response =
                    Client.models.generateContent(
                            "gemini-1.5-flash",
                            question,
                            null
                    );

            System.out.println(response.text());
        } catch (Exception e) {
            System.out.println("Error communicating with MYZAR: " + e.getMessage());
        }
    }
}
 */