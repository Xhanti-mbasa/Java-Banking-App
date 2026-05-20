package operations.ai;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import java.util.Scanner;

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
                    client.models.generateContent(
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