public class Level1 {
    private static String nStr = "";
    private static String[] undoArr = new String[100];
    private static String[] redoArr = new String[100];
    private static int undoId = -1;
    private static int redoId = -1;

    public static String BastShoe(String command) {
        String[] commandArr = command.split(" ", 2);
        if (commandArr.length == 0) return nStr;

        int number;
        try {
            number = Integer.parseInt(commandArr[0]);
        } catch (NumberFormatException e) {
            return nStr;
        }

        switch (number) {
            case 1:
                return add(commandArr);
            case 2: 
                return delete(commandArr);
            case 3: 
                return getChar(commandArr);
            case 4: 
                return undo();
            case 5: 
                return redo();
            default:
                return nStr;
        }
    }

    private static String add(String[] commandArr) {
        if (commandArr.length < 2) return nStr;

        String toAdd = commandArr[1];
        nStr += toAdd; 

        if (undoId < undoArr.length - 1) {
            undoArr[++undoId] = "-" + toAdd; 
        }
        redoId = -1; 
        return nStr;
    }

    private static String delete(String[] commandArr) {
        if (commandArr.length < 2) return nStr;

        int num;
        try {
            num = Integer.parseInt(commandArr[1]);
        } catch (NumberFormatException e) {
            return nStr;
        }

        String deleted = "";
        if (num > nStr.length()) {
            deleted = nStr; 
            nStr = ""; 
        } else {
            deleted = nStr.substring(nStr.length() - num); 
            nStr = nStr.substring(0, nStr.length() - num); 
        }

        if (undoId < undoArr.length - 1) {
            undoArr[++undoId] = deleted; 
        }
        redoId = -1; 
        return nStr;
    }

    private static String getChar(String[] commandArr) {
        if (commandArr.length < 2) return "";

        int id;
        try {
            id = Integer.parseInt(commandArr[1]);
        } catch (NumberFormatException e) {
            return "";
        }

        if (id < 0 || id >= nStr.length()) {
            return "";
        }

        return String.valueOf(nStr.charAt(id));
    }

    private static String undo() {
        if (undoId < 0) return nStr; 

        String lastOperation = undoArr[undoId--];

        if (lastOperation.startsWith("-")) { 
            nStr = nStr.substring(0, nStr.length() + lastOperation.length() - 1); 
        } else { 
            nStr += lastOperation; 
        }

        // Добавляем в Redo стек
        if (redoId < redoArr.length - 1) {
            redoArr[++redoId] = lastOperation;
        }
        return nStr;
    }

    private static String redo() {
        if (redoId < 0) return nStr; 

        String lastRedoOperation = redoArr[redoId--];
        
        if (lastRedoOperation.startsWith("-")) { 
            nStr += lastRedoOperation.substring(1);
        } else { 
            int lengthToDelete = lastRedoOperation.length();
            nStr = nStr.substring(0, nStr.length() - lengthToDelete); 
        }

        // Добавляем в Undo стек
        if (undoId < undoArr.length - 1) {
            undoArr[++undoId] = lastRedoOperation;
        }

        return nStr;
    }
}
