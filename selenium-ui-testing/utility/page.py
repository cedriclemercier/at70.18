from utility.locator import *
from utility.element import BasePageElement, TextElement, NavElement
from selenium.webdriver.support.ui import WebDriverWait
import time


class LoginUsername(BasePageElement):
    locator = "username"

class LoginPassword(BasePageElement):
    locator = "password"
    
class UserRole(TextElement):
    locator = "user_role"
    
# class BasicNavElement(NavElement):
#     def __init__(self, name):
#         self.locator = name

class BasePage(object):
    def __init__(self, driver):
        self.driver = driver
        
        
# class MainPage(BasePage):
    
#     search_text_element = SearchTextElement()
    
#     def is_title_matches(self):
#         return "Python" in self.driver.title
    
#     def click_go_button(self):
#         element = self.driver.find_element(*MainPageLocators.GO_BUTTON)
#         element.click()

class MainPage(BasePage):
    def browse_basic_pages(self):
        print("Testing access to common pages...")
        self.go_home()
        self.go_shop()
        self.go_cart()
        self.go_account()
        
    def go_home(self):
        self.driver.find_element(*NavPageLocators.GO_TO_HOME).click()
        time.sleep(2)
        assert "Home" in self.driver.title
    def go_shop(self):
        self.driver.find_element(*NavPageLocators.GO_TO_DONUT_LIST).click()
        time.sleep(2)
        assert "Our Doughnuts" in self.driver.title
    def go_cart(self):
        self.driver.find_element(*NavPageLocators.GO_TO_SHOPPING_CART).click()
        time.sleep(2)
        assert "Shopping Cart" in self.driver.title
    def go_account(self):
        self.driver.find_element(*NavPageLocators.GO_TO_MY_ACCOUNT).click()
        time.sleep(2)
        assert "Employee Home" in self.driver.title
        
    def go_to_orders_picking(self):
        print("Trying access to orders...")
        self.driver.get("http://localhost:8080/manageOrdersPicking")
        time.sleep(3)
        return "Manage Order Picking" in self.driver.title
    
    def go_to_employee_page(self):
        print("Trying access to employee pages...")
        self.driver.get("http://localhost:8080/homeEmployee")
        time.sleep(3)
        return "Employee Home" in self.driver.title
    
    def go_to_create_employee_page(self):
        print("Trying access to creating employee...")
        self.driver.get("http://localhost:8080/createEmployee")
        time.sleep(3)
        return "Create Employee" in self.driver.title

class LoginPage(BasePage):
    login_username = LoginUsername()
    login_password = LoginPassword()
    user_role = UserRole()
    
    def is_title_matches(self):
        return "Employee Home" in self.driver.title
    
    def login(self):
        # username = self.driver.find_element(*LoginPageLocators.USERNAME)
        # password = self.driver.find_element(*LoginPageLocators.PASSWORD)
        
        self.login_username = "administrator"
        self.login_password = "administrator"
        
        submit = self.driver.find_element(*LoginPageLocators.SUBMIT)
        submit.click()
        
        time.sleep(1)
        
    def login_as_supervisor(self):
        self.login_username = "supervisor"
        self.login_password = "supervisor"
        
        submit = self.driver.find_element(*LoginPageLocators.SUBMIT)
        submit.click()
        
        time.sleep(1)
        

        
class DonutListPage(BasePage):
    def is_title_matches(self):
        return "Our Doughnuts" in self.driver.title
    
    def add_a_product(self):
        element = self.driver.find_element(*DonutPageLocators.ADD_A_PRODUCT)
        element.click()
        time.sleep(3)
        cart_item = self.driver.find_element(*CartPageLocators.DELETE_PRODUCT)
        return cart_item
        
        
class CartPage(BasePage):
    def is_title_matches(self):
        return "Shopping Cart" in self.driver.title
    
        
class OrderPickingPage(BasePage):
    def is_title_matches(self):
        return "Manage Order Picking" in self.driver.title
    

class ShopPage(BasePage):
    def add_new_recipe(self):
        element = self.driver.find_element(*ShopPageLocators.ADD_RECIPE)
        element.click()
        time.sleep(2)
        
class AddRecipePage(BasePage):
    def is_title_matches(self):
        return "New Donut Recipes" in self.driver.title