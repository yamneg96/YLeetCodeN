# def greet():
#   print("Enter 3 names: ")
#   for i in range(3):
#     name = input()
#     if name == "":
#       print("No name entered")
#       continue
#     else:
#       # Print the greeting message
#       print("hello " + name)

# greet()
# # The code takes 3 names as input from the user and prints a greeting message for each name.


def greet(name):
  # Print the greeting message
  print("hello " + name)

print("Enter 3 names: ")
for i in range(3):
  name = input()
  greet(name)
# The code takes 3 names as input from the user and prints a greeting message for each name.

