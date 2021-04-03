# customer-management-MS
All customer related CRUD operations are being handled

# Create Payload

{
    "firstName": "Hasi",
    "lastName": "Sarkar",
    "userName": "hasi999",
    "type": "Prime",
    "email": "hashisarkar@gmail.com",
    "fax": "+123-4321",
    "mobile": "9062004063",
    "area": "31/3, kalinath munshi lane",
    "street": "Joy Naarayan banerjee lane",
    "city": "Kolkata",
    "country": "India",
    "zipcode": "700036",
    "state": "WB",
    "caseListIds": []
}


# Patch Payload 
{
    "op": "replace",
    "path": "/value/state",
    "value": "WB"
}
