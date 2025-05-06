print("Enter price of an item: ")
price = input()
new_price = float(price) #Converts the string to a float
#Since input() returns a string, we need to convert it to an float using float()

if(new_price > 100):
    new_price = new_price - (new_price * 0.1)
    print(new_price)
else:
    print(new_price)