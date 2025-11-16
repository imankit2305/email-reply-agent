package utils;


/*
* GeminiClient:
* - Encapsulates calls to the LLM (Gemini) API. For this capstone, we provide a placeholder
* implementation so the pipeline is runnable without credentials.
* - IMPORTANT: This file intentionally contains a placeholder API key constant. You chose
* to use option 1 (placeholder). Replace the value of API_KEY with your real key only
* in your local environment. Never commit your API key to a public repository.
*
* - If you want to integrate a real LLM, replace the generateText method body with an
* HTTP client call to the Gemini/OpenAI endpoint and parse the response. We do not include
* external HTTP libraries here to keep the project dependency-free.
*/


public class GeminiClient {
// Placeholder API key as requested. Do not share this; replace when running locally.
private static final String API_KEY = "YOUR_API_KEY_HERE";


public GeminiClient() {
// Constructor could initialize an HTTP client if needed.
}


// generateText: given a prompt, return generated text from the LLM.
// Current behavior:
// - If API_KEY is not replaced, returns an empty string to signal the DraftAgent to use a fallback.
// - If API_KEY has been replaced and you implement an HTTP call here, this method should return the LLM response.
public String generateText(String prompt) {
// Safety: ensure we never print the API key anywhere in logs.


if (API_KEY == null || API_KEY.equals("YOUR_API_KEY_HERE") || API_KEY.trim().isEmpty()) {
// No API key configured — return empty so DraftAgent uses the offline fallback draft.
return "";
}


// TODO: Implement actual HTTP request to LLM service here.
// Example pseudocode (not implemented):
// HttpRequest req = HttpRequest.newBuilder()
// .uri(URI.create("https://api.example.com/v1/generate"))
// .header("Authorization", "Bearer " + API_KEY)
// .POST(BodyPublishers.ofString(jsonPayload))
// .build();
// HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
// parse and return the generated text from resp.body()


// For the capstone submission, we leave this unimplemented so that you can
// add your preferred HTTP client and secrets management approach.


return ""; // placeholder
}
}
