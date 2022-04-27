 
#include <LiquidCrystal.h>
#include <Keypad.h>

LiquidCrystal lcd(13, 12, 8, 9, 10, 11);

const byte rows = 4; //four rows
const byte cols = 4; //three columns
char keys[rows][cols] = {
  {'1','2','3','A'},
  {'4','5','6','B'},
  {'7','8','9','C'},
  {'*','0','#','D'}
};
byte rowPins[rows] = {7, 6, 5, 4}; //connect to the row pinouts of the keypad
byte colPins[cols] = {3, 2, 1, 0};
int LCDCol = 0;
int LCDRow = 0;//connect to the column pinouts of the keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, rows, cols );
  
void setup() {
  lcd.begin(16,2);
 // lcd.setCursor(LCDCol, LCDRow);
  lcd.print("Enter a Key");
  
}

void loop() {
  
  char key = keypad.getKey();
  if(key!= NO_KEY){
 
 lcd.clear();
  lcd.print(key);
}
}
