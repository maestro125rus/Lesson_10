import java.util.Scanner;

public class Lesson_10_1 {
    public static final String HORIZONTAL_LINE = "==";
    public static final String VERTICAL_LINE = "||";
    public static final char ANGLE_SYMBOL = 0x20;
    public static final char RECTANGLE_INSIDE_SPACE_SYMBOL = 0x20;

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int length = requireInt(scanner, "Enter rectangle's length: ");
            int width = requireInt(scanner, "Enter rectangle's width: ");

            scanner.close();

            String horizontalLine = createHorizontalLine(length);
            String verticalLines = createVerticalLines(length, width);

            printRectangle(horizontalLine, verticalLines);
        }

        static int requireInt (Scanner scanner, String requiringMessage){
            System.out.print(requiringMessage);

            return scanner.nextInt();
        }

        static void printRectangle (String horizontalLine, String verticalLines){
            System.out.print(horizontalLine + verticalLines + horizontalLine);
        }
        static String createHorizontalLine ( int length){

            String angle = "";
            for (int i = 0; i < VERTICAL_LINE.length(); i++){
                angle += ANGLE_SYMBOL;
            }

            String horizontalLine = angle;

            for (int i = 0; i < length; i++) {
                horizontalLine += HORIZONTAL_LINE;
            }

            horizontalLine += angle + "\n";

            return horizontalLine;
        }

        static String createVerticalLines ( int length, int width){
            String verticalLinesUnit = getVerticalLinesUnit(length);

            String verticalLines = "";

            for (int i = 0; i < width; i++) {
                verticalLines += verticalLinesUnit;
            }
            return verticalLines;
        }

        static String getVerticalLinesUnit ( int length){
            String verticalLinesUnit = VERTICAL_LINE;

            for (int i = 0; i < length * HORIZONTAL_LINE.length(); i++) {
                verticalLinesUnit += RECTANGLE_INSIDE_SPACE_SYMBOL;
            }

            verticalLinesUnit += VERTICAL_LINE + "\n";
            return verticalLinesUnit;
        }
    }