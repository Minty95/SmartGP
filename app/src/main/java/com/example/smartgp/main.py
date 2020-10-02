import json

path = "C:/Users/Min/PycharmProjects/CleaningData/chas-clinics-json.json"
cleanedClinic = {}
cleanedLocation = {}
listOfdict =[]
data4=[]
with open(path) as json_file:

    data = json.load(json_file)
    for x in range(1167):
        cleanedClinic={}
        cleanedClinic["clinicName"] = data[x]['HCI_NAME']
        cleanedClinic["address"] = str("Block " + data[x]['BLK_HSE_NO'] + ' ' + data[x]['STREET_NAME'] +" "+ "#"+data[x]['FLOOR_NO'] +'-'+data[x]['UNIT_NO']+" "+ "Postal Code: " +str(data[x]['POSTAL_CD']))
        cleanedClinic["openingHour"] = str('0800-1800')
        cleanedClinic["clinicPhoneNo"] = str("+65 "+ str(data[x]["HCI_TEL"])[0:4] + ' ' + str(data[x]["HCI_TEL"])[4:8])
        listOfdict.append(cleanedClinic)

print(listOfdict)
with open('Cleaned-clinic.json', 'w') as outfile:
    json.dump(listOfdict, outfile)
with open(path) as json_file:

    data = json.load(json_file)
    for y in range(0,1000):
        # print(data[y])
        cleanedLocation={}
        cleanedLocation["clinicId"] = y
        cleanedLocation["coordinates"] = str('X: ' + str(data[y]['X']) + ' ' + "Y: " + str(data[y]['Y']))
        cleanedLocation["postalCode"] = data[y]['POSTAL_CD']
        print(cleanedLocation["clinicId"])
        print(cleanedLocation["postalCode"])
        data4.append(cleanedLocation)
with open('cleaned-location.json', 'w') as outfile:
    json.dump(data4, outfile)






