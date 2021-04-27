import unittest
from selenium import webdriver
from utility import page, locator
import time

class DonutTCNavigationManager(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome("C:\Program Files (x86)\chromedriver.exe")
        self.driver.get("http://localhost:8080/")
        
    # # Testing if manager can't access certain pages
    # def test_access_orders_supervisor_pages(self):
    #     mainPage = page.MainPage(self.driver)
    #     assert not mainPage.go_to_orders_picking()
    
    def test_c_create_recipe(self):
        loginPage = page.LoginPage(self.driver)
        loginPage.login()
        mainPage = page.MainPage(self.driver)
        mainPage.go_shop()
        shopPage = page.ShopPage(self.driver)
        shopPage.add_new_recipe()
        time.sleep(2)
        addRecipePage = page.AddRecipePage(self.driver)
        assert addRecipePage.is_title_matches()
        
    # Testing if manager can access basic pages
    def test_b_browsing(self):
        loginPage = page.LoginPage(self.driver)
        loginPage.login()
        mainPage = page.MainPage(self.driver)
        mainPage.browse_basic_pages()
        
    # Testing if manager can log in
    def test_a_log_in(self):
        print("Logging in as administrator...")
        loginPage = page.LoginPage(self.driver)
        loginPage.login()
        assert loginPage.is_title_matches()
    

    def tearDown(self):
        self.driver.close()
        
        
if __name__ == "__main__":
    unittest.main()