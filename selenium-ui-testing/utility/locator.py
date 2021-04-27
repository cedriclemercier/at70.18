from selenium.webdriver.common.by import By

class MainPageLocators(object):
    GO_BUTTON = (By.ID, "submit")
    
class LoginPageLocators(object):
    USERNAME = (By.NAME, "username")
    PASSWORD = (By.NAME, "password")
    SUBMIT = (By.NAME, "submit")
    
class NavPageLocators(object):
    GO_TO_HOME = (By.ID, "go-home")
    GO_TO_DONUT_LIST = (By.PARTIAL_LINK_TEXT, "Doughnuts")
    GO_TO_SHOPPING_CART = (By.PARTIAL_LINK_TEXT, "Shopping Cart")
    GO_TO_LOGIN = (By.PARTIAL_LINK_TEXT, "Log In")
    GO_TO_LOGOUT = (By.PARTIAL_LINK_TEXT, "Log Out")
    
    GO_TO_MY_ACCOUNT = (By.PARTIAL_LINK_TEXT, "My Account")
    GO_TO_ORDERS = (By.PARTIAL_LINK_TEXT, "Manage Orders")
    
    
class DonutPageLocators(object):
    ADD_A_PRODUCT = (By.LINK_TEXT, "Add Now")
    
    
class CartPageLocators(object):
    CHANGE_QUANTITY = (By.PARTIAL_LINK_TEXT, "cartLines")
    CONFIRM_CHANGE_QUANTITY = (By.CLASS_NAME, "button-update-sc")
    ENTER_CUSTOMER_INFO = (By.LINK_TEXT, "Enter Customer Info")
    DELETE_PRODUCT = (By.LINK_TEXT, "Delete")
    ADD_MORE_PRODUCTS = (By.LINK_TEXT, "Continue Add")
    
class OrderInformationLocators(object):
    FIRSTNAME = (By.TAG_NAME, "firstname")
    LASTNAME = (By.TAG_NAME, "lastname")
    EMAIL = (By.TAG_NAME, "email")
    PICKUP_SHOP_RADIO = (By.ID, "shop1")
    # TODO SELECT DATE
    # TODO SELECT HOUR
    VALIDATE_ORDER = (By.ID, "submitOrderInfo")
    
class ManageOrdersLocators(object):
    GO_TO_MANAGE_ORDERS_PICKING = (By.LINK_TEXT, "Manage orders picking")
    

class ShopPageLocators(object):
    ADD_RECIPE = (By.ID, "add-recipe")