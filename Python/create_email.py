from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

def create_gmail_account(first_name, last_name, username, password):
    # Set up the WebDriver (use your own driver path if necessary)
    driver = webdriver.Chrome()

    # Navigate to Gmail signup page
    driver.get("https://accounts.google.com/signup")

    # Fill in the signup form
    try:
        # Enter first name
        WebDriverWait(driver, 10).until(
            EC.presence_of_element_located((By.ID, "firstName"))
        ).send_keys(first_name)

        # Enter last name
        driver.find_element(By.ID, "lastName").send_keys(last_name)

        # Enter username
        driver.find_element(By.ID, "username").send_keys(username)

        # Enter password
        driver.find_element(By.NAME, "Passwd").send_keys(password)
        driver.find_element(By.NAME, "ConfirmPasswd").send_keys(password)

        # Click Next button
        driver.find_element(By.XPATH, "//span[contains(text(), 'Next')]").click()

        # Add delays for captcha or additional steps (e.g., phone verification)
        time.sleep(5)
    except Exception as e:
        print(f"Error: {e}")
    finally:
        driver.quit()

# Usage example
create_gmail_account(
    first_name="John",
    last_name="Doe",
    username="john.doe.python123",
    password="YourStrongPassword123!"
)
