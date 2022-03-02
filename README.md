# companies

From this coding exercise, we would like to see your experience on building a RESTful APIs using Spring Boot with Companies House.

Please refer to Companies House Public API  https://developer-specs.company-information.service.gov.uk/companies-house-public-data-api/reference for the following API call

GET /company/{companyNumber}

 To integrate with this API requires an APIKey. You can create a free Companies House account to get the APIKey.

 Please refer to the documentation here:

https://developer-specs.company-information.service.gov.uk/guides/gettingStarted

Taking the above use case, could you build:

1. Controller class which exposes a method for the API consumer to search for the company based on the companyNumber provided.
2. Service class to build the business logic to:
• Integrate with the Companies House Get Company API
• Store the result of the companies’ house query into a local database
