public class Level1 {
    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {

        T = T % (2 * (M + N - 2)); 

        for (int layer = 0; layer < Math.min(M, N) / 2; layer++) {

            int elements = 2 * (M + N - 4 * layer) - 4; 
            if (elements <= 0) break;

            char[] layerElements = new char[elements];
            int index = 0;

            for (int j = layer; j < N - layer; j++) {
                layerElements[index++] = Matrix[layer].charAt(j);
            }
            
            for (int i = layer + 1; i < M - layer - 1; i++) {
                layerElements[index++] = Matrix[i].charAt(N - layer - 1);
            }
            
            for (int j = N - layer - 1; j >= layer; j--) {
                layerElements[index++] = Matrix[M - layer - 1].charAt(j);
            }
            
            for (int i = M - layer - 2; i > layer; i--) {
                layerElements[index++] = Matrix[i].charAt(layer);
            }


            char[] newLayer = new char[elements];
            for (int i = 0; i < elements; i++) {
                newLayer[(i + T) % elements] = layerElements[i];
            }

            index = 0;
            
            for (int j = layer; j < N - layer; j++) {
                Matrix[layer] = replaceCharAt(Matrix[layer], j, newLayer[index++]);
            }
            
            for (int i = layer + 1; i < M - layer - 1; i++) {
                Matrix[i] = replaceCharAt(Matrix[i], N - layer - 1, newLayer[index++]);
            }
            
            for (int j = N - layer - 1; j >= layer; j--) {
                Matrix[M - layer - 1] = replaceCharAt(Matrix[M - layer - 1], j, newLayer[index++]);
            }
            
            for (int i = M - layer - 2; i > layer; i--) {
                Matrix[i] = replaceCharAt(Matrix[i], layer, newLayer[index++]);
            }
        }
    }

    
    private static String replaceCharAt(String str, int index, char c) {
        return str.substring(0, index) + c + str.substring(index + 1);
    }  
}
