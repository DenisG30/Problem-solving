7.1
status - isOrderCompleted
end - isTaskFinished
value - isElementValue
enabled - isFeatureEnabled
completed - isProcessCompleted

7.2
hasErrors
isCompleted 
isOnline 

7.3
int numRows = 5;
for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
}

7.4
String[] items = {"apple", "banana", "cherry"};
for (int startIndex = 0, endIndex = items.length - 1; startIndex <= endIndex; startIndex++, endIndex--) {
}
for (int topLevel = 0; topLevel < maxLevels; topLevel++) {
   for (int bottomLevel = maxLevels - 1; bottomLevel >= 0; bottomLevel--) {
   }
}

7.5

List<String> items = Arrays.asList("apple", "banana", "cherry");
int count = 0;
for (String item : items) {
    int temp = item.length(); 
    count += temp;
}

int count = 0;
for (String item : items) {
    count += item.length();
}






