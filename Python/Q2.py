print("Enter Five different numbers: ")
evenCounter = 0
oddCounter = 0
for i in range(5):
    num = int(input())
    if num % 2 == 0:
        evenCounter += 1
    else:
        oddCounter += 1
print("Even numbers: ", evenCounter)
print("Odd numbers: ", oddCounter)