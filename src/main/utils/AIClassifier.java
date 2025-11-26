package utils;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class AIClassifier {
    private static final String OPENAI_API_KEY = "YOUR_OPENAI_API_KEY";

    public static String classify(String dream) {
        OpenAiService service = new OpenAiService(OPENAI_API_KEY);
        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Classify this dream as Good or Bad: " + dream)
                .maxTokens(10)
                .build();
        return service.createCompletion(request).getChoices().get(0).getText().trim();
    }
}
