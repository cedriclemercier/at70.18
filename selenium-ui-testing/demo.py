from selenium import webdriver
import time

driver = webdriver.Chrome("C:\Program Files (x86)\chromedriver.exe")
driver.get("https://www.facebook.com/")

email = driver.find_element_by_id("email")
password = driver.find_element_by_id("password")
submit = driver.find_element_by_name("submit")

email.send_keys("test@gmail.com")
password.send_keys("password")
submit.click()
