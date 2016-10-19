Sms Authentication Service
==========================

### Additionnal resources:


1. https://www.twilio.com/      - create **Twilio** account
2. https://www.clickatell.com   - or **Clickatell** account
3. http://www.receive-sms-online.info/read-sms.php?phone=14053264519 - Read test messages

### HOWTO Start:

**1. Clone project:**
    
    $ git clone https://github.com/sealTLV/SmsAuthService

**2. Edit configurations:**
  
    $ cd SmsAuthService/complete/src/main/resources
    $ gedit database.properties
    $ gedit application.properties
  
  **ATTENTION: You have to fill credentials for Twilio or Clickatell messenger API:**

    $ gedit twilio.properties
    - or:
    $ gedit clickatell.properties
    
  
**3. Run:**

    $ cd SmsAuthService/complete
    $ mvn spring-boot:run -Dserver.port=8787
    
**4. Read API-documentation:** http://localhost:8787/swagger-ui.html


### HOWTO DOCKER:

**1. Register repository `sms-verification-service`**

**2. Build and upload image to Docker**

    $ cd SmsAuthService/complete
    $ mvn clean package docker:build -Dmaven.test.skip=true
    $ docker login --username=luizavladislavna --email=luizavladislavna@gmail.com
    $ docker push luizavladislavna/sms-verification-service
    
    $ docker run -p 8787:8080 luizavladislavna/sms-verification-service

Go to: http://localhost:8787/swagger-ui.html
