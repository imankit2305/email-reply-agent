package tools;


/*
* ToneDetectionTool:
* - A small custom tool that detects the tone of an email using simple heuristics.
* - Purpose: Demonstrate a custom tool feature. In production, this could call an LLM
* or a sentiment classification model.
*/


public class ToneDetectionTool {
public ToneDetectionTool() {
// No initialization required for the demo.
}


// Detects a simple tone label from the email text.
// Comments: This is intentionally simple so reviewers can see exactly how the tool behaves.
public String detectTone(String emailText) {
String lower = emailText.toLowerCase();
if (lower.contains("urgent") || lower.contains("asap") || lower.contains("immediately")) {
return "urgent";
}
if (lower.contains("thanks") || lower.contains("thank you") || lower.contains("appreciate")) {
return "friendly";
}
// Default fallback
return "formal";
}
}
