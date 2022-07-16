import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        String input;

        try (Scanner sc = new Scanner(System.in)) {
            input = sc.nextLine();
//				input = "X + IV"; //debug
        }

        String result = null;
        try
        {
            result = calc(input);
            System.out.println(result);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static String calc(String input) throws Exception
    {
        String[] inputArr;

        if(!CheckCorrect.CheckActionOperator(input))
            throw new Exception("Invalid format operator");

        if(input.contains(" "))
            inputArr = input.split(" ");
        else
            throw new Exception("Invalid input format, possibly no spaces");

        if(!CheckCorrect.CheckCorrectLengthInput(inputArr))
            throw new Exception("Only two operands and one operator allowed");

        String firstNumStr = inputArr[0];
        String secondNumStr = inputArr[2];

        boolean isArabicNumerals = ArabicNumerals.isArabicNumeralsAndCheckRange(firstNumStr, secondNumStr);
        boolean isRomanNumerals = RomanNumerals.isRomanNumeralsAndCheckRange(firstNumStr, secondNumStr);
        if(!isArabicNumerals && !isRomanNumerals)
            throw new Exception("Invalid input or number out of range(1-10).");

        int firstNumber = 0, secondNumber = 0;

        if(isArabicNumerals)
        {
            firstNumber = ArabicNumerals.paseArabicNumeral(firstNumStr);
            secondNumber = ArabicNumerals.paseArabicNumeral(secondNumStr);
        }
        else if(isRomanNumerals)
        {
            firstNumber = RomanNumerals.convertRomanNumeralsStringToInt(firstNumStr);
            secondNumber = RomanNumerals.convertRomanNumeralsStringToInt(secondNumStr);
        }


        String actionOperatorStr = inputArr[1];

        String resultStr;
        int result = Maths(firstNumber, secondNumber, actionOperatorStr);

        if(isRomanNumerals)
        {
            if(result < 1)
                throw new Exception("there are no negative numbers in the roman system.");

            resultStr = RomanNumerals.convertRomanNumeralsIntToString(result);
        }

        else
            resultStr = String.valueOf(result);

        return resultStr;

    }


    static int Maths(int num1, int num2, String operator)
    {
        int result;

        switch (operator)
        {
            case "+" ->
            {
                result = num1 + num2;
                return result;
            }
            case "-" -> {
                result = num1 - num2;
                return result;
            }

            case "*" -> {
                result = num1 * num2;
                return result;
            }
            case "/" -> {
                result = num1 / num2;
                return result;
            }
            default ->
                    throw new IllegalArgumentException("Неразрешенный оператор " + operator + " (доступно - +, -, /, *)");
        }
    }

}