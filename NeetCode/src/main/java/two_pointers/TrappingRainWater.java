package two_pointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,2,0,3,1,0,1,3,2,1};
        System.out.println("Resultado: " + trap(height));
    }

    public static int trap(int[] height) {
        if (height.length < 1 || height.length > 1000) {
            return 0;
        } else {
            int i = 0;
            int j = height.length - 1;
            int resultado = 0;
            int l = height[i];
            int r = height[j];
            while (i < j) {
                resultado += Math.max(0, Math.min(l, r) - height[i]);
                resultado += Math.max(0, Math.min(l, r) - height[j]);
                if(l < height[i]) {
                    l = height[i];
                }
                if(r < height[j]){
                    r = height[j];
                }
                if(l <= r) {
                    i++;
                } else {
                    j--;
                }
            }
            return resultado;
        }
    }
}
