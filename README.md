# 🚀 AI-Powered Selenium Test Generator (OpenAI + Ollama)

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

## 🏗️ Project Structure

```
.
├── config.py
├── tools.py
├── main.py
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

Title: Application Login scenario

Precondition: User is registered in the application.

Steps:
1. Open Chrome browser
2. Navigate to https://ecommerce-playground.lambdatest.io/index.php?route=account/login
3. Enter "Johndoe881@email.com" in the E-Mail Address field
4. Enter "Password@321" in the Password field
5. Click on the Login Button
5. Add an assert statement to check that "My Account" page is displayed.
```

## ⚡ Configuration

Update `config.py` to choose your provider:

### 👉 Use OpenAI

```python
provider = "openai"
```

### 👉 Use Ollama (Free, Local)

```python
provider = "ollama"
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

### 🔴 OpenAI Quota Error (429)

* Switch to Ollama:

```python
provider = "ollama"
```

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

### Don't forget to give a :star: to make the project popular