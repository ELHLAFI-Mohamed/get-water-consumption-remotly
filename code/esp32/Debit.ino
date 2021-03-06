#include <WiFi.h>
#include <Wire.h>
const char* ssid     = "Wifi";
const char* password = "12345678";
String num_region="1";
String num_secteur ="1";
String num_maison="1";
String id_compteur="5";

volatile int flow_frequency; // Measures flow sensor pulses
// Calculated litres/hour
 float vol = 0.0,l_minute;
unsigned char flowsensor = 4; // Sensor Input
unsigned long currentTime;
unsigned long cloopTime;
WiFiServer server(80);

void flow () // Interrupt function
{
   flow_frequency++;
}
void setup()
{
   pinMode(flowsensor, INPUT);
   digitalWrite(flowsensor, HIGH); // Optional Internal Pull-Up
   Serial.begin(115200);

   attachInterrupt(digitalPinToInterrupt(flowsensor), flow, RISING); // Setup Interrupt
   Wire.begin();
    WiFi.begin(ssid, password);
    

    while (WiFi.status() != WL_CONNECTED) {
       delay(500);
        Serial.print(".");
    }

    Serial.println("");
    Serial.println("WiFi connected.");
    Serial.println("IP address: ");
    Serial.println(WiFi.localIP());
    
    server.begin();
    Serial.println("le serveur a commence");

   Serial.print("Water Flow Meter\n");
   
  Serial.print("Circuit Digest\n");
   currentTime = millis();
   cloopTime = currentTime;
}
void loop ()
{ WiFiClient client = server.available();   // listen for incoming clients
   currentTime = millis();
   // Every second, calculate and print litres/hour
   if(currentTime >= (cloopTime + 1000))
   {
    cloopTime = currentTime; // Updates cloopTime
    if(flow_frequency != 0){
      // Pulse frequency (Hz) = 7.5Q, Q is flow rate in L/min.
      l_minute = (flow_frequency / 7.5); // (Pulse frequency x 60 min) / 7.5Q = flowrate in L/hour

      Serial.print("Rate:\n ");
      Serial.print(l_minute);
      Serial.print(" L/M");
      l_minute = l_minute/60;
    
      vol = vol +l_minute;
      Serial.print("Vol:\n");
      Serial.print(vol);
      Serial.print(" L\n");
      flow_frequency = 0; // Reset Counter
      Serial.print(l_minute, DEC); // Print litres/hour
      Serial.println(" L/Sec\n");
    }
    
   }
    
 
 if (client) {                             // if you get a client,
    Serial.println("New Client.");           // print a message out the serial port
  
      if (client.connected()) { 
        client.print(num_region+";"+ num_secteur+";"+num_maison+";"+id_compteur+";"+String(vol)+";"+String(l_minute));
       client.print("\n"); 
        
      }
      }
     
}
