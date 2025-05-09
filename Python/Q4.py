#A number is lucky if it is divisible by 7 or ends with the digit 7. 
# A function called "is_lucky" that returns True if a number is lucky. 
def is_lucky(n):
    return ((n % 7 == 0) or (str(n).endswith('7')))
# A main function that read an integer and print whether it’s lucky or not. 
def Main():
    #Takes input from users and changes to int.
    n = int(input("Enter a number: "))
    #Calls the upper function to check the number.
    if is_lucky(n):
        print(f"{n} is a lucky number.")
    else:
        print(f"{n} is not a lucky number.")


#Calling the main function
Main()