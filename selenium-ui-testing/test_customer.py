import unittest
from selenium import webdriver
from utility import page, locator

BASE_URL = "http://localhost:8080/"
CHROME_DRIVER_DIRECTORY = "C:\Program Files (x86)\chromedriver.exe"


class CustomerAccessRestrictedNavigation(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome(CHROME_DRIVER_DIRECTORY)
        self.driver.get(BASE_URL)
        
    def test_access_restricted_pages(self):
        print("Accessing restricted pages as customer...")
        mainPage = page.MainPage(self.driver)
        assert not mainPage.go_to_orders_picking()
        assert not mainPage.go_to_create_employee_page()
        assert not mainPage.go_to_employee_page()
        
    def tearDown(self):
        self.driver.close()

class DonutTCNavigation(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome(CHROME_DRIVER_DIRECTORY)
        self.driver.get(BASE_URL + "donutList")
        
    def test_a_browse_donuts_list(self):
        print("Browsing to Doughnut list...")
        donutPage = page.DonutListPage(self.driver)
        assert donutPage.is_title_matches()
        
    def test_b_add_product_to_cart(self):
        print("Adding a product to cart...")
        donutPage = page.DonutListPage(self.driver)
        assert donutPage.add_a_product()
        

    def tearDown(self):
        self.driver.close()
        
        
class CustomerBasicNavigation(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome(CHROME_DRIVER_DIRECTORY)
        self.driver.get(BASE_URL)
        
    def test_access_restricted_pages(self):
        print("Accessing common pages as customer...")
        mainPage = page.MainPage(self.driver)
        mainPage.browse_basic_pages()
        
    def tearDown(self):
        self.driver.close()
        
        
if __name__ == "__main__":
    unittest.main()