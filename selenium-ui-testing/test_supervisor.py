import unittest
from selenium import webdriver
from utility import page, locator
import time

BASE_URL = "http://localhost:8080/"
CHROME_DRIVER_DIRECTORY = "C:\Program Files (x86)\chromedriver.exe"

def login(param):
    loginPage = page.LoginPage(param)
    loginPage.login_as_supervisor()
        
        
class SupervisorAuthorisedPages(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome(CHROME_DRIVER_DIRECTORY)
        self.driver.get(BASE_URL)
        
    def test_access_restricted_pages(self):
        print("Accessing authorised as a SUPERVISOR...")
        login(self.driver)
        time.sleep(2)
        mainPage = page.MainPage(self.driver)
        assert mainPage.go_to_orders_picking()
        time.sleep(2)
        assert mainPage.go_to_employee_page()
        time.sleep(3)
        
    def tearDown(self):
        self.driver.close()
        
        
class SupervisorRestrictedPages(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome(CHROME_DRIVER_DIRECTORY)
        self.driver.get(BASE_URL)
        
    def test_access_restricted_pages(self):
        print("Accessing restricted pages as a SUPERVISOR...")
        login(self.driver)
        mainPage = page.MainPage(self.driver)
        time.sleep(2)
        assert not mainPage.go_to_create_employee_page()
        time.sleep(5)
        
    def tearDown(self):
        self.driver.close()
        
if __name__ == "__main__":
    unittest.main()