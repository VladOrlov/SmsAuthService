# TwilioSmsAuthService

### Additionnal resources:

1. https://www.twilio.com/ - register Twilio account
2. http://www.receive-sms-online.info/read-sms.php?phone=14053264519 - Read test messages

### HOWTO start:

**1. Clone project:**
    
    `$ git clone https://github.com/sealTLV/TwilioSmsAuthService`

**2. Edit configuration-file: `application.properties`**
  
    `$ cd TwilioSmsAuthService/complete/src/main/resources`
    `$ gedit application.properties`  
  
  **Pay attention for:**
    `#DB properties`
    `#sms-twilio-credentials`
    `#sms-admin`
  
**3. Run:**

    `$ cd TwilioSmsAuthService/complete`
    `$ mvn spring-boot:run`
    
**4. Read API-documentation:** `http://localhost:9999/swagger-ui.html`


