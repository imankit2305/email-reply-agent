Email Reply Generator Agent (Plain Java)

A multi-agent Java-based Email Reply Generator built for the Google AI Agents Intensive Capstone Project.

This project demonstrates how multiple agents, tools, and memory can work together to analyze an email, generate an intelligent response, and polish the final output — all without requiring any external frameworks.

📌 Project Overview

This project uses a 3-agent sequential pipeline to process an incoming email:

1️⃣ AnalyzerAgent

Detects email tone (friendly, formal, urgent)

Identifies intent (request, question, other)

Stores context in session memory

2️⃣ DraftAgent

Builds a prompt using email + analysis

Uses a placeholder GeminiClient to generate draft replies

Includes a fallback draft for offline use

Stores the draft in memory

3️⃣ PolisherAgent

Adjusts tone if needed

Formats text using a custom FormatterTool

Generates final + short summary replies

Saves final result in memory

These agents work sequentially to produce a professional email reply.

📁 Project Structure
src/
│── Main.java
│
├── agents/
│   ├── AnalyzerAgent.java
│   ├── DraftAgent.java
│   └── PolisherAgent.java
│
├── tools/
│   ├── ToneDetectionTool.java
│   └── FormatterTool.java
│
├── memory/
│   └── SessionManager.java
│
└── utils/
    └── GeminiClient.java


This folder structure demonstrates clean agent design and modular components.

🧠 Capstone Requirements Demonstrated
✔ Multi-Agent System

Sequential agent pipeline (Analyzer → Draft → Polisher)

✔ Tools

Custom tools:

ToneDetectionTool

FormatterTool

Demonstrates tool-based separation of logic

✔ Sessions & Memory

SessionManager stores:

last email snippet

draft

final polished reply

short reply version

✔ Context Engineering

Prompt construction inside DraftAgent

✔ Safe LLM Integration

GeminiClient includes a placeholder API key

Does NOT expose sensitive information

▶️ How to Run This Project Locally
1. Ensure Java is installed
java -version


Requires JDK 17+.

2. Compile all Java files

Inside your project folder:

javac -d out src/*.java src/agents/*.java src/tools/*.java src/memory/*.java src/utils/*.java

3. Run the agent

Run with default sample email:

java -cp out Main


Run with custom email:

java -cp out Main "Hi, can you send me the updated report?"

🤖 About the GeminiClient

The file GeminiClient.java uses a placeholder:

private static final String API_KEY = "YOUR_API_KEY_HERE";


The project works fully without an API key because:

DraftAgent uses a fallback template reply

This allows offline testing for the capstone

If you want real LLM output, you may implement an HTTP request with your actual key locally, but never commit it.

📌 Why This Project Is Useful

Auto-generates email replies

Saves time for busy professionals

Ensures consistent tone and clarity

Demonstrates modular agent design

Easy to extend (e.g., add sentiment analysis or auto-sending)

🎯 Capstone Submission Notes

This repository contains all source code

No API keys are included

The project demonstrates 3+ required agent concepts

Works as a fully self-contained multi-agent pipeline

Suitable for code review by judges

🎉 Future Enhancements

Real Gemini API integration

UI interface or web endpoint

Batch email processing

Retrieval-based memory system

Personalized signatures

🏁 Conclusion

This project successfully showcases a complete multi-agent email reply system using only plain Java, custom tools, session memory, and a clean folder structure. It demonstrates the core principles required by the Google AI Agents Intensive capstone.
