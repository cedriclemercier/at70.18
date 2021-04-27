from selenium.webdriver.support.ui import WebDriverWait

class BasePageElement(object):
    
    def __set__(self, obj, value):
        driver = obj.driver
        WebDriverWait(driver, 100).until(
            lambda driver: driver.find_element_by_name(self.locator)
        )
        driver.find_element_by_name(self.locator).clear()
        driver.find_element_by_name(self.locator).send_keys(value)
        
    def __get__(self, obj, owner):
        driver = obj.driver
        WebDriverWait(driver, 100).until(
            lambda driver: driver.find_element_by_name(self.locator)
        )
        element = driver.find_element_by_name(self.locator)
        return element.get_attribute("value")
    
    
    
class TextElement(object):
    
    def __set__(self, obj, value):
        driver = obj.driver
        WebDriverWait(driver, 100).until(
            lambda driver: driver.find_element_by_name(self.locator)
        )
        driver.find_element_by_name(self.locator).clear()
        driver.find_element_by_name(self.locator).send_keys(value)
        
    def __get__(self, obj, owner):
        driver = obj.driver
        WebDriverWait(driver, 100).until(
            lambda driver: driver.find_element_by_name(self.locator)
        )
        element = driver.find_element_by_name(self.locator)
        return element.get_attribute("innerHTML")
    
    
class NavElement(object):
    
    def __set__(self, obj, value):
        driver = obj.driver
        WebDriverWait(driver, 100).until(
            lambda driver: driver.find_element_by_name(self.locator)
        )
        driver.find_element_by_name(self.locator).clear()
        driver.find_element_by_name(self.locator).send_keys(value)
        
    def __get__(self, obj, owner):
        driver = obj.driver
        # WebDriverWait(driver, 100).until(
        #     lambda driver: driver.find_element_by_partial_link_text(self.locator)
        # )
        WebDriverWait(driver, 100).until(
            lambda driver: driver.find_element_by_partial_link_text(self.locator)
        )
        element = driver.find_element_by_partial_link_text(self.locator)
        return element
    
# class PageLoadElement(object):
        
#     def __get__(self, obj, owner):
#         driver = obj.driver
#         WebDriverWait(driver, 100).until(lambda driver: driver.find_element_by_tag_name(self.locator))
#         element = driver.find_element_by_tag_name(self.locator)
#         print("ELEMENT:")
#         print(element)
#         print("CONTENTS")
#         print(element.get_attribute("innerHTML"))
#         return element.get_attribute("innerHTML")
    