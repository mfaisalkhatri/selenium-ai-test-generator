# 🚀 AI-Powered Selenium Test Generator (OpenAI + Ollama)

## Don't forget to give a :star: to make the project popular

## Generate **Selenium Java automation scripts** from plain English test cases using AI.

This tool supports:

* ✅ OpenAI (cloud-based, high quality)
* ✅ Ollama (local, free & unlimited)

## 📌 Features

* Generate Selenium WebDriver scripts using **Java + TestNG**
* Follows **Page Object Model (POM)**
* Generates:
  * Page Object classes
  * Test class
  * testng.xml
* Config-driven architecture (switch models easily)
* Supports both **cloud and local LLMs**
* Beginner-friendly and extensible

## :writing_hand: Tutorial Blog Links
- [How to Build an AI Agent to Generate Selenium WebDriver Tests in Java: A Practical Guide for Test Automation Engineers](https://medium.com/@iamfaisalkhatri/how-to-build-an-ai-agent-to-generate-selenium-webdriver-tests-in-java-a-practical-guide-for-test-6fbaf27c53cf)

## 🎥 Tutorials 

[![Watch the video](https://img.youtube.com/vi/YmukML3G2Wo/hqdefault.jpg)](https://youtu.be/YmukML3G2Wo)

## 🏗️ Project Structure

```
.
├── config.py
├── tools.py
├── main.py
├── logger.py
├── requirements.txt
├── .env
├── test_cases/
│   ├── input/
│   │   └── sample_test_case.txt
│   └── output/
```

## ⚙️ Prerequisites

* Python 3.14+
* pip
* Any one of these:
  * OpenAI API Key
  * Ollama installed locally

## 📥 Installation

### 1. Clone the Repository

```
git clone git@github.com:mfaisalkhatri/selenium-ai-test-generator.git
cd selenium-ai-test-generator
```

### 2. Create Virtual Environment

```
python -m venv venv
```

Activate it:

**Mac/Linux**

```
source venv/bin/activate
```

**Windows**

```
venv\Scripts\activate
```

### 3. Install Dependencies

```
pip install -r requirements.txt
```

## 🔐 Environment Setup (Required only while using OpenAI)

Create a `.env` file:

```
OPENAI_API_KEY=your_api_key_here
```

> ⚠️ Do not commit `.env` to GitHub

## 🧪 Input Test Case

Edit the file:

```
test_cases/input/sample_test_case.txt

Title: Search for a Product on Home Page

Precondition: User is on the Home Page of the application

Steps:
1. Open Chrome browser
2. Navigate to https://ecommerce-playground.lambdatest.io/index.php
3. Enter "iPhone" in the Search text box
4. Click on the Search Button
5. Add an assert statement to verify that the the product "iPhone" is displayed
```


## ⚡ Configuration

Update `.env` to choose your provider:

### 👉 Use OpenAI

```env
OPENAI_MODEL_NAME=<model name>
OPENAI_MAX_TOKENS=<max tokens>
OPENAI_TEMPERATURE=<temperature>
OPENAI_API_KEY=<API Key>
```

### 👉 Use Ollama (Free, Local)

```env
OLLAMA_MODEL_NAME=<model name> e.g. qwen3:8b
OLLAMA_TEMPERATURE=0.3
OLLAMA_ENDPOINT=http://localhost:11434/api/generate
OLLAMA_BASEURL=http://localhost:11434
```

## 🧠 Ollama Setup (Local Setup is required while using Ollama)

### Install Ollama

Download from: https://ollama.com

### Start Ollama

```bash
ollama serve
```

### Pull Model

```bash
ollama pull deepseek-coder
```

OR

```bash
ollama pull qwen3:8b
```

### Run Model(Optional Step)
```bash
ollama run llama3
```

OR 
```bash
ollama run qwen3:8b
```

## ▶️ Run the Application

```bash
python main.py
```

## 📄 Output

Generated Selenium WebDriver test automation scripts are stored in a newly created folder named using the current date and time, located at:

```
test_cases/output/
```

## ❗ Troubleshooting

### 🔴 Ollama Connection Error

* Ensure Ollama is running:

```
ollama serve
```

### 🔴 Module Not Found Errors

```
pip install -r requirements.txt
```

## 💡 Best Practices

* When using OpenAI, Keep temperature low (0.2–0.3) for stable outputs
* Use Ollama for unlimited local test script generation
* Use OpenAI for higher quality scripts
* Never commit `.env` or `venv`

## :question: Need Assistance?

- Discuss your queries by writing to me @ `mohammadfaisalkhatri@gmail.com`
  OR ping me on any of the social media sites using the below link:
    - [Linktree](https://linktr.ee/faisalkhatri)