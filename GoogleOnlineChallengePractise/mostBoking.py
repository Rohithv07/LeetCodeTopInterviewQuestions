def mostBooking(array):
    dictionary = {}
    result = ''
    for element in array:
        if element in dictionary:
            dictionary[element] += 1
        else:
            dictionary[element] = 1
    for key, value in dictionary.items():
        if value > 1:
            result += key
    result = result.split('+')
    return ' '.join(result)
array1 = ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]

print(mostBooking(array1))

