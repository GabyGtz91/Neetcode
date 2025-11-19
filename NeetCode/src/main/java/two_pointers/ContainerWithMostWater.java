package two_pointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,7,2,5,4,7,3,6};
        System.out.println("resultado: " + maxArea(heights));
    }

    public static int maxArea(int[] heights) {
        if (heights.length < 2 || heights.length > 1000) {
            return 0;
        } else {
            int i = 0;
            int j = heights.length - 1;
            int cantidad = 0, aux = 0;
            while (i < j) {
                if (heights[i] < 0 || heights[i] > 1000 ||
                    heights[j] < 0 || heights[j] > 1000) {
                    return 0;
                } else {
                    aux = (j - i) * Math.min(heights[i], heights[j]);
                    if(cantidad < aux) {
                        cantidad = aux;
                    }
                    if (heights[i] < heights[j]) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
            return cantidad;
        }
    }
}
