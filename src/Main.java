import agents.AnalyzerAgent;
import agents.DraftAgent;
import agents.PolisherAgent;
import tools.ToneDetectionTool;
import tools.FormatterTool;
import memory.SessionManager;
import utils.GeminiClient;


public class Main {
public static void main(String[] args) {
// Example input: either use the first CLI argument as the email text
// or fall back to a built-in sample email.
String emailText = (args.length > 0) ? args[0]
: "Hi,\n\nI need the Q3 sales report updated. Can you send it by Friday?\n\nThanks,\nBob";


// Initialize shared components (tools, session, LLM client).
// Design: Keep tools decoupled from agents so tools can be reused across agents.
ToneDetectionTool toneTool = new ToneDetectionTool();
FormatterTool formatter = new FormatterTool();
SessionManager session = new SessionManager();


// GeminiClient contains the placeholder API_KEY. Replace with your key if available.
GeminiClient gemini = new GeminiClient();


// Instantiate agents with dependencies injected.
// Implementation note: We pass the tools and session so each agent can use them.
AnalyzerAgent analyzer = new AnalyzerAgent(toneTool, session);
DraftAgent drafter = new DraftAgent(gemini, session);
PolisherAgent polisher = new PolisherAgent(formatter, session);


// Sequential execution (this demonstrates a sequential multi-agent pipeline).
System.out.println("--- Incoming Email ---\n" + emailText + "\n----------------------\n");


// Step 1: Analyze
AnalyzerAgent.AnalysisResult analysis = analyzer.analyze(emailText);
System.out.println("[Analyzer] Detected tone: " + analysis.tone + ", intent: " + analysis.intent);


// Step 2: Draft using LLM (Gemini placeholder)
String draft = drafter.generateDraft(emailText, analysis);
System.out.println("\n[DraftAgent] Draft generated:\n" + draft + "\n");


// Step 3: Polish and format
String finalReply = polisher.polish(draft, analysis);
System.out.println("[Polisher] Final Reply:\n" + finalReply + "\n");


// Save the final reply in session memory for future context/threading demonstration
session.put("last_reply", finalReply);


System.out.println("\n--- Session Snapshot ---\n" + session.debugSnapshot());
System.out.println("\nDone. Replace the API key placeholder in src/utils/GeminiClient.java to enable real LLM calls.");
}
}
