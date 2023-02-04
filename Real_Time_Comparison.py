from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from pathlib import Path

source1="https://www.amazon.in/Lenovo-300Nits-Graphics-Refresh-82JU00SYIN/dp/B09NP41X5L/ref=sr_1_2_sspa?crid=3RT6EAMW8EJVV&keywords=lenovo+legion+5&qid=1675480357&sprefix=lenovo+legion+%2Caps%2C237&sr=8-2-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1"
source2="https://www.flipkart.com/lenovo-legion-5-ryzen-7-octa-core-amd-r7-5800h-16-gb-2-tb-ssd-windows-10-home-6-gb-graphics-nvidia-geforce-rtx-3060-15ach6h-gaming-laptop/p/itm3e4bbd7aa18c9?pid=COMG6AKV9AM8P6BX&lid=LSTCOMG6AKV9AM8P6BX10SQSP&marketplace=FLIPKART&q=lenovo+legion+5&store=6bo%2Fb5g&srno=s_1_2&otracker=AS_QueryStore_OrganicAutoSuggest_1_11_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_11_na_na_na&fm=organic&iid=af796a00-6411-4b02-8188-7cf2cdf58d42.COMG6AKV9AM8P6BX.SEARCH&ppt=hp&ppn=homepage&ssid=qkixviuzfk0000001675480390220&qH=e51afe776050d978"
source3="https://www.croma.com/lenovo-legion-5-pro-amd-ryzen-7-16-inch-16gb-1tb-ms-office-2021-nvidia-geforce-rtx-3060-storm-grey-82rg009ain-/p/256998"

#create a webdriver object for chrome-option and configure
wait_imp=10
CO = webdriver.ChromeOptions()
CO.add_experimental_option('useAutomaticExtension',False)
CO.add_argument('--ignore-certificate-errors')
CO.add_argument('--start-maximized')
wd = webdriver.Chrome(r'D:\chromedriver_win32\chromedriver.exe',options=CO)
print("********************************************************************\n")
print("                       Starting Program, Please Wait ........\n")
print("Connecting to Amazon")
wd.get(source1)
wd.implicitly_wait(wait_imp)
a_price=wd.find_element_by_xpath("/html/body/div[2]/div[2]/div[5]/div[4]/div[4]/div[10]/div[3]/div[1]/span[2]/span[2]/span[2]")
pr_name=wd.find_elements_by_xpath("/html/body/div[2]/div[2]/div[5]/div[4]/div[4]/div[1]/div/h1/span")
product= pr_name.text
r_price= a_price.text
#print
print("--> Successfully retrieved the price from Amazon\n")
time.sleep(2)

print("Connecting to Flipkart")
wd.get(source2)
wd.implicitly_wait(wait_imp)
f_price = wd.find_element_by_xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]")
raw_f = f_price.text
#print
print("--> Successfully retrieved the price from Flipkart\n")
time.sleep(2)

print("Connecting to Croma")
wd.get(source2)
wd.implicitly_wait(wait_imp)
c_price = wd.find_element_by_xpath("/html/body/main/div[3]/div[1]/div[2]/div[1]/div/div/div/div[3]/div/ul/li[1]/div[2]/div[1]/div/span")
raw_c = c_price.text
#print
print("--> Successfully retrieved the price from Croma\n")
time.sleep(2)

#Final Display
print("-------------------------------------------------------------------------------------------------------------------------\n")
print("Price for [{}] for all website, Prices are in INR Currency".format(product))
print("Price available at Amazon is:"+r_price[1:])
print("Price available at Flipkar is:"+raw_f[2:8])
print("Price available at Croma is:"+raw_c[1:7])