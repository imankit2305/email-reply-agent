package agents;


import tools.FormatterTool;
import memory.SessionManager;


/*
* PolisherAgent:
* - Responsibility: Polish, adjust tone, and format the draft to produce the final reply.
* - Design: Uses FormatterTool to implement formatting rules; keeps text post-processing separate
* from LLM drafting.
* - Behavior: Ensures reply matches desired tone and includes a short & long version.
*/


public class PolisherAgent {
private FormatterTool formatter;
private SessionManager session;


public PolisherAgent(FormatterTool formatter, SessionManager session) {
this.formatter = formatter;
this.session = session;
}


// Polishes the draft text and returns the final reply.
public String polish(String draft, AnalyzerAgent.AnalysisResult analysis) {
// Adjust tone if necessary (simple heuristic for demo)
String adjusted = draft;
if ("formal".equalsIgnoreCase(analysis.tone)) {
// Example behavior: ensure a formal sign-off
adjusted = adjusted.replace("Best,", "Sincerely,");
}


// Use the formatter tool to enforce spacing, salutations, and signature template
String finalReply = formatter.formatEmail(adjusted);


// Save final reply in session
session.put("final_reply", finalReply);


// Also produce a short version for quick responses
String shortVersion = finalReply.split("\\n\\n")[0]; // first paragraph
session.put("short_reply", shortVersion);


return finalReply;
}
}
