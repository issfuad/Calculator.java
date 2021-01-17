package fuad305;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean keepRunningLoop = true;
        while (keepRunningLoop) {
            System.out.println("Please Enter 1 for Binary Calculator\n" +
                               "Please Enter 2 for Hexadecimal Calculator\n" +
                               "Please Enter 3 for Bandwidth Calculator\n" +
                               "Please Enter 4 to exit the program\n" +
                               "Please Enter 5 test");
            int calcInput = scanner.nextInt();
            switch (calcInput) {
                case 1:
                    System.out.println("Please Enter 1 to Convert Binary numbers to Decimal Numbers \n" +
                                       "Please Enter 2 to Convert Decimal numbers to Binary Numbers \n" +
                                       "Please Enter 3 to perform Binary Computations \n" +
                                       "Press 4 to exits the program");
                    calcInput = scanner.nextInt();
                    String number;
                    switch (calcInput) {
                        case 1:
                            System.out.println("Please Enter Binary Number");
                            number = scanner.next();
                            System.out.println(binToDec(number));
                            break;
                        case 2:
                            System.out.println("Please Enter Decimal Number");
                            int decinput = scanner.nextInt();
                            System.out.println(decToBin(decinput));
                            break;
                        case 3:
                            System.out.println("Please enter first Binary number");
                            String num1 = scanner.next();
                            System.out.println("Please enter 2nd Binary number");
                            String num2 = scanner.next();
                            System.out.println("Please enter Operation + - * /");
                            char operation = scanner.next().charAt(0);
                            switch (operation) {
                                case '+':
                                    System.out.println(addBinaryNumbers(num1, num2));
                                    break;
                                case '-':
                                    System.out.println(subBinaryNumbers(num1, num2));
                                    break;
                                case '*':
                                    System.out.println(mulBinaryNumbers(num1, num2));
                                    break;
                                case '/':
                                    System.out.println(divBinaryNumbers(num1, num2));
                                    break;
                                default:
                                    System.out.println("Invalid input please try again");
                                    break;
                            }

                            break;
                        case 4:
                            keepRunningLoop = false;
                        default:
                            System.out.println("Invalid input");

                    }
                    break;

                case 2:
                    System.out.println("Please Enter 1 to Convert Hexadecimal numbers to Decimal Numbers \n" +
                                       "Please Enter 2 to Convert Decimal numbers to Hexadecimal Numbers \n" +
                                       "Please Enter 3 to perform Hexadecimal Computations \n" +
                                       "Press 4 to exits the program");
                    calcInput = scanner.nextInt();
                    switch (calcInput) {
                        case 1:
                            System.out.println("Please Enter Hexadecimal Number");
                            number = scanner.next();
                            System.out.println(hexToDecimal(number));
                            break;
                        case 2:
                            System.out.println("Please Enter Decimal Number");
                            int decinput = scanner.nextInt();
                            System.out.println(decToHex(decinput));
                            break;
                        case 3:
                            System.out.println("Please enter first Hexadecimal number");
                            String num1 = scanner.next();
                            System.out.println("Please enter 2nd Hexadecimal number");
                            String num2 = scanner.next();
                            System.out.println("Please enter Operation + - * /");
                            char operation = scanner.next().charAt(0);
                            switch (operation) {
                                case '+':
                                    System.out.println(addHexNumbers(num1, num2));
                                    break;
                                case '-':
                                    System.out.println(subHexNumbers(num1, num2));
                                    break;
                                case '*':
                                    System.out.println(mulHexNumbers(num1, num2));
                                    break;
                                case '/':
                                    System.out.println(divHexNumbers(num1, num2));
                                    break;
                                default:
                                    System.out.println("Invalid input please try again");
                                    break;
                            }
                            break;
                        case 4:
                            keepRunningLoop = false;
                        default:
                            System.out.println("Invalid input");

                    }

                    break;
                case 3:

                    System.out.println("For Data Unit Converter Enter 1\n" +
                                       "For Download/Upload Time Calculator Enter 2\n" +
                                       "Website Bandwidth Calculator Enter 3\n" +
                                       "For Hosting Bandwidth Converter Enter 4\n" +
                                       "Terminate the program Enter 5");
                    int input = scanner.nextInt();
                    switch (input){
                        case 1:
                            System.out.println("Enter number of bits and bytes");
                            double data = scanner.nextDouble();
                            System.out.println("Enter unit like b, kb, mb, gb, tb, B, KB, MB, KB, GB, TB");
                            String unit = scanner.next();
                            dataUnitConverter(data, unit);
                            break;
                        case 2:
                            System.out.println("Enter the file size and its units Bytes KB MB GB TB");
                            long fileSize = scanner.nextLong();
                            String fileUnits = scanner.next();

                            System.out.println("Enter the Bandwidth and its units bits kb mb gb tb");
                            long bandwidth = scanner.nextLong();
                            String bandwidthUnits = scanner.next();
                            downloadUploadTimeCalculator(fileSize,fileUnits,bandwidth,bandwidthUnits);
                            break;

                        case 3:
                            System.out.println("Enter pages views  and Page view unit Per s, min, h, d, w, M, Y");
                            int pageView = scanner.nextInt();
                            String pageViewUnit=scanner.next();

                            System.out.println("Page size and page size unit B KB MB GB TB");
                            int pageSize = scanner.nextInt();
                            String pageSizeUnit=scanner.next();
                            System.out.println("Enter Redundancy factor");
                            int redundFact = scanner.nextInt();
                            websiteBandwidthCalculator(pageView,pageViewUnit,pageSize,pageSizeUnit,redundFact);
                        case 4:
                            System.out.println("Enter bandwidth in GB");
                            double bandwidthGB = scanner.nextDouble();
                            hostingBandwidthCalculator(bandwidthGB);


                    }


                    break;
                case 4:
                    keepRunningLoop = false;
                    break;
                case 5:
                    testCalculators();
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }
    }


    public static void websiteBandwidthCalculator(double pageViews,String pageViewUnit,double averagePageSize,String avgPSizeUnit,double reduntF){

        double bandwidthBitsGB=0;
        double bandwidthBitsMb=0;
        switch (avgPSizeUnit) {
            case "B":
                bandwidthBitsGB = averagePageSize/1000000000;
                break;
            case "KB":
                bandwidthBitsGB = averagePageSize/1000000;
                break;
            case "MB":
                bandwidthBitsGB = averagePageSize/1000;
                break;
            case "GB":
                bandwidthBitsGB = averagePageSize;
                break;
            case "TB":
                bandwidthBitsGB = averagePageSize* 1000L;
                break;
        }
        switch (pageViewUnit){
            case "s":
                bandwidthBitsGB= bandwidthBitsGB*30*24*3600;
                break;

            case "min":
                bandwidthBitsGB= bandwidthBitsGB*30*24*60;
                break;
            case "h":
                bandwidthBitsGB= bandwidthBitsGB*30*24;
                break;
            case"d":
                bandwidthBitsGB= bandwidthBitsGB*30;
                break;
            case "w":
                bandwidthBitsGB= bandwidthBitsGB*4;
                break;
            case "m":
                break;
            case "y":
                bandwidthBitsGB= bandwidthBitsGB/12;
                break;

        }
        bandwidthBitsGB=bandwidthBitsGB* pageViews;

        bandwidthBitsMb=bandwidthBitsGB*1000*8/(30*24*3600);
        System.out.println("Actual bandwidth needed is "+bandwidthBitsMb+" Mbits/s or "+bandwidthBitsGB+"\n" +
                " GB per month" +"With redundancy factor of "+reduntF+",Actual bandwidth needed is "+(bandwidthBitsMb*reduntF)+" Mbits/s or "+(bandwidthBitsGB*reduntF)+"\n GB per month" );


    }

    public static void hostingBandwidthCalculator(double bandwidthBitsGB){


        double   bandwidthBitsMb=bandwidthBitsGB*1000*8/(30*24*3600);
        System.out.println(bandwidthBitsGB+" Gigabytes (GB) per month is equivalent to "+bandwidthBitsMb+" Mbit/s");
    }
    public static void downloadUploadTimeCalculator(long fileSize, String fileSizeUnit, long bandwidth, String bandwidthUnit) {
        long fileBits = 0;
        long bandwidthBits = 0;

        long time = 0;
        switch (fileSizeUnit) {
            case "B":
                fileBits = 8 * fileSize;
                break;
            case "KB":
                fileBits = 8 * 1000 * fileSize;
                break;
            case "MB":
                fileBits = 1000000L * fileSize * 8;
                break;
            case "GB":
                fileBits = 1000000000L * fileSize * 8;
                break;
            case "TB":
                fileBits = 1000000000000L * fileSize * 8;
        }
        switch (bandwidthUnit) {
            case "b":
                bandwidthBits = bandwidth;
                break;
            case "kb":
                bandwidthBits = 1000 * bandwidth;
                break;
            case "mb":
                bandwidthBits = 1000000L * bandwidth;
                break;
            case "gb":
                bandwidthBits = 1000000000L * bandwidth;
                break;
            case "tb":
                bandwidthBits = 1000000000000L * bandwidth;
        }
        time =  fileBits / bandwidthBits;
        long second = 0;
        long minutes = 0;
        long hours = 0;
        String strTime = "";
        if (time >= 60) {
            second = time % 60;
            minutes = time / 60;
            if (minutes >= 60) {
                hours = minutes / 60;
                minutes = minutes % 60;
            }
        } else {
            second = time;
        }

        if (second > 0) {
            strTime = second + " Seconds";
            if (minutes > 0) {
                strTime = minutes + " Minutes " + strTime;
                if (hours > 0) {
                    strTime = hours + " Hours " + strTime;
                }
            }
        }

        System.out.println(strTime);

    }

    public static void testCalculators() {
        System.out.println("Testing Binary calculator");
        System.out.println("Converting 10 to decimal expected results 2");
        Integer integer = binToDec("10");
        if (integer == 2) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }

        System.out.println("Testing Binary calculator");
        System.out.println("Converting 2D to Binary expected results 10");
        String results = decToBin(2);
        if (results.equals("10")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }


        System.out.println("Testing Hexadecimal calculator");
        System.out.println("Converting 16 to decimal expected results 22");
        integer = hexToDecimal("16");
        if (integer == 22) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }

        System.out.println("Testing Hexadecimal calculator");
        System.out.println("Converting 22D to hexadecimal expected results 16");
        results = decToHex(22);
        if (results.equals("16")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }


    }

    /**
     * Method to convert bandwidth units
     *
     * @param data
     * @param unit
     */
    public static void dataUnitConverter(double data, String unit) {
        //first converting to bits
        double bits = 0;
        switch (unit) {
            case "b":
                bits = data;
                break;
            case "kb":
                bits = 1000L * data;
                break;
            case "mb":
                bits = 1000000L * data;
                break;
            case "gb":
                bits = 1000000000L * data;
                break;
            case "tb":
                bits = 1000000000000L * data;
                break;
            case "B":
                bits = data * 8;
                break;
            case "KB":
                bits = 1000L * data * 8;
                break;
            case "MB":
                bits = 1000000L * data * 8;
                break;
            case "GB":
                bits = 1000000000L * data * 8;
                break;
            case "TB":
                bits = 1000000000000L * data * 8;

        }
        /*
        converting to all the units
         */
        System.out.println(bits + " bits (b)");
        System.out.println(bits / 1000 + " kilobits (kb)");
        System.out.println(bits / 1000000 + " megabits (mb)");
        System.out.println(bits / 1000000000 + " gigabits (gb)");
        System.out.println(bits / 1000000000000L + " terabits (tb)");

        System.out.println(bits / (8) + " bytes");
        System.out.println(bits / (1000 * 8) + " kilobits (KB)");
        System.out.println(bits / (1000000 * 8) + " kilobits (MB)");
        System.out.println(bits / (1000000000L * 8) + " kilobits (GB)");
        System.out.println(bits / (1000000000000L * 8) + " kilobits (TB)");


    }

    /**
     * method to add two binary numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addBinaryNumbers(String num1, String num2) {
        int decNum1 = binToDec(num1);
        int decNum2 = binToDec(num2);
        int sum = decNum1 + decNum2;
        return decToBin(sum);
    }

    /**
     * method to add Hexadecimal numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addHexNumbers(String num1, String num2) {
        int decNum1 = hexToDecimal(num1);
        int decNum2 = hexToDecimal(num2);
        int sum = decNum1 + decNum2;
        return decToHex(sum);
    }

    /**
     * method to subtract Hexadecimal numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String subHexNumbers(String num1, String num2) {
        int decNum1 = hexToDecimal(num1);
        int decNum2 = hexToDecimal(num2);
        int sum = decNum1 - decNum2;
        return decToHex(sum);
    }

    /**
     * method to Multiply Hexadecimal numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String mulHexNumbers(String num1, String num2) {
        int decNum1 = hexToDecimal(num1);
        int decNum2 = hexToDecimal(num2);
        int sum = decNum1 * decNum2;
        return decToHex(sum);
    }

    /**
     * method to Divide Hexadecimal numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String divHexNumbers(String num1, String num2) {
        int decNum1 = hexToDecimal(num1);
        int decNum2 = hexToDecimal(num2);
        int sum = decNum1 / decNum2;
        return decToHex(sum);
    }

    /**
     * method to subtract Binary numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String subBinaryNumbers(String num1, String num2) {
        int decNum1 = binToDec(num1);
        int decNum2 = binToDec(num2);
        int sum = decNum1 - decNum2;
        return decToBin(sum);
    }

    /**
     * method to Multiply Binary numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String mulBinaryNumbers(String num1, String num2) {
        int decNum1 = binToDec(num1);
        int decNum2 = binToDec(num2);
        int sum = decNum1 * decNum2;
        return decToBin(sum);
    }

    /**
     * method to Divide Binary numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String divBinaryNumbers(String num1, String num2) {
        int decNum1 = binToDec(num1);
        int decNum2 = binToDec(num2);
        int sum = decNum1 / decNum2;
        return decToBin(sum);

    }

    /**
     * method to convert hexadecimnal numbers to decimal numbers
     *
     * @param hexnum
     * @return
     */
    public static int hexToDecimal(String hexnum) {
        String hstring = "0123456789ABCDEF";
        hexnum = hexnum.toUpperCase();
        int num = 0;
        for (int i = 0; i < hexnum.length(); i++) {
            char ch = hexnum.charAt(i);
            int n = hstring.indexOf(ch);
            num = 16 * num + n;
        }
        return num;
    }

    /**
     * method to convert decimal numbers to hexadecimal numbers
     *
     * @param num
     * @return
     */
    public static String decToHex(int num) {
        int rem = 0;

        String str2 = "";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (num > 0) {
            rem = num % 16;
            str2 = hex[rem] + str2;
            num = num / 16;
        }

        return str2;
    }

    /**
     * method to convert binary numbers to decimals numbers
     *
     * @param binVal
     * @return
     */
    public static Integer binToDec(String binVal) {
        for (int i = 0; i < binVal.length(); i++) {
            if (!(binVal.charAt(i) == '0' || binVal.charAt(i) == '1')) {
                throw new InputMismatchException("Incorrect Binary number");
            }
        }
        //10101  1   5-1-0=4
        int weight = 1, answer = 0;
        for (int i = 0; i < binVal.length(); i++) {
            answer += (binVal.charAt(binVal.length() - 1 - i) - '0') * weight;
            weight *= 2;
        }
        return answer;
    }

    /**
     * method to convert decimal number to binary
     *
     * @param decVal
     * @return
     */
    public static String decToBin(Integer decVal) {
        String answer = "";
        while (decVal > 0) {
            answer = decVal % 2 + answer;
            decVal /= 2;
        }
        return (answer.equals("")) ? "0" : answer;
    }
}
