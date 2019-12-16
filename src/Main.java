import java.util.Arrays;

public class Main {

    private static String hexColor(int r, int g, int b) {
        return ("#" + decimalToHex(r) + decimalToHex(g) + decimalToHex(b)).toUpperCase();
    }

    private static String decimalToHex(int decimal) {
        String hex = "";
        while (decimal > 0 || hex.length() < 2) {
            hex = Integer.toHexString(decimal % 16) + hex;
            decimal /= 16;
        }
        return hex;
    }

    private static int[] rgb(String hexColor) {
        int[] rgb = new int[3];
        String color = hexColor.substring(1);
        for (int i = 0, j = 0; i < color.length() - 1; i += 2, j++) {
            String hex = color.substring(i, i + 2);
            rgb[j] = Integer.parseInt(hex, 16);
        }
        return rgb;
    }

    // Normally should be done with gamma correction
    private static String blend(String[] hexColors) {
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;
        for (int i = 0; i < hexColors.length; i++) {
            String color = hexColors[i];
            int[] rgb = rgb(color);
            totalRed += rgb[0];
            totalGreen += rgb[1];
            totalBlue += rgb[2];
        }
        int len = hexColors.length;
        return hexColor(totalRed / len, totalGreen / len, totalBlue / len);
    }

    public static void main(String[] args) {
        System.out.println(hexColor(255, 99, 71));
        System.out.println(hexColor(0, 0, 205));
        System.out.println(hexColor(189, 183, 107));

        System.out.println("Blended: " + blend(new String[] {"#E6E6FA", "#FF69B4", "#B0C4DE"} ));
    }
}
