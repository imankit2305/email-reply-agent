package agents;


import memory.SessionManager;
import utils.GeminiClient;


/*
* DraftAgent:
* - Responsibility: Produce an initial reply draft using an LLM client (Gemini).
* - Design: Keeps LLM calls encapsulated in GeminiClient to isolate API-specific details.
* - Behavior: Builds a prompt using the analysis result and asks the LLM for a draft.
*/


public class DraftAgent {
private GeminiClient gemini;
private SessionManager session;


public DraftAgent(GeminiClient gemini, SessionManager session) {
this.gemini = gemini;
this.session = session;
}


// Generate an initial draft using the GeminiClient. The prompt construction
// shows how context and analysis results are combined into a single request.
public String generateDraft(String emailText, AnalyzerAgent.AnalysisResult analysis) {
// Build a concise prompt for the LLM. This is context engineering in practice.
StringBuilder prompt = new StringBuilder();
prompt.append("You are a professional assistant. Reply to the incoming email below.\n\n");
prompt.append("Email:\n").append(emailText).append("\n\n");
prompt.append("Analysis: tone=").append(analysis.tone).append(", intent=").append(analysis.intent).append("\n");
prompt.append("Requirements: Keep reply concise, polite, and match the tone. Include a clear action item if the sender requested something.\n\n");
prompt.append("Reply:\n");


// Call GeminiClient to generate the draft. Implementation note: GeminiClient contains
// a placeholder API_KEY by design—replace it before making real calls.
String draft = gemini.generateText(prompt.toString());


// If the GeminiClient returned a placeholder (no API key set), generate a simple mock draft
if (draft == null || draft.isEmpty()) {
// Fallback behavior: produce a basic template-based reply so the pipeline can be demonstrated
draft = "Hi,\n\nThanks for reaching out. I can update the Q3 sales report and send it by Friday.\n\nBest,\n[Your Name]";
}


// Save draft to session for traceability / evaluation
session.put("last_draft", draft);


return draft;
}
}
