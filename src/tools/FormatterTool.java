package tools;


/*
* FormatterTool:
* - Formats email text: ensures salutations, line breaks, and a signature template.
* - Purpose: Demonstrate a small custom formatting tool used by the PolisherAgent.
*/


public class FormatterTool {
public FormatterTool() {
}


// A simple formatting implementation: ensures the reply has a salutation, body spacing, and signature.
public String formatEmail(String text) {
// Trim extra whitespace
String t = text.trim();


// If the reply doesn't start with a salutation, add one.
if (!t.startsWith("Hi") && !t.startsWith("Hello") && !t.startsWith("Dear")) {
t = "Hi,\n\n" + t;
}


// Ensure there is at least one blank line before signature
if (!t.contains("\n\n")) {
t = t + "\n\n";
}


// Append a simple signature if not present
if (!t.toLowerCase().contains("best,") && !t.toLowerCase().contains("sincerely")) {
t = t + "Best,\nYour Name";
}


return t;
}
}
