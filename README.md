# 🚀 AI-Powered Selenium Test Generator (OpenAI + Ollama)

## Generate **production-ready Selenium Java automation scripts** from plain English test cases using AI.

This tool supports:

* ✅ OpenAI (cloud-based, high quality)
* ✅ Ollama (local, free & unlimited)

## 📌 Features

* Generate Selenium WebDriver scripts using **Java + TestNG**
* Follows **Page Object Model (POM)**
* Generates:

  * Page Object classes
  * Test classes
  * `testng.xml`
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
Any one of these:
* OpenAI API Key
* Ollama installed locally

## 📥 Installation

### 1. Clone the Repository

```
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
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

---

## 🧪 Input Test Case

Edit the file:

```
test_cases/input/sample_test_case.txt
```

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

---

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

---

## 🧠 Ollama Setup (Local Setup is required while using Ollama)

### Install Ollama

Download from: https://ollama.com

### Start Ollama

```
ollama serve
```

### Pull Model

```
ollama pull deepseek-coder
```

### Run Model

```
ollama run llama3
```

## ▶️ Run the Application

```
python main.py
```

## 📄 Output

Generated Selenium test script will be saved at:

```
test_cases/output/selenium_automation_test.java
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
ollama run llama3
```

### 🔴 Module Not Found Errors

```
pip install -r requirements.txt
```

## 💡 Best Practices

* When using OpenAI, Keep temperature low (0.2–0.3) for stable outputs
* Use Ollama for unlimited local generation
* Use OpenAI for higher quality scripts
* Never commit `.env` or `venv`

## :question: Need Assistance?

- Discuss your queries by writing to me @ `mohammadfaisalkhatri@gmail.com`
  OR ping me on any of the social media sites using the below link:
    - [Linktree](https://linktr.ee/faisalkhatri)

⭐ If you found this useful, please consider giving the repo a star!