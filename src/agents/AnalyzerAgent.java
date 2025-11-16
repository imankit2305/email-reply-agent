package agents;
* AnalyzerAgent:
* - Responsibility: Analyze incoming email to extract intent, urgency, and tone.
* - Design: Statelesstools-driven analysis. The agent uses ToneDetectionTool to keep
* concerns separated: AnalyzerAgent orchestrates, ToneDetectionTool implements analysis.
* - Behavior: Returns an AnalysisResult used by downstream agents.
*/


public class AnalyzerAgent {
private ToneDetectionTool toneTool;
private SessionManager session;


public AnalyzerAgent(ToneDetectionTool toneTool, SessionManager session) {
this.toneTool = toneTool;
this.session = session;
}


// Simple POJO to hold analysis results
public static class AnalysisResult {
public final String tone; // e.g., "formal", "friendly", "urgent"
public final String intent; // e.g., "request", "question", "followup"


public AnalysisResult(String tone, String intent) {
this.tone = tone;
this.intent = intent;
}
}


// Analyze the email text and return tone + intent. Implementation is simple for demo.
public AnalysisResult analyze(String emailText) {
// Implementation detail: this is where more advanced NLP could be used.
String tone = toneTool.detectTone(emailText);


// Minimal heuristic to detect intent (can be extended)
String lower = emailText.toLowerCase();
String intent = "other";
if (lower.contains("please") || lower.contains("can you") || lower.contains("could you") || lower.contains("send")) {
intent = "request";
} else if (lower.contains("?")) {
intent = "question";
}


// Store basic context in session for memory demonstration
session.put("last_email_snippet", emailText.substring(0, Math.min(80, emailText.length())));


return new AnalysisResult(tone, intent);
}
}
