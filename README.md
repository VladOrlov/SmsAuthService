# TwilioSmsAuthService

### Additionnal resources:

1. https://www.twilio.com/ - register Twilio account
2. http://www.receive-sms-online.info/read-sms.php?phone=14053264519 - Read test messages

### HOWTO Start:

**1. Clone project:**
    
    $ git clone https://github.com/sealTLV/TwilioSmsAuthService

**2. Edit configuration-file: `application.properties`**
  
    $ cd TwilioSmsAuthService/complete/src/main/resources
    $ gedit application.properties
  
  **Pay attention for:**
    `#DB properties`
    `#sms-twilio-credentials`
    `#sms-admin`
  
**3. Run:**

    $ cd TwilioSmsAuthService/complete
    $ mvn spring-boot:run -Dserver.port=8787
    
**4. Read API-documentation:** http://localhost:8787/swagger-ui.html


### HOWTO DOCKER:

**1. Register repository `twilio-sms-verification-service`**

**2. Build and upload image to Docker**

    $ cd TwilioSmsAuthService/complete
    $ mvn clean package docker:build
    $ docker login --username=luizavladislavna --email=luizavladislavna@gmail.com
    $ docker push luizavladislavna/twilio-sms-verification-service
    
    $ docker run -p 8787:8080 luizavladislavna/twilio-sms-verification-service

Go to: http://localhost:8787/swagger-ui.html
